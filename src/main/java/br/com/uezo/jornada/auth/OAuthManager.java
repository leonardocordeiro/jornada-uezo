package br.com.uezo.jornada.auth;

public interface OAuthManager {
	
	public String getAuthorizationURL();
	public String getAccessToken(String authorizationCode);
	public String getEmail(String accessToken);

}
