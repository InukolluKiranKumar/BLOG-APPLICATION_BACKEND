package com.kiran;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

	@Autowired
	private PostService ps;
	
	private Post newPost() {
		Post p = new Post("Test Author","Test title", "Test content");
		p.setAuthor("tested");
		return p;
	}
	
	@Test
	void createPost() {
		Post saved = ps.createPost(newPost());
		
		assertTrue(saved.getId() > 0);
		assertNotNull(saved.getCreatedAt());
		
		ps.deletePost(saved.getId());
	}
	
	@Test
	void updatePost_changesTitleAndKeepsDate() {
		Post saved = ps.createPost(newPost());

		Post changes = new Post("New Author", "New title", "New content");
		Optional<Post> updated = ps.updatePost(saved.getId(), changes);

		assertTrue(updated.isPresent());
		assertEquals("New title", updated.get().getTitle());
		assertEquals(saved.getCreatedAt(), updated.get().getCreatedAt());   

		ps.deletePost(saved.getId());
	}

	@Test
	void deletePost_removesIt_andReturnsFalseIfMissing() {
		Post saved = ps.createPost(newPost());

		assertTrue(ps.deletePost(saved.getId()));      
		assertFalse(ps.deletePost(saved.getId()));     
	}
	
	
}
