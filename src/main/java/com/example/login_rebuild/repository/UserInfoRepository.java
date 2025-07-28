package com.example.login_rebuild.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.login_rebuild.entity.UserInfo;

//データベースとやり取りするための場所
//データの保存・取得・更新・削除などを担当する
//JpaRepositoryを継承することで、CRUD処理のメソッドが自動で生成される
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

}