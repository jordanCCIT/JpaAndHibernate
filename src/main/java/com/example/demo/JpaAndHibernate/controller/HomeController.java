package com.example.demo.JpaAndHibernate.controller;

import com.example.demo.JpaAndHibernate.repo.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class HomeController {
    @Resource
    private TopicRepository topicRepo;

    @GetMapping("/")
    public String displayHomePage(Model model){
        model.addAttribute("topics",topicRepo.findAll());
        return "home";
    }
}
