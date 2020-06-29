package com.saveApi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface blogPostRepo extends JpaRepository<blogPost, Long> {

}
