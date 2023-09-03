package com.dacartec.modelo;

public class Token {
	
	private final String token_type;
	private final Integer expires_in;
	private final Integer ext_expires_in;
	private final String access_token;
	
	/**
	 * @param token_type
	 * @param expires_in
	 * @param ext_expires_in
	 * @param access_token
	 */
	public Token(String token_type, Integer expires_in, Integer ext_expires_in, String access_token) {
		this.token_type = token_type;
		this.expires_in = expires_in;
		this.ext_expires_in = ext_expires_in;
		this.access_token = access_token;
	}

	public Token() {
		this.token_type = "";
		this.expires_in = null;
		this.ext_expires_in = null;
		this.access_token = "";
		
	}
	/**
	 * @return the token_type
	 */
	public String getToken_type() {
		return token_type;
	}
	/**
	 * @return the expires_in
	 */
	public Integer getExpires_in() {
		return expires_in;
	}
	/**
	 * @return the ext_expires_in
	 */
	public Integer getExt_expires_in() {
		return ext_expires_in;
	}
	/**
	 * @return the access_token
	 */
	public String getAccess_token() {
		return access_token;
	}

	
	
}