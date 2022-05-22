package com.example.demo.JpaAndHibernate.repo;

import com.example.demo.JpaAndHibernate.model.Hashtag;
import org.springframework.data.repository.CrudRepository;

public interface HashtagRepository extends CrudRepository<Hashtag,Long> {
}
