package com.kevin.eshop.portal.dao;

import com.kevin.eshop.portal.entity.UmsMemberLevel;

import java.util.Optional;

public interface UmsMemberLevelDao {
    Optional<UmsMemberLevel> getDefaultMemberLevel();
}
