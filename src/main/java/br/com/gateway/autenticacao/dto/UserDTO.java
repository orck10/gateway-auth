package br.com.gateway.autenticacao.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.gateway.autenticacao.model.User;

public class UserDTO {
	private String name;
	private String password;
	
	public UserDTO() {
		super();
	}

	public UserDTO(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserDTO parse(User user, boolean showpassword) {
		return new UserDTO(user.getName(), showPassWord(user.getPassword(), showpassword));
	}
	
	public List<UserDTO> parseList(List<User> list, boolean showpassword){
		List<UserDTO> newList = new ArrayList<UserDTO>();
		
		list.forEach(u -> newList.add(new UserDTO(u.getName(),showPassWord(u.getPassword(), showpassword))));
		return newList;
	}
	
	private String showPassWord(String password, boolean showpassword) {
		return showpassword ? password : "none";
	}
}
