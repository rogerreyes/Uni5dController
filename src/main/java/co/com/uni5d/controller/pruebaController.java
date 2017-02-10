package co.com.uni5d.controller;

import java.time.LocalDate;
import java.time.Month;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import co.com.uni5d.services.ConsultasService;

@RestController
public class pruebaController {

	@Autowired
	private ConsultasService consultaService;

	/*
	 * @RequestMapping(value="/uni5d", method=RequestMethod.GET) public
	 * ResponseEntity<JSONObject> consultaItinerarios(){ JSONObject obj =
	 * consultaService.consultarItinerario("BOG-sky", "CUN-sky",
	 * LocalDate.of(2017, Month.FEBRUARY, 10), LocalDate.of(2017,
	 * Month.FEBRUARY, 20), 1); System.err.println(obj); return new
	 * ResponseEntity<JSONObject>(HttpStatus.OK); }
	 */

	@RequestMapping(value = "/uni5d", method = RequestMethod.GET)
	public ResponseEntity<JSONObject> consultaItinerarios() {
		JSONObject obj = consultaService.consultarItinerario("BOG-sky", "CUN-sky",
				LocalDate.of(2017, Month.FEBRUARY, 10), LocalDate.of(2017, Month.FEBRUARY, 20), 1);

		consultaService.guardarJSON(obj);
		return new ResponseEntity<JSONObject>(obj, HttpStatus.OK);
	}

}
