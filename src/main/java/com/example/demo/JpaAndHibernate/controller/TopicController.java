package com.example.demo.JpaAndHibernate.controller;

import com.example.demo.JpaAndHibernate.repo.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/topics")
public class TopicController {
    @Resource
    private TopicRepository topicRepo;

    @GetMapping("/{id}")
    public String displaySingleTopic(Model model, @PathVariable Long id){
        model.addAttribute("topic",topicRepo.findById(id).get());
        return "single-topic";
    }
}
