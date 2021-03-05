package br.com.gateway.autenticacao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status/")
public class Status {
	@GetMapping
	@ResponseBody
	public String getStatus() {
		return "OK";
	}
}
