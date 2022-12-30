package com.apbatech.test.controllers;


import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apbatech.test.dto.ResponseData;
import com.apbatech.test.dto.UserData;
import com.apbatech.test.models.Userlogin;
import com.apbatech.test.service.UserloginService;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired private UserloginService userloginService;
    @Autowired private ModelMapper mapper;
    @PostMapping
    public ResponseEntity<ResponseData<Userlogin>> create(@Valid @RequestBody UserData userData,
            Errors errors) {
        ResponseData<Userlogin> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Userlogin userlogin = mapper.map(userData,Userlogin.class);
        responseData.setStatus(true);
        responseData.setData(userloginService.save(userlogin));

        return ResponseEntity.ok(responseData);
    }
    @GetMapping
    public Iterable<Userlogin> findAll() {
        return userloginService.findAll();
    }
    @PutMapping
    public ResponseEntity<ResponseData<Userlogin>> update(@Valid @RequestBody UserData userData,
            Errors errors) {
        ResponseData<Userlogin> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setData(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        Userlogin userlogin = mapper.map(userData,Userlogin.class);
        responseData.setStatus(true);
        responseData.setData(userloginService.save(userlogin));

        return ResponseEntity.ok(responseData);
    }
    @GetMapping("/{id}")
    public Userlogin findOne(@PathVariable("id") String id) {
        return userloginService.findOne(id);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeOne(@PathVariable("id") String id) {

        userloginService.removeOne(id);
        return ResponseEntity.ok().body("sukses");
    }
    @GetMapping("coba")
    public void nomer(){
    int arary1[] = {
        2,5,8,9
    };
    int nums[] = {
        1,
        2,
        3,
        4,
        5,
        6,
        7
    };
    for (int i : nums) {
        if(i ==arary1[0] || i ==arary1[1] || i ==arary1[2] || i ==arary1[3]){

        }else{

            System.out.println(i);
        }
    }
        System.out.println("List size: " +arary1[0]);
    }
    @GetMapping("replace")
    public void replace(){
        String Str = new String("PT.AbadI*perKASa@BeRsAmA-DIGItAL#SolUTiONs");
          
        // original string
        System.out.print("Original String : " );
        System.out.println(Str);
         
        // Using replaceAll to replace regex with replace_str
        System.out.print("After: " );
        System.out.println(Str.replaceAll("[*,#,@,-]"," "));
               
    }
    
}
