package com.securitasdirect.webresources.app;

import com.securitasdirect.wsusersinstaut.service.AutoincrementalFacadeREST;
import com.securitasdirect.wsusersinstaut.service.InstallationsFacadeREST;
import com.securitasdirect.wsusersinstaut.service.InstallationsUsersFacadeREST;
import com.securitasdirect.wsusersinstaut.service.SessionsFacadeREST;
import com.securitasdirect.wsusersinstaut.service.UsersFacadeREST;
import com.securitasdirect.wsusersinstaut.service.WsautactiontypeFacadeREST;
import com.securitasdirect.wsusersinstaut.service.WsautresulttypeFacadeREST;
import com.securitasdirect.wsusersinstaut.service.WsautuserdatachgFacadeREST;
import com.securitasdirect.wsusersinstaut.service.WsautuserschglogFacadeREST;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("webresources")
public class ApplicationConfig extends Application {
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>();
		addRestResourceClasses(resources);
		return resources;
	}

	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(AutoincrementalFacadeREST.class);
		resources.add(InstallationsFacadeREST.class);
		resources.add(InstallationsUsersFacadeREST.class);
		resources.add(SessionsFacadeREST.class);
		resources.add(UsersFacadeREST.class);
		resources.add(WsautactiontypeFacadeREST.class);
		resources.add(WsautresulttypeFacadeREST.class);
		resources.add(WsautuserdatachgFacadeREST.class);
		resources.add(WsautuserschglogFacadeREST.class);
	}
}
