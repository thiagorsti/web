package br.com.agricopias.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class TestController {

	@RequestMapping("/")
	@ResponseBody
	public String teste() {
		return "HELLO DOIDO";
	}
}
