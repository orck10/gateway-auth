package br.com.gateway.autenticacao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gateway.autenticacao.dao.UserDAO;

@Service
public class UserLoginService implements UserDetailsService{
	@Autowired
	UserDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		br.com.gateway.autenticacao.model.User user = null;
		try {
			user = dao.getByName(username).get(0);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		if(user == null) {
			return null;
		}
		
		List<String> roles = new ArrayList<>();
		roles.add("USER");
		
		if(user.getRoles() != null) {
			for(String role : user.getRoles()) {
				roles.add(role);
			}
		}
		
		String[] rolesArray = new String[roles.size()];
		
		return new User(user.getName(),
				user.getPassword(),
				AuthorityUtils.createAuthorityList(roles.toArray(rolesArray)));
	}
}
