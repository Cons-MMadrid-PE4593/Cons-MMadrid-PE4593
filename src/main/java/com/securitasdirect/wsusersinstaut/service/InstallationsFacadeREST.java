package com.securitasdirect.wsusersinstaut.service;

import com.securitasdirect.wsusersinstaut.entity.Installations;
import com.securitasdirect.wsusersinstaut.entity.InstallationsPK;
import com.securitasdirect.wsusersinstaut.entity.InstallationsUsers;
import com.securitasdirect.wsusersinstaut.entity.Users;
import com.securitasdirect.wsusersinstaut.service.AbstractFacade;
import com.securitasdirect.wsusersinstaut.service.util.Constantes;
import com.securitasdirect.wsusersinstaut.util.beans.UserInst;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import org.jboss.logging.Logger;

@Stateless
@Path("verisureweb/installations")
public class InstallationsFacadeREST extends AbstractFacade<Installations> {
	private static final Logger logger = Logger
			.getLogger(com.securitasdirect.wsusersinstaut.service.InstallationsFacadeREST.class);

	@PersistenceContext(unitName = "WSUsersInstAutomatationPU")
	private EntityManager em;

	private InstallationsPK getPrimaryKey(PathSegment pathSegment) {
		InstallationsPK key = new InstallationsPK();
		MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
		List<String> idCountry = (List<String>) map.get("idCountry");
		if (idCountry != null && !idCountry.isEmpty()) {
			key.setIdCountry((new Integer(idCountry.get(0))).intValue());
		}
		List<String> numinst = (List<String>) map.get("numinst");
		if (numinst != null && !numinst.isEmpty()) {
			key.setNuminst(numinst.get(0));
		}
		return key;
	}

	public InstallationsFacadeREST() {
		super(Installations.class);
	}

	@POST
	@Consumes({ "application/xml", "application/json" })
	public void create(Installations entity) {
		super.create(entity);
	}

	@PUT
	@Path("{id}")
	@Consumes({ "application/xml", "application/json" })
	public void edit(@PathParam("id") PathSegment id, Installations entity) {
		edit(entity);
	}

	@DELETE
	@Path("{id}")
	public void remove(@PathParam("id") PathSegment id) {
		InstallationsPK key = getPrimaryKey(id);
		remove(find(key));
	}

	@GET
	@Path("{id}")
	@Produces({ "application/xml", "application/json" })
	public Installations find(@PathParam("id") PathSegment id) {
		InstallationsPK key = getPrimaryKey(id.toString());
		return (Installations) find(key);
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	public List<Installations> findAll() {
		return super.findAll();
	}

	@GET
	@Path("{from}/{to}")
	@Produces({ "application/xml", "application/json" })
	public List<Installations> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
		return findRange(new int[] { from.intValue(), to.intValue() });
	}

	@GET
	@Path("count")
	@Produces({ "text/plain" })
	public String countREST() {
		return String.valueOf(count());
	}

	protected EntityManager getEntityManager() {
		return this.em;
	}
	
