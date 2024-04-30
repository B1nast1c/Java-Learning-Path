package pe.edu.ulasalle.utest.test.wiremock.dobles;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

public class MainWiremock {

	public static void main(String[] args) {
		int puerto = 8083;
		WireMockServer server = new WireMockServer(puerto);
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
}
