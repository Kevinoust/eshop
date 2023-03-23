package com.kevin.eshop.portal.dao.impl;

import com.kevin.eshop.portal.dao.UmsMemberDao;
import com.kevin.eshop.portal.entity.UmsMember;
import com.kevin.eshop.portal.repository.UmsMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UmsMemberDaoImpl implements UmsMemberDao {
    @Autowired
    private UmsMemberRepository umsMemberRepository;

    @Override
    public List<UmsMember> searchByUserNameOrPhone(String userName, String telephone) {
        return umsMemberRepository.findAll((root, cq, cb) ->
                cb.or(
                    cb.equal(root.get("username"), userName),
                    cb.equal(root.get("phone"), telephone)
                ));
    }

    @Override
    public UmsMember insertNewMember(UmsMember umsMember) {
        return umsMemberRepository.save(umsMember);
    }
}
