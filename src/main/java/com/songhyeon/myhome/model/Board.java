package com.songhyeon.myhome.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min=2, max=30, message = "제목은 2자이상 30자 이하로 작성해주세요.")
    private String title;
    private String content;

    // Lombok을 사용하면 게터/세터를 따로 생성해주지않아도 @Data 어노테이션으로
    // 게터/세터를 사용할 수 있음

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}
