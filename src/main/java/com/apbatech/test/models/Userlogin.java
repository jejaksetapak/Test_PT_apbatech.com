package com.apbatech.test.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userlogin")
public class Userlogin { 
        @Id   
        private String  kduser;
        private String  username;
        private String  password;
        private String  nama;
        private String  hakakses;
        private String  kdklinik;
        private String  kdcabang;
}
