package co.com.uni5d.dao;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.DBObject;

import co.com.uni5d.anotaciones.AcmeDao;
import co.com.uni5d.domain.Prueba;



@AcmeDao
public class AppDao  {

	
	@Autowired
	MongoTemplate mongoTemplate;

	public void salvarJson(Prueba prueba) {
	 mongoTemplate.save(prueba);
	}
	
	public void salvarJson2(Object object) {
		 mongoTemplate.save(object);
		}
}
