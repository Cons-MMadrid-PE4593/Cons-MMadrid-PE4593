package com.securitasdirect.wsusersinstaut.service.util;

import java.util.HashMap;
import java.util.Map;

public interface Constantes {
	public static Map<String, Integer> countryIds = new HashMap<String, Integer>() {
		{
			put( "GBR",1);
			put( "ESP",2);
			put( "PRT",3);
			put( "FRA",4);
			put( "CHL",5);
			put( "BRA",6);
			put( "PER",7);
			put( "ITA",8);
			put( "ARG",10);
		}
	};

}
