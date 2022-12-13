package com.project.vtnw05.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.vtnw05.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    
}
