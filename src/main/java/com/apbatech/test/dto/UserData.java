package com.apbatech.test.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserData {
    @NotEmpty(message = "Name is required")
    private String  kduser;
    private String  username;
    private String  password;
    private String  nama;
    private String  hakakses;
    private String  kdklinik;
    private String  kdcabang;
}
