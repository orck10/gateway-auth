package br.com.gateway.autenticacao.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class StringUtils{
	public String encrypt(String key, String origen) {
		return DigestUtils.sha256Hex(key+origen);
	}
	
	public Boolean compare(String origen, String key, String hash) {
		String newHash = encrypt(key, origen);
		return newHash.equals(hash);
	}
}
