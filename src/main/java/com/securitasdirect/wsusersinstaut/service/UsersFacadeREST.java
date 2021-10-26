package com.securitasdirect.wsusersinstaut.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

import org.jboss.logging.Logger;

import com.securitasdirect.wsusersinstaut.entity.Installations;
import com.securitasdirect.wsusersinstaut.entity.InstallationsUsers;
import com.securitasdirect.wsusersinstaut.entity.Users;
import com.securitasdirect.wsusersinstaut.entity.UsersPK;
import com.securitasdirect.wsusersinstaut.service.util.Constantes;
import com.securitasdirect.wsusersinstaut.util.beans.ChgResponse;
import com.securitasdirect.wsusersinstaut.util.beans.SecondUserToMain;
import com.securitasdirect.wsusersinstaut.util.beans.UserDataChg;
import com.securitasdirect.wsusersinstaut.util.beans.UserInst;
import com.securitasdirect.wsusersinstaut.util.md5.Md5;

@Stateless
@Path("verisureweb/users")
public class UsersFacadeREST extends AbstractFacade<Users> {
	private static final Logger logger = Logger
			.getLogger(com.securitasdirect.wsusersinstaut.service.UsersFacadeREST.class);

	@PersistenceContext(unitName = "WSUsersInstAutomatationPU")
	private EntityManager em;

	private UsersPK getPrimaryKey(String login, int idCountry) {
		UsersPK key = new UsersPK();
		key.setIdCountry(idCountry);
		key.setLogin(login);
		return key;
	}

	public UsersFacadeREST() {
		super(Users.class);
	}

	@POST
	@Consumes({ "application/xml", "application/json" })
	public void create(Users entity) {
		super.create(entity);
	}

	@PUT
	@Path("{id}")
	@Consumes({ "application/xml", "application/json" })
	public void edit(@PathParam("id") PathSegment id, Users entity) {
		edit(entity);
	}

	@DELETE
	@Path("{login}/{country}")
	public void remove(@PathParam("login") PathSegment login, @PathParam("country") PathSegment country) {
		String loginStr = login.toString();
		if (null != Constantes.countryIds.get(country.toString())) {
			int idCountry=Constantes.countryIds.get(country.toString());
			UsersPK key = getPrimaryKey(loginStr,idCountry);
			remove(find(key));		
		} else {
			if (logger.isEnabled(Logger.Level.ERROR)) {
				logger.error("Country KO from /users/remove/" + login.toString() + " " + country.toString());
			}
		}
	}

	@GET
	@Path("{login}/{country}")
	@Produces({ "application/xml", "application/json" })
	public List<UserInst> find(@PathParam("login") PathSegment login, @PathParam("country") PathSegment country) {
		String loginStr = login.toString();
		List<UserInst> usersInstRespList = new ArrayList<>();
		if (logger.isInfoEnabled()) {
			logger.info("Find all users from /users/" + loginStr + " " +country);
		}
		if (null != Constantes.countryIds.get(country.toString())) {
			
			int idCountry=Constantes.countryIds.get(country.toString());
			
			UsersPK key = getPrimaryKey(loginStr, idCountry);
			Users userid = (Users) find(key);
			if (null != userid) {
				Query query = this.em.createNamedQuery("Users.findByIdUser");
				int intUserid = userid.getIdUser();
				query.setParameter("idUser", Integer.valueOf(intUserid));

				List<Users> usersByIdUserList = query.getResultList();

				for (Users userBD : usersByIdUserList) {
					UserInst userResp = UserInst.convertUsersToUserInst(userBD);

					Query queryInstUsers = this.em.createNamedQuery("InstallationsUsers.findByIdUser");
					queryInstUsers.setParameter("userid", Integer.valueOf(userBD.getIdUser()));
					List<InstallationsUsers> instUserList = queryInstUsers.getResultList();
					String installationsStr = "";
					for (InstallationsUsers instUnit : instUserList) {
						Query queryInsts = this.em.createNamedQuery("Installations.findByIdInstMC");
						queryInsts.setParameter("idInst", Integer.valueOf(instUnit.getInstsUsersPK().getIdInst()));
						queryInsts.setParameter("idCountry", userBD.getUsersPK().getIdCountry());
						Installations inst = (Installations) queryInsts.getSingleResult();
						String instPlusComa = "," + inst.getInstallationsPK().getNuminst();
						installationsStr = installationsStr + instPlusComa;
					}
					userResp.setInstallations(installationsStr.substring(1, installationsStr.length()));
					usersInstRespList.add(userResp);
				}
			}
			if (logger.isInfoEnabled()) {
				logger.info("All users delivery OK from /users/" + loginStr + " contryId " + idCountry);
			}

		} else {
			if (logger.isEnabled(Logger.Level.ERROR)) {
				logger.error("Country KO from /users/get/" + loginStr + " " + country);
			}
		}
		return usersInstRespList;
	}
	
