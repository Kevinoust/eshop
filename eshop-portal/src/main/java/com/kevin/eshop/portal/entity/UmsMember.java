package com.kevin.eshop.portal.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ums_member")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UmsMember implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username", length = 64)
    private String username;
    @Column(name = "password", length = 64)
    private String password;
    @Column(name = "nickname", length = 64)
    private String nickname;
    @Column(name = "phone", length = 64)
    private String phone;
    @Column(name = "status")
    @Comment("0 for disabled, 1 for enabled")
    private Short status;
    @Column(name = "create_time")
    private LocalDateTime createTime;
    @Column(name = "icon", length = 500)
    private String icon;
    @Column(name = "gender")
    @Comment("0 for unknown, 1 for male, 2 for female")
    private Short gender;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "city", length = 64)
    private String city;
    @Column(name = "job", length = 100)
    private String job;
    @Column(name = "personalized_signature", length = 200)
    private String personalizedSignature;
    @Column(name = "source_type")
    private Integer sourceType;
    @Column(name = "integration")
    private Integer integration;
    @Column(name = "growth")
    private Integer growth;
    @Column(name = "lucky_count")
    private Integer luckyCount;
    @Column(name = "history_integration")
    private Integer historyIntegration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_level_id")
    private UmsMemberLevel umsMemberLevel;

    private static final long serialVersionUID = 1L;
}
