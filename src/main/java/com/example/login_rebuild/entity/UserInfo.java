package com.example.login_rebuild.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//データベースのテーブルと1対1で対応するクラスを置く場所
//データベースの1行分の情報を1つのオブジェクトとして表現する
//@Tableアノテーションでテーブル名を指定
@Entity
@Table(name = "user_info")
@Data
public class UserInfo {
    // ログインID：@IdでPKを指定、@ColumnはDBとカラム名が異なる場合に紐づけに使用
    @Id
    @Column(name = "login_id")
    private String loginId;

    // パスワード
    private String password;
}
