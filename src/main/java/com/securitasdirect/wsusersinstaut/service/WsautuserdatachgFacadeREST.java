package com.securitasdirect.wsusersinstaut.service;

import com.securitasdirect.wsusersinstaut.entity.Wsautuserdatachg;
import com.securitasdirect.wsusersinstaut.service.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("wsaut/userdatachg")
public class WsautuserdatachgFacadeREST extends AbstractFacade<Wsautuserdatachg> {
	@PersistenceContext(unitName = "WSUsersInstAutomatationPU")
	private EntityManager em;

	public WsautuserdatachgFacadeREST() {
		super(Wsautuserdatachg.class);
	}

	@POST
	@Consumes({ "application/xml", "application/json" })
	public void create(Wsautuserdatachg entity) {
		super.create(entity);
	}

	@PUT
	@Path("{id}")
	@Consumes({ "application/xml", "application/json" })
	public void edit(@PathParam("id") Integer id, Wsautuserdatachg entity) {
		edit(entity);
	}

	@DELETE
	@Path("{id}")
	public void remove(@PathParam("id") Integer id) {
		remove(find(id));
	}

	@GET
	@Path("{id}")
	@Produces({ "application/xml", "application/json" })
	public Wsautuserdatachg find(@PathParam("id") Integer id) {
		return (Wsautuserdatachg) find(id);
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	public List<Wsautuserdatachg> findAll() {
		return super.findAll();
	}

	@GET
	@Path("{from}/{to}")
	@Produces({ "application/xml", "application/json" })
	public List<Wsautuserdatachg> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
