package br.com.gateway.autenticacao.dto;

public class RestTemplate {

	Object data;
	String status;
	
	public RestTemplate(Object data, String status) {
		super();
		this.data = data;
		this.status = status;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
