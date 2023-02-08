package com.bucket.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="TB_MEMBER")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    @Id
    @Column(name="U_IDX")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column(name="U_ID")
    private String id;

    @Column(name="U_PW")
    private String pw;

    @Column(name="U_UNIQUE_KEY")
    private String unique_key;

    @Column(name="U_NICKNAME")
    private String name;

    @Column(name="U_CONNECTION_TIME")
    private Date date;

}
