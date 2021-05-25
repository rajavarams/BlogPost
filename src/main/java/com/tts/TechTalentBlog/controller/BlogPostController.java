package com.tts.TechTalentBlog.controller;

import com.tts.TechTalentBlog.model.BlogPost;
import com.tts.TechTalentBlog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/")
public class BlogPostController {

    @Autowired
    private BlogPostRepository blogPostRepository;
//    private List<BlogPost> posts = new ArrayList<>();

    @GetMapping
    public String index(BlogPost blogPost, Model model) {
        model.addAttribute("posts", blogPostRepository.findAll());
        return "blogpost/index";
    }

    private BlogPost blogPost;

    @GetMapping("/blogposts/new")
    public String newBlog (BlogPost blogPost) {
        return "blogpost/new";
    }

    @PostMapping("/blogposts")
    public String addNewBlogPost(BlogPost blogPost, Model model) {
        blogPostRepository.save(blogPost);
        model.addAttribute("title", blogPost.getTitle());
        model.addAttribute("author", blogPost.getAuthor());
        model.addAttribute("blogEntry", blogPost.getBlogEntry());
        model.addAttribute("createdDate", blogPost.getCreatedDate());
        model.addAttribute("id", blogPost.getId());

//        model.addAttribute("updated", blogPost.getUpdated());

        return "blogpost/result";
    }

//    @RequestMapping(value = "/blogpost/{id}", method = RequestMethod.DELETE)
//    public String deletePostWithId(@PathVariable Long id, BlogPost blogPost, Model model) {
//        //crud repository method
//        blogPostRepository.deleteById(id);
//        List<BlogPost> posts = blogPostRepository.findAll();
//        model.addAttribute("posts",posts);
//        return "blogpost/index";
//    }
//


    @RequestMapping(value = "/blogposts/{id}", method = RequestMethod.DELETE)
    public String deletePostWithId(@PathVariable Long id, BlogPost blogPost) {
        blogPostRepository.deleteById(id);
        return "blogpost/delete";
    }

    @RequestMapping(value = "/blogpost/{id}", method = RequestMethod.GET)
    public String editPostWithId(@PathVariable Long id, BlogPost blogPost, Model model) {
        Optional<BlogPost> post = blogPostRepository.findById(id);
        if(post.isPresent()) {
            BlogPost realPost = post.get();
            model.addAttribute("blogPost", realPost);
        }
        return "blogpost/edit";
    }

    @RequestMapping(value = "/blogposts/update/{id}", method = RequestMethod.POST)
    public String updatePost(@PathVariable Long id, BlogPost blogPost, Model model) {
        Optional<BlogPost> originalPost = blogPostRepository.findById(id);
        if(originalPost.isPresent()) {
            BlogPost newPost = originalPost.get();
            newPost.setTitle(blogPost.getTitle());
            newPost.setAuthor(blogPost.getAuthor());
            newPost.setBlogEntry(blogPost.getBlogEntry());


            blogPostRepository.save(newPost);
            model.addAttribute("title", newPost.getTitle());
            model.addAttribute("author", newPost.getAuthor());
            model.addAttribute("blogEntry", newPost.getBlogEntry());
            model.addAttribute("updated", newPost.getUpdated());

        }


        return "blogpost/result";
    }



}