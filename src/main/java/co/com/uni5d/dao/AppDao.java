package co.com.uni5d.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;


import co.com.uni5d.anotaciones.AcmeDao;
import co.com.uni5d.domain.Prueba;



@AcmeDao
public class AppDao {

	
	@Autowired
	MongoTemplate mongoTemplate;

	public void salvarJson(Prueba prueba) {
	 mongoTemplate.save(prueba);
	}
	
	
}
