package co.com.uni5d.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "Prueba")
@Data
public class Prueba {
	
	@Id
	@JsonIgnore
	private ObjectId id;
	private int numero;
	private String  caracter;
	
	@Override
	public String toString() {
		return "Prueba [numero=" + numero + ", caracter=" + caracter + "]";
	}
	
}
