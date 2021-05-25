package com.tts.TechTalentBlog.repository;

import com.tts.TechTalentBlog.model.BlogPost;
import org.springframework.data.repository.CrudRepository;

public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {
    BlogPost deleteById(long id);



}
