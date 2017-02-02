package co.com.uni5d.services;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.uni5d.anotaciones.AcmeService;
import co.com.uni5d.dao.AppDao;
import co.com.uni5d.domain.Prueba;

@AcmeService
public class PruebaService {

	
	
	@Autowired
	private AppDao appDao;
	
	
	
	public void guardarPrueba(Prueba prueba) {
		appDao.salvarJson(prueba);
	}
	
}
