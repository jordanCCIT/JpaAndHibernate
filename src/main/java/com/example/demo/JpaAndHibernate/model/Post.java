package com.example.demo.JpaAndHibernate.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Post {
    @Id@GeneratedValue
    private Long id;
    private String title;
    @ManyToOne
    private Topic topic;
    @Lob
    private String content;
    private String author;
    @ManyToMany
    private Collection<Hashtag> hashtags;

    public Post(String title,Topic topic,String content,String author,Hashtag... hashtags){
        this.title=title;
        this.topic=topic;
        this.content=content;
        this.author=author;
        this.hashtags=List.of(hashtags);
    }

    public Post(){

    }

    public void addHashtag(Hashtag hashtag){
        hashtags.add(hashtag);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Topic getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", topic=" + topic +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(title, post.title) && Objects.equals(topic, post.topic) && Objects.equals(content, post.content) && Objects.equals(author, post.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, topic, content, author);
    }
}