	@GET
	@Path("funions/byinst/{numinst}")
	@Produces({ "application/xml", "application/json" })
	public List<UserInst> findUnionByNuminst(@PathParam("numinst") PathSegment numinst) {
		if (logger.isInfoEnabled()) {
			logger.info("Find all users from installations/funions/byinst/" + numinst.toString());
		}
		List<UserInst> users = new ArrayList<>();
		try {
			Query qryInstallation = this.em.createNamedQuery("Installations.findByNuminst");
			String numinstStr = numinst.toString();
			qryInstallation.setParameter("numinst", numinstStr);
			Installations inst = (Installations) qryInstallation.getSingleResult();

			Query qryInstUsers = this.em.createNamedQuery("InstallationsUsers.findByIdInstallation");
			qryInstUsers.setParameter("installationid", Integer.valueOf(inst.getIdInst()));
			List<InstallationsUsers> instsUsersList = qryInstUsers.getResultList();

			for (InstallationsUsers instUser : instsUsersList) {

				Query qryUsers = this.em.createNamedQuery("Users.findUserById");
				qryUsers.setParameter("idUser", Integer.valueOf(instUser.getInstsUsersPK().getIdUser()));
				Users userBD = (Users) qryUsers.getSingleResult();
				UserInst userList = new UserInst();
				userList.setBlocked(userBD.getBlocked());
				userList.setEmail(userBD.getEmail());
				userList.setIdLanguage(userBD.getIdLanguage());
				userList.setIdUser(userBD.getIdUser());
				userList.setLastPasswordReset(userBD.getLastPasswordReset());
				userList.setLegalsCondAccepted(userBD.getLegalsCondAccepted());
				userList.setLogin(userBD.getUsersPK().getLogin());
				userList.setMainUser(userBD.getMainUser());
				userList.setOperationalCode(userBD.getOperationalCode());
				userList.setPhone(userBD.getPhone());
				userList.setPinBloqueo(userBD.getPinBloqueo());
				userList.setTrialsCounter(userBD.getTrialsCounter());
				userList.setUserCreationDate(userBD.getUserCreationDate());
				userList.setInstallations(numinstStr);
				users.add(userList);
			}
		} catch (Exception e) {
			if (logger.isEnabled(Logger.Level.ERROR)) {
				logger.info("Error: KO installations/funions/byinst/" + e.getMessage());
			}
		}
		if (logger.isInfoEnabled()) {
			logger.info("All users delivery OK from installations/funions/byinst/" + numinst.toString());
		}

		return users;
	}

	@GET
	@Path("funions/byinst/{numinst}/{country}")
	@Produces({ "application/xml", "application/json" })
	public List<UserInst> findUnionByNuminstMC(@PathParam("numinst") PathSegment numinst, @PathParam("country") PathSegment country) {
		if (logger.isInfoEnabled()) {
			logger.info("Find all users from installations/funions/byinst/" + numinst.toString() + "/" + country.toString());
		}
		List<UserInst> users = new ArrayList<>();
		if (null != Constantes.countryIds.get(country.toString())) {
			int idCountry = Constantes.countryIds.get(country.toString());
			try {
				Query qryInstallation = this.em.createNamedQuery("Installations.findByNuminstMC");
				String numinstStr = numinst.toString();
				qryInstallation.setParameter("numinst", numinstStr);
				qryInstallation.setParameter("idCountry", idCountry);
				Installations inst = (Installations) qryInstallation.getSingleResult();

				Query qryInstUsers = this.em.createNamedQuery("InstallationsUsers.findByIdInstallation");
				qryInstUsers.setParameter("installationid", Integer.valueOf(inst.getIdInst()));
				List<InstallationsUsers> instsUsersList = qryInstUsers.getResultList();

				for (InstallationsUsers instUser : instsUsersList) {

					Query qryUsers = this.em.createNamedQuery("Users.findUniqueByIdUserIdCountry");
					qryUsers.setParameter("idUser", Integer.valueOf(instUser.getInstsUsersPK().getIdUser()));
					qryUsers.setParameter("idCountry", Integer.valueOf(Integer.valueOf(idCountry)));
					Users userBD = (Users) qryUsers.getSingleResult();
					UserInst userList = new UserInst();
					userList.setBlocked(userBD.getBlocked());
					userList.setEmail(userBD.getEmail());
					userList.setIdLanguage(userBD.getIdLanguage());
					userList.setIdUser(userBD.getIdUser());
					userList.setLastPasswordReset(userBD.getLastPasswordReset());
					userList.setLegalsCondAccepted(userBD.getLegalsCondAccepted());
					userList.setLogin(userBD.getUsersPK().getLogin());
					userList.setMainUser(userBD.getMainUser());
					userList.setOperationalCode(userBD.getOperationalCode());
					userList.setPhone(userBD.getPhone());
					userList.setPinBloqueo(userBD.getPinBloqueo());
					userList.setTrialsCounter(userBD.getTrialsCounter());
					userList.setUserCreationDate(userBD.getUserCreationDate());
					userList.setInstallations(numinstStr);
					users.add(userList);
				}
			} catch (Exception e) {
				if (logger.isEnabled(Logger.Level.ERROR)) {
					logger.info("Error: KO installations/funions/byinst/" + e.getMessage());
				}
			}
			if (logger.isInfoEnabled()) {
				logger.info("All users delivery OK from installations/funions/byinst/" + numinst.toString() + " countryId " + idCountry);
			}
		} else {
			if (logger.isEnabled(Logger.Level.ERROR)) {
				logger.error("Country KO from installations/funions/byinst/" + numinst.toString() + " " + country.toString());
			}
		}
		

		return users;
	}

