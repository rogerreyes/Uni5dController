package co.com.uni5d.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mongodb.util.JSON;

import lombok.Data;




@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "Prueba2")
@Data
public class JSONObjectDB extends JSON{

}
