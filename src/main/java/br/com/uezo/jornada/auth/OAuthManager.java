package br.com.uezo.jornada.auth;

public interface OAuthManager {
	
	public String getAuthorizationURL();
	public String getAccessToken(String authorizationCode);
	public String getEmail(String accessToken);
	public String getNome(String accessToken);
	public String getSobrenome(String accessToken);
	public String getId(String accessToken);

}
