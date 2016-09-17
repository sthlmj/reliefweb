package org.joedan.client;

/**
 * Communicate with API
 */

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import org.joedan.model.bean.reliefweb.JobDocumentData;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReliefWebClient {

	public static final String RELIEFWEB_API = "http://api.reliefweb.int/v1";

	public static final String JOBS = "jobs";

	private Gson gson = new Gson();

	public void update(PrintWriter out) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(RELIEFWEB_API).path(JOBS);

		final Response response = target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json("{\n" +
				"  \"profile\": \"list\",\n" +
				"  \"fields\":\n" +
				"    {\n" +
				"      \"include\": [\"id\", \"title\", \"country.iso3\", \"city\", \"url\" ]\n" +
				"    }\n" +
				"}"));

		if (response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
			final String text = response.readEntity(String.class);
			out.print(text);

			try {
				populate(text);
			} catch (JsonParseException ex) {
				Logger.getLogger(getClass().getSimpleName()).log(Level.WARNING, "", ex);
			}

		} else {
			out.format("%s - %s", response.getStatusInfo().getStatusCode(), response.getStatusInfo().getReasonPhrase());
		}
	}

	private void populate(String text) {
		final JobDocumentData document = gson.fromJson(text, JobDocumentData.class);
		JobsRepository.getInstance().addJobs(document.getData());
	}
}
