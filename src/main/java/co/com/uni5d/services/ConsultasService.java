package co.com.uni5d.services;

import java.net.URI;
import java.time.LocalDate;
import java.util.Collections;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;import org.springframework.boot.json.BasicJsonParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import co.com.uni5d.anotaciones.AcmeService;
import co.com.uni5d.dao.AppDao;
import co.com.uni5d.domain.JSONObjectDB;
import co.com.uni5d.util.Util;

@AcmeService
public class ConsultasService {
	@Autowired
	@Qualifier("uni5dRestTemplate")
	RestOperations restTemplate;
	@Autowired
	AppDao appDao;
	
	public JSONObject consultarItinerario(String origen, String destino, LocalDate fechaInicial, LocalDate fechaFinal, int nroAdultos){
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("apiKey", Util.API_KEY);
		map.add("country", "CO");
		map.add("currency", "COP");
		map.add("locale", "Es-ES");
		map.add("originplace", origen);
		map.add("destinationplace", destino);
		map.add("outbounddate", fechaInicial.toString());
		map.add("adults", String.valueOf(nroAdultos));
		map.add("inbounddate", fechaFinal.toString());
		
		HttpEntity<Object> entity = new HttpEntity<Object>(map, headers);
		
		JSONObject respuesta = consultarVuelos(entity);
//		
		return respuesta;
	}
//
	private JSONObject consultarVuelos(HttpEntity<Object> entity) {
		try {
		    Thread.sleep(2000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		URI url = restTemplate.postForLocation(Util.URL_BASE_LIVE_PRICES, entity);
		
		try {
		    Thread.sleep(5000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		JSONObject respuesta = restTemplate.getForObject(url.toString() + "?apiKey=" + Util.API_KEY, JSONObject.class);
		
		return respuesta;
	}
	public void guardarJSON(JSONObject obj) {
		String objSimple = obj.toJSONString();
//		System.err.println(objSimple);
//		DBObject dbObject =  (DBObject) JSON.parse(objSimple);
//		appDao.salvarJson2(JSON.parse(objSimple));
		
	}
}
