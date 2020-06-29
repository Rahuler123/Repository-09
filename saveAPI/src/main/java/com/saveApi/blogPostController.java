package com.saveApi;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/blogPost")
public class blogPostController {
	
	
	private final blogPostService blogPostService;
	
	@Autowired
	public blogPostController(blogPostService blogPostService) {
		this.blogPostService = blogPostService;
	}
	
	@GetMapping
	public ResponseEntity<List<blogPost>> findAll() {
		return ResponseEntity.ok(blogPostService.findAll());
	}
	
	
	@GetMapping("/{blogId}")
	public ResponseEntity <blogPost> findById(@PathVariable Long blogId){
	//	Optional<blogPost> pst = blogPostService.findById(id);
		 return ResponseEntity.ok(blogPostService.findById(blogId).get());
		 
	}
	
	 @PostMapping("/create")
	 public ResponseEntity <blogPost> create (blogPost blogpst){
		 return ResponseEntity.status(HttpStatus.CREATED).body(blogPostService.save(blogpst));
		 }
	 
	 @PutMapping("/{blogId}")
	public ResponseEntity <blogPost> update (@PathVariable Long blogId, @RequestBody blogPost blogpst){
		return ResponseEntity.accepted().body(blogPostService.save(blogpst));
	}
	
//	@DeleteMapping("/{id}")
//	public ResponseEntity delete(@PathVariable Long id) {
//		blogPostService.deleteById(id);
//		return ResponseEntity.accepted().build();
//		
//	}
	
	

}
