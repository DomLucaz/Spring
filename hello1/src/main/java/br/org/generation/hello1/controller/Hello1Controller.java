package br.org.generation.hello1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/hello")
public class Hello1Controller {
@GetMapping
public String helloShow () {
	return "Persistência para manter o foco no curso e mentalidade de crescimento porque estou acordado até tarde codando";
	}
		
}