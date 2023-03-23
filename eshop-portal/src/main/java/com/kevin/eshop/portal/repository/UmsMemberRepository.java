package com.kevin.eshop.portal.repository;

import com.kevin.eshop.portal.entity.UmsMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UmsMemberRepository extends JpaRepository<UmsMember, Long>, JpaSpecificationExecutor<UmsMember> {
}
