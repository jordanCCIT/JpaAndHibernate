package com.example.demo.JpaAndHibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Hashtag {
    @Id@GeneratedValue
    private Long id;
    private String tagName;
    @ManyToMany(mappedBy = "hashtags")
    private Collection<Post> post;

    public Hashtag(String tagName, Post...post) {
        this.tagName = tagName;
        this.post = List.of(post);
    }

    public Hashtag(){

    }

    public Long getId() {
        return id;
    }

    public String getTagName() {
        return tagName;
    }

    public Collection<Post> getPost() {
        return post;
    }

    @Override
    public String toString() {
        return "Hashtag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashtag hashtag = (Hashtag) o;
        return Objects.equals(id, hashtag.id) && Objects.equals(tagName, hashtag.tagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tagName);
    }
}
