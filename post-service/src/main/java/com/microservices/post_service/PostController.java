package com.microservices.post_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {
@GetMapping(value = "/{postId}")
    public Posts getPost(@PathVariable("postId") String postId){
    Posts post1 = new Posts(postId,"Post description"+postId);
    return post1;
}

}
