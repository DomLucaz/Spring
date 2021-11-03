package br.org.generation.hello2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/hello")
public class Hello2Controller {
@GetMapping
public String helloShow () {
	return "Entregar todos os exercicios dentro do prazo, elaborar o pitch, estudar mais sobre MySql e Spring";
	}
		
}