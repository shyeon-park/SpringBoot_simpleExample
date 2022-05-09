package com.songhyeon.myhome.repository;

import com.songhyeon.myhome.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslPredicate;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User>, CustomizedUserRepository {
    @EntityGraph(attributePaths = { "boards" })
    List<User> findAll();

    User findByUsername(String username);

    // jpql
    @Query("select u from User u where u.username like %?1%")
    List<User> findByUsernameQuery(String username);

    // 순수 sql 쿼리문
    @Query(value = "select * from User u where u.username like %?1%", nativeQuery = true)
    List<User> findByUsernameNativeQuery(String username);
}
