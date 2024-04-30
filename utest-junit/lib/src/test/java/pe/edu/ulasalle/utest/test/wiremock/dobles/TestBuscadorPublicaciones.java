package pe.edu.ulasalle.utest.test.wiremock.dobles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import pe.edu.ulasalle.utest.wiremock.BuscadorPublicaciones;
import pe.edu.ulasalle.utest.wiremock.Publicacion;
import pe.edu.ulasalle.utest.wiremock.ServicioBuscadorGoogleBooks;

public class TestBuscadorPublicaciones {

	@Spy
	@InjectMocks
	private BuscadorPublicaciones buscador;
	
	@Mock
	private ServicioBuscadorGoogleBooks googleBooks;
	
	static WireMockServer server;
	
	@BeforeAll
	static void ejecutarAntes() {
		int puerto = 8083;
		server = new WireMockServer(puerto);
		server.start();
		WireMock.configureFor(puerto);
		WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/gbooks/search"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody("[{\"title\": \"Google Book 1\",\"authors\":\"Author 1\",\"publishDate\":\"21-10-2020\"},{\"title\": \"Google Book 2\",\"authors\":\"Author 2\",\"publishDate\":\"21-10-2020\"},{\"title\": \"Google Book 3\",\"authors\":\"Author 3\",\"publishDate\":\"21-10-2020\"}]")));
		WireMock.stubFor(WireMock.post(WireMock.urlEqualTo("/gbooks/record"))
				  .willReturn(WireMock.aResponse()
				  .withStatus(200)
				  .withHeader("Content-Type", "application/json")
				  .withBody("{\"result\": \"success\",\"new_object\":{\"generated_id\":\"234\"}}")));
		
	}
	
	@AfterAll
	static void ejecutarDespues() {
		server.stop();
	}
	
	@BeforeEach
	public void init() {
	    MockitoAnnotations.openMocks(this); 
	}
	
	@Test
	public void testBuscarPublicaciones() {
		String cadenaBusqueda = "architecture";
		Mockito.when(googleBooks.buscarPublicacionesPorTitulo(cadenaBusqueda)).thenReturn(consultarObjetos());
		List<Publicacion> lst = buscador.buscarPublicacionesPorTitulo(cadenaBusqueda);
		assertEquals(13, lst.size());
	}
	
	public List consultarObjetos() {
		String url = "http://localhost:8083/gbooks/search";
		Client client = ClientBuilder.newClient();
		WebTarget base = client.target(url);
		Builder builder = null;
		builder = base.request(MediaType.APPLICATION_JSON);
		List res = builder.get(List.class);
		return res;
	}
	
	@Test
	void testPostObject() {
		String url = "http://localhost:8083/gbooks/record";
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
		Map<String, Object> newobject = (Map) res.get("new_object");
		assertEquals("234", newobject.get("generated_id"));
	}
}