	@HEAD
	@Path("{removeserv}")
	@Produces({ "application/xml", "application/json" })
	public String removeservStatus() {
		return "";
	}
	
	@HEAD
	@Path("{status}")
	@Produces({ "application/xml", "application/json" })
	public String status() {
		return "";
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	public List<Users> findAll() {
		return super.findAll();
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

	@PUT
	@Path("blockserv/{userid}")
	@Produces({ "application/xml", "application/json" })
	public ChgResponse editBlock(@PathParam("userid") PathSegment userid) {
		ChgResponse response = new ChgResponse();
		if (logger.isInfoEnabled()) {
			logger.info("Unblock user to /users/blockserv/" + userid.toString());
		}
		Query query = this.em.createNamedQuery("Users.unblock");
		query.setParameter("idUser", Integer.valueOf(userid.toString()));
		int result = query.executeUpdate();
		if (0 == result) {
			response.setResponse("ERROR");
			response.setMessage("The userid is not correct");
		} else if (1 == result) {
			response.setResponse("OK");
			response.setMessage("Request has been successful");
		}

		if (logger.isInfoEnabled()) {
			logger.info("Successfully unblocked to /users/blockserv/" + userid.toString());
		}
		return response;
	}

	@GET
	@Path("fusbyemail/{email}/{country}")
	@Produces({ "application/xml", "application/json" })
	public List<UserInst> findByEMail(@PathParam("email") PathSegment email, @PathParam("country") PathSegment country) {
		if (logger.isInfoEnabled()) {
			logger.info("Find all users from /users/fusbyemail/" + email.toString() + " " + country.toString());
		}
		if(null != Constantes.countryIds.get(country.toString())){
			
			int idCountry=Constantes.countryIds.get(country.toString());
			try {
				Query query = this.em.createNamedQuery("Users.findByEmail");
				String emailStr = URLDecoder.decode(email.toString(), "UTF-8");
				query.setParameter("email", emailStr);
				List<Users> usersByEmail = query.getResultList();
				List<UserInst> listUsersResponse = new ArrayList<>();
				for (Users userBD : usersByEmail) {
					UserInst userResp = UserInst.convertUsersToUserInst(userBD);

					Query queryInstUsers = this.em.createNamedQuery("InstallationsUsers.findByIdUser");
					queryInstUsers.setParameter("userid", Integer.valueOf(userBD.getIdUser()));

					List<InstallationsUsers> instUserList = queryInstUsers.getResultList();
					String installationsStr = "";
					for (InstallationsUsers instUnit : instUserList) {
						Query queryInsts = this.em.createNamedQuery("Installations.findByIdInstMC");
						queryInsts.setParameter("idInst", Integer.valueOf(instUnit.getInstsUsersPK().getIdInst()));
						queryInsts.setParameter("idCountry", idCountry);
						try {
							Installations inst = (Installations) queryInsts.getSingleResult();
							String instPlusComa = "," + inst.getInstallationsPK().getNuminst();
							installationsStr = installationsStr + instPlusComa;
						}
						catch (Exception e){
							if (logger.isInfoEnabled()) {
								logger.info("NO results for " + email.toString() + " " + country.toString());
							}
						}
					}
					if(!installationsStr.equals("")) {
						userResp.setInstallations(installationsStr.substring(1, installationsStr.length()));
						listUsersResponse.add(userResp);
					}
				}
				if (logger.isInfoEnabled()) {
					logger.info("All users delivery OK from /users/fusbyemail/" + email.toString() + " " + country.toString());
				}
				return listUsersResponse;
			} catch (UnsupportedEncodingException ex) {
				if (logger.isEnabled(Logger.Level.ERROR)) {
					logger.error("Error KO from /users/fusbyemail/" + email.toString() + " " + country.toString());
				}
				return null;
			}
		}
		else {
			if (logger.isEnabled(Logger.Level.ERROR)) {
				logger.error("Country KO from /users/fusbyemail/" + email.toString() + " " + country.toString());
			}
			return null;
		}
	}

	@DELETE
	@Path("removeserv/{userid}")
	@Produces({ "application/xml", "application/json" })
	public ChgResponse removeByUserId(@PathParam("userid") PathSegment userid) {
		ChgResponse response = new ChgResponse();
		if (logger.isInfoEnabled()) {
			logger.info("System try remove user /users/removeserv/" + userid.toString());
		}

		Query query = this.em.createNamedQuery("Users.findByIdUser");
		int intUserid = Integer.valueOf(userid.toString()).intValue();
		query.setParameter("idUser", Integer.valueOf(intUserid));
		List<Users> usersByIdUserList = query.getResultList();

		boolean isRemovable = false;
		boolean isMainUser = false;
		String errorMessage = "";
		Users userToRemove = null;
		if (usersByIdUserList.size() == 1) {
			userToRemove = usersByIdUserList.get(0);
			isRemovable = true;
			if (userToRemove.getMainUser() == 0) {
				isMainUser = true;
			}
		} else if (usersByIdUserList.isEmpty()) {
			isRemovable = false;
			errorMessage = "Error: This id is not registered into system";
			if (logger.isInfoEnabled()) {
				logger.info("Error: This id is not registered into system user /users/removeserv/" + userid.toString());
			}
		} else {
			for (Users userList : usersByIdUserList) {
				if (userList.getIdUser() == intUserid && userList.getMainUser() == 0) {
					isRemovable = false;
					isMainUser = true;
					continue;
				}
				if (userList.getMainUser() != 0 && userList.getIdUser() == intUserid) {
					userToRemove = userList;
					isRemovable = true;
					continue;
				}
				isRemovable = false;
				if (isMainUser) {
					errorMessage = "Fault: Is not possible remove this user, it have a second users";
					if (logger.isInfoEnabled())
						logger.info("Error: Is not possible remove this user, it have a second users /users/removeserv/"
								+ userid.toString());
					continue;
				}
				errorMessage = "Fault: Is not possible remove this user, pleases contact with support";
				if (logger.isInfoEnabled()) {
					logger.info(
							"Error: Is not possible remove this user, pleases contact with support /users/removeserv/"
									+ userid.toString());
				}
			}
		}

		if (isRemovable) {

			Query queryInstUsers = this.em.createNamedQuery("InstallationsUsers.findByIdUser");
			queryInstUsers.setParameter("userid", Integer.valueOf(intUserid));
			List<InstallationsUsers> regInstsUsersListToRm = queryInstUsers.getResultList();
			for (InstallationsUsers isntUser : regInstsUsersListToRm) {

				this.em.remove(isntUser);
				if (isMainUser) {
					Query installationQry = this.em.createNamedQuery("Installations.findByIdInstMC");
					installationQry.setParameter("idInst", Integer.valueOf(isntUser.getInstsUsersPK().getIdInst()));
					installationQry.setParameter("idCountry", userToRemove.getUsersPK().getIdCountry());
					Installations inst = (Installations) installationQry.getSingleResult();
					this.em.remove(inst);
				}
			}

			this.em.remove(userToRemove);
			if (logger.isInfoEnabled()) {
				logger.info("User successfully removed /users/removeserv/" + userid.toString());
			}
			response.setResponse("OK");
			response.setMessage("Request has been successful");
		} else {
			if (logger.isInfoEnabled()) {
				logger.info("This user is not removed /users/removeserv/" + userid.toString());
			}
			response.setResponse("ERROR");
			response.setMessage(errorMessage);
		}

		return response;
	}

	@PUT
	@Path("euchgpass")
	@Consumes({ "application/xml", "application/json" })
	@Produces({ "application/xml", "application/json" })
	public ChgResponse updateUsPassword(UserDataChg userDataChg) {
		if (logger.isInfoEnabled()) {
			logger.info("Changed password from users/euchgpass/" + userDataChg.getIdUserDataChg());
		}
		ChgResponse response = new ChgResponse();
		try {

		Query qryUsToRM = this.em.createNamedQuery("Users.findUserById");
		qryUsToRM.setParameter("idUser", Integer.valueOf(userDataChg.getIdUserDataChg()));
		Users userToRM = (Users) qryUsToRM.getSingleResult();

		Users usToChgPassword = new Users();
		if (null != userToRM) {
			usToChgPassword.setBlocked(userToRM.getBlocked());
			usToChgPassword.setEmail(userToRM.getEmail());
			usToChgPassword.setIdLanguage(userToRM.getIdLanguage());
			usToChgPassword.setIdUser(userDataChg.getIdUserDataChg());
			usToChgPassword.setLastPasswordReset(userToRM.getLastPasswordReset());
			usToChgPassword.setLegalsCondAccepted(userToRM.getLegalsCondAccepted());
			usToChgPassword.setMainUser(userToRM.getMainUser());
			usToChgPassword.setOperationalCode(userToRM.getOperationalCode());
			String md5NewPass = Md5.getMd5(userDataChg.getNewUsPass());
			usToChgPassword.setPassword(md5NewPass);
			usToChgPassword.setPhone(userToRM.getPhone());
			usToChgPassword.setPinBloqueo(userToRM.getPinBloqueo());
			usToChgPassword.setTrialsCounter(userToRM.getTrialsCounter());
			usToChgPassword.setUserCreationDate(userToRM.getUserCreationDate());
			UsersPK usToChgPasswordPK = new UsersPK(userToRM.getUsersPK().getIdCountry(),
					userToRM.getUsersPK().getLogin());

			usToChgPassword.setUsersPK(usToChgPasswordPK);
		}

			edit(usToChgPassword);
			if (logger.isInfoEnabled()) {
				logger.info("Successfully password changed from users/euchgpass/" + userDataChg.getIdUserDataChg()+ " countryId " +userToRM.getUsersPK().getIdCountry());
			}
			response.setResponse("OK");
			response.setMessage("Request has been successful");
		} catch (Exception e) {
			if (logger.isEnabled(Logger.Level.ERROR)) {
				logger.info("ERROR KO Changing password from users/euchgpass/" + userDataChg.getIdUserDataChg());
			}
			response.setResponse("ERROR");
			response.setMessage("Fault: " + e.getCause().getMessage());
		}
		return response;
	}

	@GET
	@Path("fuserbyid/{id}")
	@Produces({ "application/xml", "application/json" })
	public List<UserInst> findUserById(@PathParam("id") PathSegment id) {
		if (logger.isInfoEnabled()) {
			logger.info("Find user from users/fuserbyid/" + id.toString());
		}
		List<UserInst> listOneUser = new ArrayList<>();
		int idCountry = 0;
		try {
			Query qryUsById = this.em.createNamedQuery("Users.findUserById");
			int idUser = Integer.valueOf(id.toString()).intValue();
			qryUsById.setParameter("idUser", Integer.valueOf(idUser));
			Users userBD = (Users) qryUsById.getSingleResult();
			UserInst userResp = UserInst.convertUsersToUserInst(userBD);
			idCountry = userBD.getUsersPK().getIdCountry();
			Query queryInstUsers = this.em.createNamedQuery("InstallationsUsers.findByIdUser");
			queryInstUsers.setParameter("userid", Integer.valueOf(userBD.getIdUser()));
			List<InstallationsUsers> instUserList = queryInstUsers.getResultList();
			String installationsStr = "";
			for (InstallationsUsers instUnit : instUserList) {
				Query queryInsts = this.em.createNamedQuery("Installations.findByIdInstMC");
				queryInsts.setParameter("idInst", Integer.valueOf(instUnit.getInstsUsersPK().getIdInst()));
				queryInsts.setParameter("idCountry", idCountry);
				Installations inst = (Installations) queryInsts.getSingleResult();
				String instPlusComa = "," + inst.getInstallationsPK().getNuminst();
				installationsStr = installationsStr + instPlusComa;
			}
			userResp.setInstallations(installationsStr.substring(1, installationsStr.length()));
			listOneUser.add(userResp);
		} catch (Exception e) {
			if (logger.isEnabled(Logger.Level.ERROR)) {
				logger.info("Error: KO find user from users/fuserbyid/" + id.toString());
			}
		}
		if (logger.isInfoEnabled()) {
			logger.info("User delivery OK from users/fuserbyid/" + id.toString() + " countryId " + idCountry);
		}
		return listOneUser;
	}

	@PUT
	@Path("chgSecondUserToMain")
	@Consumes({ "application/xml", "application/json" })
	@Produces({ "application/xml", "application/json" })
	public ChgResponse chgSecondUserToMain(SecondUserToMain secondUsToMain) {
		if (logger.isInfoEnabled()) {
			logger.info("Changing seconduser to main user from users/chgSecondUserToMain/");
		}

		ChgResponse response = new ChgResponse();

		response.setResponse("KO");

		response.setMessage("Esta utilidad se encuentra actualmente indisponible");
		return response;
	}
}
