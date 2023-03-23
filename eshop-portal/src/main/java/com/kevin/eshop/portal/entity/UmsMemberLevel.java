package com.kevin.eshop.portal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ums_member_level")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UmsMemberLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description", length = 100)
    private String description;
    @Column(name = "is_default_level")
    private Boolean isDefaultLevel;
    @Column(name = "can_free_shopping")
    private Boolean canFreeShopping;
    @Column(name = "can_sign_in")
    private Boolean canSignIn;
    @Column(name = "can_comment")
    private Boolean canComment;
    @Column(name = "can_promotion")
    private Boolean canPromotion;
}
