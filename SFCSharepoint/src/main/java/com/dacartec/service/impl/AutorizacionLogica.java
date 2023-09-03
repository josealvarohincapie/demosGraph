package com.dacartec.service.impl;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dacartec.modelo.Token;
import com.google.gson.Gson;

public class AutorizacionLogica {

	private static final Log log = LogFactory.getLog(AutorizacionLogica.class);

		/**
		 * @author Dacartec
		 */	
		public String generarToken() {
			String respuesta = null;
			
			try {
			    String cadenaRequest = "grant_type=Client_credentials&client_id=ad85d1d9-3fe3-4336-9f6d-65341b3410dd&client_secret=2KI8Q~qR~c3STF884H8zKrqFryrAQG6BWuUpGa1u&scope=https://graph.microsoft.com/.default";
				
				String url = "https://login.microsoftonline.com/90baf6f4-b2c0-426c-9432-996b8e31266f/oauth2/v2.0/token/"; 
				
			    URI uri = new URI(url);
			    HttpRequest postRequest = HttpRequest.newBuilder()
			    		.uri(uri)
			    		.header("Accept", "application/json")
			    		.headers("Content-Type", "application/x-www-form-urlencoded")
			    		.POST(BodyPublishers.ofString(cadenaRequest))
			    		.build();
			    
			    HttpClient httpClient = HttpClient.newHttpClient();
			    HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());

				Gson gson = new Gson();
				Token token = gson.fromJson(postResponse.body(), Token.class);

				respuesta = token.getAccess_token();

			} catch (Exception e) {
				log.error("Error: " + e.getMessage());
				respuesta = e.getMessage();
			}

			return respuesta;
	}
}
