package com.apbatech.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apbatech.test.models.Userlogin;

public interface UserloginRepos extends JpaRepository<Userlogin,String> {
    
}
