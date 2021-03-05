package br.com.gateway.autenticacao.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.gateway.autenticacao.utils.StringUtils;

@Service
public class PasswordService implements PasswordEncoder{
	
	@Value("${project.util.key}")
	private String key;
	
	@Override
	public String encode(CharSequence rawPassword) {
		return new StringUtils().encrypt(key, rawPassword.toString());
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return new StringUtils().compare(rawPassword.toString(), key, encodedPassword);
	}

}
