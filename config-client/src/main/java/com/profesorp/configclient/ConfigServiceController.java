package com.profesorp.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profesorp.configclient.bean.BeanConfiguration;

@RestController
public class ConfigServiceController {
	
	@Value("${valores.valor_fijo}")
	String valorFijo;
	
	@Value("${valores.valor_funcion}") 
	String valorFuncion;
	
	@Autowired
	private Configuration configuration;

	@Autowired
	private ConfigurationData configurationData;

	@GetMapping("/configuration-bean")
	public BeanConfiguration getConfiguracion()
	{
		return new BeanConfiguration(configuration.getMinimum(),
				configuration.getMaximum(),valorFijo,valorFuncion);
	}
	
	
	@GetMapping("/configuration-value")
	public BeanConfiguration getConfiguracionRefrescada(@Value("${valores.valor_funcion}") String valorFuncion)
	{
		return new BeanConfiguration(configuration.getMinimum(),
				configuration.getMaximum(),valorFijo,valorFuncion);
	}
	@GetMapping("/configuration-properties")
	public ConfigurationData retrieveDatosFromConfigurations() {
		return configurationData;
	}
	
}
