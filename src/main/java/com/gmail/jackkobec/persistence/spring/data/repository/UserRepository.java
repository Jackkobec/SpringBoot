package com.gmail.jackkobec.persistence.spring.data.repository;

import com.gmail.jackkobec.persistence.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Jack on 25.04.2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByName(String name);

    @Query(value = "SELECT u FROM User u WHERE u.name = :name")
    User searchByName(@Param("name") String name);

}