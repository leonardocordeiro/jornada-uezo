package br.com.uezo.jornada.modelo;

import br.com.uezo.jornada.auth.FacebookOAuthManager;

public enum SocialNetwork {
	
	FACEBOOK {
		@Override
		public FacebookOAuthManager getOAuthManager() {
			return new FacebookOAuthManager();
		}
	};
	
	public abstract FacebookOAuthManager getOAuthManager(); 

}
