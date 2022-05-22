package com.example.demo.JpaAndHibernate.repo;

import com.example.demo.JpaAndHibernate.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic,Long> {
}
