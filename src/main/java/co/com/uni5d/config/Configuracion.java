package co.com.uni5d.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;

@Configuration
@ComponentScan("co.com.uni5d")
public class Configuracion {
	
	
	@Value("${connect.timeout}")
	private int connectTimeOut;
	
	@Value("${read.timeout}")
	private int readTimeout;
	
	
	@Bean(name="uni5dRestTemplate")
	public RestOperations crearBean(final RestTemplateBuilder builder) {
		return builder.setReadTimeout(readTimeout).setConnectTimeout(connectTimeOut).build();
	}

  

}
