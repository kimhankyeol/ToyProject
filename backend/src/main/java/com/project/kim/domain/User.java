package com.project.kim.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
//JPA를 사용해서 테이블과 매핑할 클래스에는 Entity 붙임
//@Entity(name="") name  JPA와 사용할 엔티티이름을 지정,사용하지않을경우 자동으로 클래스이름이 들어감
@Entity(name = "user") //클래스와 테이블 매핑
// 이 네임은 Table 명이고 엔티티와 매핑할 테이블을 지정함 생략시 매핑한 엔티티 이름을 테이블이름으로 지정
//@Table(name = "User") //매핑할 테이블 정보 명시
//여기서 테이블구조와 여기 클래스를 잘 비교하면 이해됨
//아래있는 것들은 컬럼 명과 일치해야됨 그래야 컬럼과 일치된 값들이 setter 에 담김
//User model.entity 안에 있는 DTO 명과 동시에 테이블명  DTO 명 과 테이블명이 일치 되어야 조회가 됨
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    @CreationTimestamp
    private Timestamp regDt;
    private String regUser;
    @UpdateTimestamp
    private Timestamp modDt;
    private String modUser;
    private int snsGb;
}
