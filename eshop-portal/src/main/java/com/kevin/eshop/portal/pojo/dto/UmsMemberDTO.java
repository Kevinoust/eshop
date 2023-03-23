package com.kevin.eshop.portal.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UmsMemberDTO {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String telephone;
    @NotNull
    private String authCode;
}