	@GET
	@Path("br/funions/byinst/{numinst}")
	@Produces({ "application/xml", "application/json" })
	public List<UserInst> findUnionByNuminstBR(@PathParam("numinst") PathSegment numinst) {
		List<UserInst> users = new ArrayList<>();
		try {
			Query qryInstallation = this.em.createNamedQuery("Installations.findByNuminstBR");
			String numinstStr = numinst.toString();
			qryInstallation.setParameter("numinst", numinstStr);
			Installations inst = (Installations) qryInstallation.getSingleResult();

			Query qryInstUsers = this.em.createNamedQuery("InstallationsUsers.findByIdInstallation");
			qryInstUsers.setParameter("installationid", Integer.valueOf(inst.getIdInst()));
			List<InstallationsUsers> instsUsersList = qryInstUsers.getResultList();

			for (InstallationsUsers instUser : instsUsersList) {

				Query qryUsers = this.em.createNamedQuery("Users.findUniqueByIdUserBR");
				qryUsers.setParameter("idUser", Integer.valueOf(instUser.getInstsUsersPK().getIdUser()));
				Users userBD = (Users) qryUsers.getSingleResult();
				UserInst userList = new UserInst();
				userList.setBlocked(userBD.getBlocked());
				userList.setEmail(inst.getNotificationsEmail());
				userList.setIdLanguage(userBD.getIdLanguage());
				userList.setIdUser(userBD.getIdUser());
				userList.setLastPasswordReset(userBD.getLastPasswordReset());
				userList.setLegalsCondAccepted(userBD.getLegalsCondAccepted());
				userList.setLogin(userBD.getUsersPK().getLogin());
				userList.setMainUser(userBD.getMainUser());
				userList.setOperationalCode(userBD.getOperationalCode());
				userList.setPhone(inst.getNotificationsPhone());
				userList.setPinBloqueo(userBD.getPinBloqueo());
				userList.setTrialsCounter(userBD.getTrialsCounter());
				userList.setUserCreationDate(userBD.getUserCreationDate());
				userList.setInstallations(numinstStr);
				users.add(userList);
			}
		} catch (Exception e) {
		}

		return users;
	}

