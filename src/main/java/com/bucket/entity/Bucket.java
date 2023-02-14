package com.bucket.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="TB_BUCKET")
public class Bucket {

    @Id
    @Column(name="B_IDX")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;


    @Column(name="B_TITLE")
    private String title;

    @Column(name="B_CONTENT")
    private String content;

    @Column(name="B_MAINIMG")
    private String mainimg;

    @Column(name="B_PERMISSION")
    private String permission;

    @Column(name="B_LIKE")
    private String like;

    @Column(name="B_VIEW")
    private String view;

    @Column(name="B_DATE")
    private Date date;

    @Column(name="B_SUCCESS_DATE")
    private Date sdate;

    @Column(name="U_IDX")
    private String u_id;

}
