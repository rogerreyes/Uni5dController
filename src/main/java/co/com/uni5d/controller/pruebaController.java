package co.com.uni5d.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.uni5d.domain.Prueba;
import co.com.uni5d.services.PruebaService;

@RestController
public class pruebaController {
	
	
	
	@Autowired
	private PruebaService pruebaService;
	
	
	@RequestMapping(value="/uni5d/{numero}/{caracter}", method=RequestMethod.GET)
	public ResponseEntity<Prueba> saludo(@PathVariable("numero") int numero, @PathVariable("caracter") String caracter){
		
		Prueba prueba = new Prueba();
		prueba.setCaracter(caracter);
		prueba.setNumero(numero);
		
		pruebaService.guardarPrueba(prueba);
		 
		return new ResponseEntity<Prueba>(prueba,HttpStatus.OK);
	}
	

}
