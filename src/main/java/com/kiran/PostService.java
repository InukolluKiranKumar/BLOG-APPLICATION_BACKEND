package com.kiran;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	
	private PostRepo pr;
	
	public PostService(PostRepo pr) {
		super();
		this.pr = pr;
	}

	public Post createPost(Post p) {
		p.setCreatedAt(LocalDateTime.now());
		return pr.save(p);
	}
	
	public List<Post> viewAllPosts() {
		return pr.findAll();
	}
	
	public Optional<Post> getPostById(int id) {
		return pr.findById(id);
	}
	
	public Optional<Post> updatePost(int id, Post nd){
		
		Optional<Post> existing = pr.findById(id);
		
		if(existing.isEmpty()) {
			return Optional.empty();
		}
		
		Post p = existing.get();
		
		p.setTitle(nd.getTitle());
		p.setContent(nd.getContent());
		
		return Optional.of(pr.save(p));
	}
	
	public boolean deletePost(int id) {

		if (!pr.existsById(id)) {
			return false;
		}

		pr.deleteById(id);
		return true;
	}
	
	
	
	

}
