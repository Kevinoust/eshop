package com.kevin.eshop.portal.dao.impl;

import com.kevin.eshop.portal.dao.UmsMemberLevelDao;
import com.kevin.eshop.portal.entity.UmsMemberLevel;
import com.kevin.eshop.portal.repository.UmsMemberLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UmsMemberLevelDaoImpl implements UmsMemberLevelDao {
    @Autowired
    private UmsMemberLevelRepository repository;

    @Override
    public Optional<UmsMemberLevel> getDefaultMemberLevel() {
        return repository.findOne((root, cq, cb) -> cb.equal(root.get("isDefaultLevel"), true));
    }
}
