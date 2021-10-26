package com.securitasdirect.wsusersinstaut.service;

import com.securitasdirect.wsusersinstaut.entity.Installations;
import com.securitasdirect.wsusersinstaut.entity.InstallationsUsers;
import com.securitasdirect.wsusersinstaut.entity.InstallationsUsersPK;
import com.securitasdirect.wsusersinstaut.service.AbstractFacade;
import com.securitasdirect.wsusersinstaut.service.util.Constantes;
import com.securitasdirect.wsusersinstaut.util.beans.ChgResponse;
import com.securitasdirect.wsusersinstaut.util.beans.SecondUserToMain;
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
@Path("verisureweb/installationsusers")
public class InstallationsUsersFacadeREST extends AbstractFacade<InstallationsUsers> {
	private static final Logger logger = Logger
			.getLogger(com.securitasdirect.wsusersinstaut.service.InstallationsUsersFacadeREST.class);

	@PersistenceContext(unitName = "WSUsersInstAutomatationPU")
	private EntityManager em;

	private InstallationsUsersPK getPrimaryKey(PathSegment pathSegment) {
		InstallationsUsersPK key = new InstallationsUsersPK();
		MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
		List<String> idInst = (List<String>) map.get("idInst");
		if (idInst != null && !idInst.isEmpty()) {
			key.setIdInst((new Integer(idInst.get(0))).intValue());
		}
		List<String> idUser = (List<String>) map.get("idUser");
		if (idUser != null && !idUser.isEmpty()) {
			key.setIdUser((new Integer(idUser.get(0))).intValue());
		}
		return key;
	}

	public InstallationsUsersFacadeREST() {
		super(InstallationsUsers.class);
	}

	@POST
	@Consumes({ "application/xml", "application/json" })
	public void create(InstallationsUsers entity) {
		super.create(entity);
	}

	@PUT
	@Path("{id}")
	@Consumes({ "application/xml", "application/json" })
	public void edit(@PathParam("id") PathSegment id, InstallationsUsers entity) {
		edit(entity);
	}

	@DELETE
	@Path("{id}")
	public void remove(@PathParam("id") PathSegment id) {
		InstallationsUsersPK key = getPrimaryKey(id);
		remove(find(key));
	}

	@GET
	@Path("{id}")
	@Produces({ "application/xml", "application/json" })
	public InstallationsUsers find(@PathParam("id") PathSegment id) {
		InstallationsUsersPK key = getPrimaryKey(id);
		return (InstallationsUsers) find(key);
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	public List<InstallationsUsers> findAll() {
		return super.findAll();
	}

	@GET
	@Path("{from}/{to}")
	@Produces({ "application/xml", "application/json" })
	public List<InstallationsUsers> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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

	@DELETE
	@Path("checkAndFixInstallation/{numinst}/{country}")
	@Produces({ "application/json" })
	public ChgResponse checkAndFixInstallation(@PathParam("numinst") PathSegment numinst, @PathParam("country") PathSegment country) {
		if (logger.isInfoEnabled()) {
			logger.info("check and fix Installation " + numinst.toString() + " "+ country.toString());
		}
		ChgResponse response = new ChgResponse();
		if (null != Constantes.countryIds.get(country.toString())) {
			int idCountry=Constantes.countryIds.get(country.toString());
			Query qryInstallation = this.em.createNamedQuery("Installations.findByNuminstMC");
			String numinstStr = numinst.toString();
			qryInstallation.setParameter("numinst", numinstStr);
			qryInstallation.setParameter("idCountry", Integer.valueOf(idCountry));

			try {
				Installations inst = (Installations) qryInstallation.getSingleResult();
				if (null != inst) {
					Query qryInstUser = this.em.createNamedQuery("InstallationsUsers.findByIdInstallation");
					qryInstUser.setParameter("installationid", Integer.valueOf(inst.getIdInst()));

					List<InstallationsUsers> instUser = qryInstUser.getResultList();
					if (instUser.size() == 0) {
						this.em.remove(inst);
						response.setResponse("OK");

						response.setMessage("Este contrato estaba corrupto, ahora puedes dar de alta a cualquier usuario");
					} else {

						response.setResponse("OK");

						response.setMessage("Este contrato no tiene problemas, tiene usuario en el sistema");
					}

				}
			} catch (Exception ex) {
				if (logger.isInfoEnabled()) {
					logger.error("check and fix Installation " + numinstStr  + " "+ country.toString());
					response.setResponse("OK");
					response.setMessage("Puedes dar de alta este contrato a cualquier usuario");
				}
			}
		} else {
			if (logger.isEnabled(Logger.Level.ERROR)) {
				logger.error("Country KO from check and fix Installation " + numinst.toString() + " " + country.toString());
			}
			return null;
		}
		
		return response;
	}

	@PUT
	@Path("copyRelUserMainToSec")
	@Consumes({ "application/xml", "application/json" })
	@Produces({ "application/xml", "application/json" })
	public ChgResponse copyRelUserMainToSec(SecondUserToMain secondUsToMain) {
		if (logger.isInfoEnabled()) {
			logger.info("Changing seconduser to main user from /installationsusers/copyRelUserMainToSec/");
		}

		ChgResponse response = new ChgResponse();

		response.setResponse("KO");

		response.setMessage("Esta utilidad se encuentra actualmente indisponible");
		return response;
	}
}
