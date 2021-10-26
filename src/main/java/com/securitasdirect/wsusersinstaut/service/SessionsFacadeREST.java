package com.securitasdirect.wsusersinstaut.service;

import com.securitasdirect.sessions.entity.Language;
import com.securitasdirect.sessions.entity.Sessions;
import com.securitasdirect.wsusersinstaut.service.AbstractFacade;
import com.securitasdirect.wsusersinstaut.service.InstallationsFacadeREST;
import com.securitasdirect.wsusersinstaut.util.beans.ResponseValidatorSessions;
import com.securitasdirect.wsusersinstaut.util.beans.UserInst;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
import org.jboss.logging.Logger;

@Stateless
@Path("verisure/sessions")
@TransactionManagement(TransactionManagementType.BEAN)
public class SessionsFacadeREST extends AbstractFacade<Sessions> {
	private static final Logger logger = Logger
			.getLogger(com.securitasdirect.wsusersinstaut.service.SessionsFacadeREST.class);

	@PersistenceContext(unitName = "WSSessionsAutomatationPU")
	private EntityManager em;

	@EJB
	InstallationsFacadeREST installationsRestService;

	public SessionsFacadeREST() {
		super(Sessions.class);
	}

	@POST
	@Consumes({ "application/xml", "application/json" })
	public void create(Sessions entity) {
		super.create(entity);
	}

	@PUT
	@Path("{id}")
	@Consumes({ "application/xml", "application/json" })
	public void edit(@PathParam("id") Integer id, Sessions entity) {
		edit(entity);
	}

	@DELETE
	@Path("{id}")
	public void remove(@PathParam("id") Integer id) {
		remove(find(id));
	}

	@GET
	@Path("validator/{hash}/{numinst}")
	@Produces({ "application/xml", "application/json" })
	public ResponseValidatorSessions validate(@PathParam("hash") String id, @PathParam("numinst") String numinst) {
		if (logger.isInfoEnabled()) {
			logger.info("Find sessions from sessions/validator/" + id + "/" + numinst);
		}

		ResponseValidatorSessions response = new ResponseValidatorSessions();
		response.setValide("KO");
		Integer _id = null;

		if (id.trim().isEmpty() || numinst.trim().isEmpty() || id.trim().equalsIgnoreCase("null")
				|| numinst.trim().equalsIgnoreCase("null")) {
			return response;
		}
		_id = Integer.valueOf(Integer.parseInt(id));

		try {
			Query qrySessionByHash = this.em.createNamedQuery("Sessions.findByHash");
			qrySessionByHash.setParameter("id_hash", _id);
			Sessions session = (Sessions) qrySessionByHash.getSingleResult();

			if (session != null && session.getEnddate().getTime() > (new Date()).getTime()) {
				Query qryLanguageByCountry = this.em.createNamedQuery("Language.findByCountry");
				qryLanguageByCountry.setParameter("country", session.getCountry());
				Language lang = (Language) qryLanguageByCountry.getSingleResult();

				List<UserInst> users = this.installationsRestService.findUnionByNuminstAndIdCountry(numinst,
						lang.getIdlang());
				for (UserInst user : users) {
					if (user.getLogin().trim().equals(session.getIdentifier())) {
						response.setValide("OK");

						break;
					}
				}
			}
		} catch (NoResultException noExistsHashEx) {
			if (logger.isEnabled(Logger.Level.ERROR)) {
				logger.info("ERROR Delivery KO from sessions/validator/" + id + "/" + numinst + " message:"
						+ noExistsHashEx.getMessage());
			}
		}

		if (logger.isInfoEnabled()) {
			logger.info("Delivery from sessions/validator/" + id + "/" + numinst);
		}
		return response;
	}

	@GET
	@Path("{id}")
	@Produces({ "application/xml", "application/json" })
	public Sessions find(@PathParam("id") Integer id) {
		return (Sessions) find(id);
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	public List<Sessions> findAll() {
		return super.findAll();
	}

	@GET
	@Path("{from}/{to}")
	@Produces({ "application/xml", "application/json" })
	public List<Sessions> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
}