	public List<UserInst> findUnionByNuminstAndIdCountry(String numinst, int idCountry) {
		List<UserInst> users = new ArrayList<>();
		try {
			Query qryFindInstByNuminstAndIdCountry = this.em
					.createNamedQuery("Installations.findByNuminstAndIdCountry");
			qryFindInstByNuminstAndIdCountry.setParameter("numinst", numinst);
			qryFindInstByNuminstAndIdCountry.setParameter("idCountry", Integer.valueOf(idCountry));
			Installations inst = (Installations) qryFindInstByNuminstAndIdCountry.getSingleResult();

			Query qryInstUsersByIdInstallation = this.em.createNamedQuery("InstallationsUsers.findByIdInstallation");
			qryInstUsersByIdInstallation.setParameter("installationid", Integer.valueOf(inst.getIdInst()));
			List<InstallationsUsers> instsUsersList = qryInstUsersByIdInstallation.getResultList();

			for (InstallationsUsers instUser : instsUsersList) {

				Query qryUsers = this.em.createNamedQuery("Users.findUniqueByIdUserIdCountry");
				qryUsers.setParameter("idUser", Integer.valueOf(instUser.getInstsUsersPK().getIdUser()));
				qryUsers.setParameter("idCountry", Integer.valueOf(idCountry));
				Users userBD = (Users) qryUsers.getSingleResult();

				UserInst userList = new UserInst();
				userList.setBlocked(userBD.getBlocked());
				userList.setEmail(userBD.getEmail());
				userList.setIdLanguage(userBD.getIdLanguage());
				userList.setIdUser(userBD.getIdUser());
				userList.setLastPasswordReset(userBD.getLastPasswordReset());
				userList.setLegalsCondAccepted(userBD.getLegalsCondAccepted());
				userList.setLogin(userBD.getUsersPK().getLogin());
				userList.setMainUser(userBD.getMainUser());
				userList.setOperationalCode(userBD.getOperationalCode());
				userList.setPhone(userBD.getPhone());
				userList.setPinBloqueo(userBD.getPinBloqueo());
				userList.setTrialsCounter(userBD.getTrialsCounter());
				userList.setUserCreationDate(userBD.getUserCreationDate());
				userList.setInstallations(numinst);
				users.add(userList);
			}
		} catch (Exception e) {
			if (logger.isInfoEnabled()) {
				logger.error("All users delivery OK from installations/funions/byinst/" + numinst.toString());
			}
		}

		return users;
	}

	@GET
	@Path("funions/byuser/{login}/{country}")
	@Produces({ "application/xml", "application/json" })

	public List<Installations> findUnionByUser(@PathParam("login") PathSegment usLogin, @PathParam("country") PathSegment country) {

		List<Installations> listInstResult = new ArrayList<>();
		if (null != Constantes.countryIds.get(country.toString())) {
			int idCountry=Constantes.countryIds.get(country.toString());
			try {
				Query qryUsers = this.em.createNamedQuery("Users.findByLogin");
				qryUsers.setParameter("login", usLogin.toString());
				qryUsers.setParameter("idCountry", idCountry);
				Users userDB = (Users) qryUsers.getSingleResult();

				Query qryInstByUser = this.em.createNamedQuery("InstallationsUsers.findByIdUser");
				qryInstByUser.setParameter("userid", Integer.valueOf(userDB.getIdUser()));
				List<InstallationsUsers> listInstUsByUser = qryInstByUser.getResultList();


				for (InstallationsUsers instUserId : listInstUsByUser) {
					Query qryInsFinal = this.em.createNamedQuery("Installations.findByIdInstMC");
					qryInsFinal.setParameter("idInst", Integer.valueOf(instUserId.getInstsUsersPK().getIdInst()));
					qryInsFinal.setParameter("idCountry", idCountry);
					Installations instFinal = (Installations) qryInsFinal.getSingleResult();
					if (!listInstResult.contains(instFinal)) {
						listInstResult.add(instFinal);
					}
				}
			}
			catch(Exception e) {
				if (logger.isEnabled(Logger.Level.ERROR)) {
					logger.info("Error: No results funions/byuser/"+usLogin.toString()+"/"+country.toString()+" " + e.getMessage());
				}
			}
			if (logger.isInfoEnabled()) {
				logger.info("All installations delivery OK from /funions/byuser/" + " " + usLogin + " countryId " + idCountry);
			}
		} else {
			if (logger.isEnabled(Logger.Level.ERROR)) {
				logger.error("Country KO from /funions/byuser/" + usLogin.toString() + " " + country.toString());
			}
		}
		
		return listInstResult;
	}

	private InstallationsPK getPrimaryKey(String numinst) {
		InstallationsPK key = new InstallationsPK();
		key.setIdCountry(2);
		key.setNuminst(numinst);
		return key;
	}
}
