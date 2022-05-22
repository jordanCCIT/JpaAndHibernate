package com.example.demo.JpaAndHibernate.controller;

import com.example.demo.JpaAndHibernate.model.Hashtag;
import com.example.demo.JpaAndHibernate.model.Post;
import com.example.demo.JpaAndHibernate.repo.HashtagRepository;
import com.example.demo.JpaAndHibernate.repo.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class HashtagController {
    @Resource
    private HashtagRepository hashRepo;
    @Resource
    private PostRepository postRepo;


    @GetMapping("/hashtag/{id}")
    public String displaySingleHashtag(@PathVariable long id, Model model) {
        model.addAttribute("hashtag", hashRepo.findById(id).get());
        return "single-hashtag";
    }

    @GetMapping ("/hashtags")
    public String displayAllHashtags(Model model){
        model.addAttribute("allHashtags", hashRepo.findAll());
        return "/all-hashtags";
    }

    @PostMapping("/addHashtag")
    public String addHashtag(@RequestParam String newHashtag, @RequestParam String postId){
        Hashtag hashtagToSave = new Hashtag(newHashtag);
        hashRepo.save(hashtagToSave);
        long id = Long.parseLong(postId);
        Post post = postRepo.findById(id).get();
        post.addHashtag(hashtagToSave);
        postRepo.save(post);
        return "redirect:/posts/" + postId;
    }

    @PostMapping("/hashtag/post/{id}")
    public String displayPostsInHashtag(Model model, @PathVariable long id){
        model.addAttribute("post", postRepo.findById(id).get());
        model.addAttribute("allHashtags", hashRepo.findAll());
        model.addAttribute("postInHash", postRepo.findAll());
        return "single-hashtag";
    }
}
