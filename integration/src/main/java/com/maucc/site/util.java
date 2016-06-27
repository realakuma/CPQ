package com.maucc.site;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.maucc.util.JSONtoMap;

public class util {

	public String requestTokenURL = "";

	public String getRequestToken(String userName, String password) {
		String requestToken = "";
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(this.getRequestTokenURL()).path("request_token");
		
		System.out.println(target.getUri().toString());

		Form form = new Form();
		form.param("email", userName);
		form.param("password", password);

		Response response = target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

		String responseString = response.readEntity(String.class);

		response.close();

		if (response.getStatus() == 200) {

			Map<String, Object> map = JSONtoMap.toMap(responseString);

			requestToken = map.get("token").toString();
		}

		return requestToken;

	}

	public String getRequestTokenURL() {
		return requestTokenURL;
	}

	public void setRequestTokenURL(String requestTokenURL) {
		this.requestTokenURL = requestTokenURL;
	}

	public static void main(String[] args) throws Exception {

		util util = new util();
		util.setRequestTokenURL("https://maucc.com.alpha.tmogroup.asia/auth");
		System.out.println(util.getRequestToken("johan@tmogroup.asia", "johan"));

	}

}
