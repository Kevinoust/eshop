package com.kevin.eshop.portal.service.impl;

import com.kevin.eshop.common.dto.ResultCode;
import com.kevin.eshop.common.exception.Asserts;
import com.kevin.eshop.portal.dao.UmsMemberDao;
import com.kevin.eshop.portal.dao.UmsMemberLevelDao;
import com.kevin.eshop.portal.entity.UmsMember;
import com.kevin.eshop.portal.entity.UmsMemberLevel;
import com.kevin.eshop.portal.service.UmsMemberCacheService;
import com.kevin.eshop.portal.service.UmsMemberService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.kevin.eshop.portal.constant.UmsConstant.MEMBER_STATUS_ENABLED;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private UmsMemberCacheService umsMemberCacheService;

    @Autowired
    private UmsMemberDao umsMemberDao;

    @Autowired
    private UmsMemberLevelDao umsMemberLevelDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String generateAuthCode(String telephone) {
        String authCode = generateAuthCode();
        umsMemberCacheService.setAuthCode(telephone, authCode); // cache in redis
        return authCode;
    }

    @Override
    @Transactional
    public void register(String username, String password, String telephone, String authCode) {
        // verify if auth code is valid
        if(!verifyAuthCode(telephone, authCode)) {
            Asserts.fail(ResultCode.AUTH_CODE_NOT_VALID);
        }
        // verify if already registered as member
        if(isExistMember(username, telephone)) {
            Asserts.fail(ResultCode.USER_ALREADY_EXISTED);
        }
        // register
        UmsMemberLevel umsMemberLevel = umsMemberLevelDao.getDefaultMemberLevel()
                                                         .orElseThrow(() -> Asserts.exceptionSupplier(ResultCode.FAILED));

        UmsMember member = UmsMember.builder().username(username)
                                              .password(passwordEncoder.encode(password))
                                              .phone(telephone)
                                              .status(MEMBER_STATUS_ENABLED)
                                              .umsMemberLevel(umsMemberLevel)
                                              .createTime(LocalDateTime.now()).build();

        umsMemberDao.insertNewMember(member);
        member.setPassword(null);
    }

    private String generateAuthCode() {
        Random random = new Random();
        return IntStream.generate(() -> random.nextInt(10))
                                              .limit(6)
                                              .boxed()
                                              .map(String::valueOf)
                                              .collect(Collectors.joining());
    }

    private boolean verifyAuthCode(String telephone, String authCode) {
        if(StringUtils.isEmpty(authCode)) {
            return false;
        }
        String actualAuthCode = umsMemberCacheService.getAuthCode(telephone);
        return authCode.equals(actualAuthCode);
    }

    private boolean isExistMember(String username, String telephone) {
        return umsMemberDao.searchByUserNameOrPhone(username, telephone).size() > 0;
    }
}
