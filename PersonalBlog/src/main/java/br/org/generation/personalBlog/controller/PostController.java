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

import br.org.generation.personalBlog.model.Post;
import br.org.generation.personalBlog.repository.PostRepository;

@RestController
@RequestMapping("/postagem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {

	@Autowired
	private PostRepository postRepository;

	@GetMapping
	public ResponseEntity<List<Post>> getAll() {
		return ResponseEntity.ok(postRepository.findAll()); // = 200
	}

	@GetMapping("/{id}")
	public ResponseEntity<Post> getById(@PathVariable long id) {
		return postRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/title/{title}")
	public ResponseEntity<List<Post>> getByTitle(@PathVariable String title) {
		return ResponseEntity.ok(postRepository.findAllByTitleContainingIgnoreCase(title));
	}

	@PostMapping
	public ResponseEntity<Post> postPost(@Valid @RequestBody Post postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(postRepository.save(postagem));
	}

	@PutMapping
	public ResponseEntity<Post> putPost(@Valid @RequestBody Post post) {

		return postRepository.findById(post.getId())
				.map(reposta -> ResponseEntity.ok().body(postRepository.save(post)))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePost(@PathVariable long id) {
		return postRepository.findById(id).map(check -> {
			postRepository.deleteById(id);
			return ResponseEntity.ok().build();})
		.orElse(ResponseEntity.notFound().build());
	}

}
