package com.example.demo.JpaAndHibernate.repo;

import com.example.demo.JpaAndHibernate.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}
