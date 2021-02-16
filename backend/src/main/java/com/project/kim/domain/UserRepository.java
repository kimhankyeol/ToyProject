package com.project.kim.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
  public User findByEmailAndPassword(String email , String password);
  public User findByEmailAndSnsGb(String email , int snsGb);


}