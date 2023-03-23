package com.kevin.eshop.portal.service.impl;

import com.kevin.eshop.common.service.RedisService;
import com.kevin.eshop.portal.pojo.config.RedisKeyProperties;
import com.kevin.eshop.portal.service.UmsMemberCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UmsMemberCacheServiceImpl implements UmsMemberCacheService {
    @Autowired
    private RedisKeyProperties redisKeyProperties;

    @Autowired
    private RedisService redisService;

    @Override
    public String getAuthCode(String telephone) {
        String key = redisKeyProperties.getDatabase() + ":" +
                redisKeyProperties.getKey().getAuthCode() + ":" +
                telephone;
        return (String) redisService.get(key);
    }

    /**
     *  Key = {Database}:{AuthCodeKey}:{Telephone}
     *  Value = {AuthCode}
     */
    @Override
    public void setAuthCode(String telephone, String authCode) {
        String key = redisKeyProperties.getDatabase() + ":" +
                     redisKeyProperties.getKey().getAuthCode() + ":" +
                     telephone;
        redisService.set(key, authCode, redisKeyProperties.getExpire().getAuthCode());
    }
}
