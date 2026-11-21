package com.kiran;

import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
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

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/posts")
public class PostController {


	private PostService ps;

	public PostController(PostService ps) {
		super();
		this.ps = ps;
	}
	
	@PostMapping("/createPost")
	public Post createPost(@RequestBody Post p) {
		return ps.createPost(p);
	}
	
	@GetMapping("/viewPosts")
	public List<Post> getAllPosts(){
		return ps.viewAllPosts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable int id){
		Optional<Post> p = ps.getPostById(id);
		
		if(p.isPresent()) {
			return ResponseEntity.ok(p.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody Post post){
		
		Optional<Post> updated = ps.updatePost(id, post);
		
		if(updated.isPresent()) {
			return ResponseEntity.ok(updated.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePost(@PathVariable int id) {

		if (ps.deletePost(id)) {
			return ResponseEntity.ok("Post deleted successfully");
		}
		return ResponseEntity.status(404).body("Post not found with id " + id);
	}
}
