package com.saveApi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class blogPostService{

	
	private final blogPostRepo blogPostRepo;
	
	
	@Autowired
	public blogPostService (blogPostRepo blogPostRepo ) {
		this.blogPostRepo = blogPostRepo;
		
	}
	public List<blogPost> findAll(){
		return blogPostRepo.findAll();
	}
	
	public Optional <blogPost> findById(Long id){
		return blogPostRepo.findById(id);
		
	}
	 
	public blogPost save (blogPost mobi) {
		return blogPostRepo.save(mobi);
	}
	public void deleteById(Long id) {
		blogPostRepo.deleteById(id);
		
	}
}


