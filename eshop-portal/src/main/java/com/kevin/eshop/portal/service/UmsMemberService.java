package com.kevin.eshop.portal.service;

public interface UmsMemberService {
    /**
     * Generate authentication code
     * @param telephone
     * @return
     */
    String generateAuthCode(String telephone);

    void register(String username, String password, String telephone, String authCode);
}
