package com.kevin.eshop.portal.service;

public interface UmsMemberCacheService {
    /**
     * get auth code from cache
     * @param telephone
     * @return
     */
    String getAuthCode(String telephone);

    /**
     * set auth code to cache
     * @param telephone
     * @param authCode
     */
    void setAuthCode(String telephone, String authCode);
}
