package br.org.generation.personalBlog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.personalBlog.model.Theme;
import br.org.generation.personalBlog.repository.ThemeRepository;


@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ThemeController {

	@Autowired
	private ThemeRepository themeRepository;

	@GetMapping
	public ResponseEntity<List<Theme>> getAll() {
		return ResponseEntity.ok(themeRepository.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Theme> getById(@PathVariable long id) {
		return themeRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Theme>> getByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(themeRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}

	@PostMapping
	public ResponseEntity<Theme> postTheme(@Valid @RequestBody Theme theme) {
		return ResponseEntity.status(HttpStatus.CREATED).body(themeRepository.save(theme));
	}

	@PutMapping
	public ResponseEntity<Theme> putTheme(@Valid @RequestBody Theme theme) {
					
		return themeRepository.findById(theme.getId())
				.map(resposta -> {
					return ResponseEntity.ok().body(themeRepository.save(theme));
				})
				.orElse(ResponseEntity.notFound().build());
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePostagem(@PathVariable long id) {
		
		return themeRepository.findById(id)
				.map(resposta -> {
					themeRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}