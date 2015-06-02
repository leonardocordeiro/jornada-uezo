package br.com.uezo.jornada.auth;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.FacebookApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

public class FacebookOAuthManager implements OAuthManager {
	
	private static final String apiKey = "841047699264518";
	private static final String apiSecret = "d361db0a8060a8b394952ad48fffe3a1";
	
	private static final String callback = "http://localhost:8080/jornadauezo/oauth";
	private static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/me";
	
	private final OAuthService service;
	
	public FacebookOAuthManager() { 
		service = new ServiceBuilder().provider(FacebookApi.class)
						.apiKey(apiKey).apiSecret(apiSecret)
						.scope("email")
						.callback(callback).build();
				
	}
	
	public String getAuthorizationURL() { 
		return service.getAuthorizationUrl(null);
	}

	@Override
	public String getAccessToken(String authorizationCode) {
		Verifier verifier = new Verifier(authorizationCode);
		return service.getAccessToken(null, verifier).getToken();
	}

	@Override
	public String getEmail(String accessToken) {
		OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
		service.signRequest(new Token(accessToken, apiSecret), request);
		
		Response response = request.send();
		return response.getBody();	
	}
}
