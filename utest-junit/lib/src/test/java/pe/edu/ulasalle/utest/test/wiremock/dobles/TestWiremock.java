package pe.edu.ulasalle.utest.test.wiremock.dobles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

class TestWiremock {

	static WireMockServer server; 
	
	@BeforeAll
	static void ejecutarAntes() {
		int puerto = 8083;
		server = new WireMockServer(puerto);
		server.start();
		WireMock.configureFor(puerto);
		WireMock.stubFor(WireMock.post(WireMock.urlEqualTo("/utest/mypost"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody("{\"testing-post\": \"WireMockPost\",\"myobject\":{\"nombre\":\"Juan\",\"edad\":23,\"altura\":1.80}}")));
		WireMock.stubFor(WireMock.get(WireMock.urlPathMatching("/utest/.*"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody("{\"testing-get\": \"WireMockGet\",\"valor\":20}")));
		
	}
	
	@AfterAll
	static void ejecutarDespues() {
		server.stop();
	}
	
	
	@Test
	void testGet() {
		String url = "http://localhost:8083/utest/consultarData";
		Client client = ClientBuilder.newClient();
		WebTarget base = client.target(url);
		Map<String, Object> res = null;
		Builder builder = null;
		builder = base.request(MediaType.APPLICATION_JSON);
		//builder.header("Authorization", "sadsakjalkjkajlasjdkljlkjsadklajskdjksljdklsajdklas2321nmbmbm");
		res = builder.get(Map.class);
		assertEquals(20, res.get("valor"));
	}
	
	@Test
	void testPost() {
		String url = "http://localhost:8083/utest/mypost";
		Client client = ClientBuilder.newClient();
		WebTarget base = client.target(url);
		Builder builder = null;
		builder = base.request(MediaType.APPLICATION_JSON);
		//builder.header("Authorization", "sadsakjalkjkajlasjdkljlkjsadklajskdjksljdklsajdklas2321nmbmbm");
		SomeObj obj = new SomeObj();
		Map<String, Object> res = null;
		res = builder.post(Entity.json(obj), Map.class);
//		Response objRes = builder.post(Entity.json(obj));
//		objRes.getStatus();// codigo de respuesta
		Map<String, Object> myobject = (Map) res.get("myobject");
		assertEquals(1.8, myobject.get("altura"));
	}
	
	@Test
	void testPostMap() {
		String url = "http://localhost:8083/utest/mypost";
		Client client = ClientBuilder.newClient();
		WebTarget base = client.target(url);
		Builder builder = null;
		builder = base.request(MediaType.APPLICATION_JSON);
		//builder.header("Authorization", "sadsakjalkjkajlasjdkljlkjsadklajskdjksljdklsajdklas2321nmbmbm");
		Map<String, Object> obj = new HashMap<String, Object>();
		Map<String, Object> res = null;
		res = builder.post(Entity.json(obj), Map.class);
//		Response objRes = builder.post(Entity.json(obj));
//		objRes.getStatus();// codigo de respuesta
		Map<String, Object> myobject = (Map) res.get("myobject");
		assertEquals(1.8, myobject.get("altura"));
	}
}
