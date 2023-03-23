package com.kevin.eshop.portal.repository;

import com.kevin.eshop.portal.entity.UmsMemberLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UmsMemberLevelRepository extends JpaRepository<UmsMemberLevel, Long>, JpaSpecificationExecutor<UmsMemberLevel> {
}
