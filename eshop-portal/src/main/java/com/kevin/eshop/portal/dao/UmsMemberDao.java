package com.kevin.eshop.portal.dao;

import com.kevin.eshop.portal.entity.UmsMember;

import java.util.List;

public interface UmsMemberDao {
    List<UmsMember> searchByUserNameOrPhone(String userName, String telephone);
    UmsMember insertNewMember(UmsMember umsMember);
}
