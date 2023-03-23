package com.kevin.eshop.portal.controller;

import com.kevin.eshop.common.dto.CommonResponse;
import com.kevin.eshop.portal.pojo.dto.UmsMemberDTO;
import com.kevin.eshop.portal.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @GetMapping("/getAuthCode")
    public CommonResponse<?> getAuthCode(@RequestParam String telephone) {
        String authCode = umsMemberService.generateAuthCode(telephone);
        return CommonResponse.success(authCode, "Success - get authentication code");
    }

    @PostMapping("/register")
    public CommonResponse<?> register(@RequestBody @Validated UmsMemberDTO umsMemberDTO) {
        umsMemberService.register(umsMemberDTO.getUsername(), umsMemberDTO.getPassword(), umsMemberDTO.getTelephone(), umsMemberDTO.getAuthCode());
        return CommonResponse.success(null, "Success - member registration");
    }


}
