package co.com.uni5d.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.uni5d.domain.Prueba;

@RestController
public class pruebaController {
	
	
	@RequestMapping(value="/saludo/{nombre}", method=RequestMethod.GET)
	public ResponseEntity<Prueba> saludo(@PathVariable("nombre") String nombre){
		
		return new ResponseEntity<Prueba>(new Prueba(),HttpStatus.OK);
	}
	

}
