package com.apbatech.test.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apbatech.test.models.Userlogin;
import com.apbatech.test.repo.UserloginRepos;

@Transactional
@Service
public class UserloginService {
    @Autowired
    private UserloginRepos userloginRepos;
    public Userlogin save(Userlogin Userlogin) {

        return userloginRepos.save(Userlogin);
    }
    public Userlogin findOne(String id) {
        Optional<Userlogin> Userlogin = userloginRepos.findById(id);
        if (!Userlogin.isPresent()) {
            throw new RuntimeException(
                    String.format("Brand with Id '%s' Not exists", id)
                );
        }
        return Userlogin.get();
    }
    public Iterable<Userlogin> findAll(){
        return userloginRepos.findAll();
    }
    public void removeOne(String id){
        userloginRepos.deleteById(id);
    }
}
