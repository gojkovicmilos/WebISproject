package lms.plugin;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Plugin {
	private PluginDescription description;
	
	public Plugin() {
	}

	public Plugin(PluginDescription description) {
		this.description = description;
	}

	public PluginDescription getDescription() {
		return description;
	}

	public void setDescription(PluginDescription description) {
		this.description = description;
	}
	
	public ResponseEntity<String> sendRequest(HttpMethod method, String url) {
		RestTemplate rt = new RestTemplate();
		return rt.getForEntity(url, String.class);
	}
}

