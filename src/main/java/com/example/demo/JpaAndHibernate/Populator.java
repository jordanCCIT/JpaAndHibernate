package com.example.demo.JpaAndHibernate;

import com.example.demo.JpaAndHibernate.model.Hashtag;
import com.example.demo.JpaAndHibernate.model.Post;
import com.example.demo.JpaAndHibernate.model.Topic;
import com.example.demo.JpaAndHibernate.repo.HashtagRepository;
import com.example.demo.JpaAndHibernate.repo.PostRepository;
import com.example.demo.JpaAndHibernate.repo.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner{
    @Resource
    private TopicRepository topicStorage;
    @Resource
    private PostRepository postStorage;
    @Resource
    private HashtagRepository hashtagStorage;

    @Override
    public void run(String... args) throws Exception {
        Hashtag hashtag1 = new Hashtag("#TDD4Fun");
        hashtagStorage.save(hashtag1);
        Hashtag hashtag2 = new Hashtag("#Testing Fear");
        hashtagStorage.save(hashtag2);
        Hashtag hashtag3 = new Hashtag("#Testing Unity");
        hashtagStorage.save(hashtag3);
        hashtagStorage.findAll();


        Topic topic1 = new Topic("Learning TDD");
        topicStorage.save(topic1);
        Topic topic2 = new Topic("Battling Imposter Syndrome");
        topicStorage.save(topic2);
        Topic topic3 = new Topic("Introductory Java");
        topicStorage.save(topic3);
        Topic topic4 = new Topic("Object Oriented Programming and You");
        topicStorage.save(topic4);




        Post post1 = new Post("TDD For Fun and Profit", topic1, "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.", "Anonymous", hashtag1,hashtag2,hashtag3);
        postStorage.save(post1);

        Post post2 = new Post("Test the Fear Away", topic1, "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.", "Anonymous", hashtag2);
        postStorage.save(post2);

        Post post3 = new Post("Unit Tests and You", topic1, "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.", "Anonymous", hashtag3);
        postStorage.save(post3);

    }
}
