package com.example.demo.JpaAndHibernate.controller;

import com.example.demo.JpaAndHibernate.model.Post;
import com.example.demo.JpaAndHibernate.model.Topic;
import com.example.demo.JpaAndHibernate.repo.PostRepository;
import com.example.demo.JpaAndHibernate.repo.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Resource
    private PostRepository postRepo;
    @Resource
    private TopicRepository topicRepo;

    @GetMapping("/{id}")
    public String displaySinglePost(Model model, @PathVariable Long id){
        model.addAttribute("post",postRepo.findById(id).get());
        return "single-post";
    }

    @PostMapping("/addPost")
    public String addPost(@RequestParam String title,@RequestParam String topicId,@RequestParam String content,@RequestParam String author){
        Long id = Long.parseLong(topicId);
        Topic postTopic = topicRepo.findById(id).get();
        Post postToAdd = new Post(title,postTopic,content,author);
        postRepo.save(postToAdd);
        postTopic.addPost(postToAdd);
        topicRepo.save(postTopic);

        return "redirect:/";
    }
}
