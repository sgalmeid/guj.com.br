package br.com.caelum.guj.newsletter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

@Component
@ApplicationScoped
public class KeyReader {

	private String key;

	@PostConstruct
	public void initialize() throws IOException {
		Properties properties = new Properties();
		InputStream stream = KeyReader.class.getResourceAsStream("/key.properties");
		properties.load(stream);
		key = (String) properties.get("newsletter_key");
		stream.close();
	}

	public String getKey() {
		return key;
	}
}