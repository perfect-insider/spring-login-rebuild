package com.example.login_rebuild.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.login_rebuild.entity.UserInfo;
import com.example.login_rebuild.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

//ビジネスロジック（アプリの中心となる処理）をまとめる場所
//controllerから呼び出されて、実際の処理を行う
@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserInfoRepository repository;

    // ユーザー情報をログインIDで検索するメソッド
    public Optional<UserInfo> searchUsersById(String loginId) {
        // UserInfoRepositoryを使って、ログインIDでユーザー情報を検索
        return repository.findById(loginId);
    }

    /**
     * ユーザー認証を行う
     * 
     * @param loginId  ログインID
     * @param password パスワード
     * @return 認証が成功すればtrue、そうでなければfalse
     */
    public boolean authenticate(String loginId, String password) {
        // 1. searchUsersByIdメソッドを使って、loginIdからユーザー情報を取得する
        Optional<UserInfo> userInfoOpt = searchUsersById(loginId);

        // Optionalのメソッドチェーンでスマートに判定
        return userInfoOpt
                // ユーザーが存在すれば、パスワードが一致するかどうかを判定 (結果は true/false)
                .map(userInfo -> password.equals(userInfo.getPassword()))
                // ユーザーが存在しなければ、デフォルト値として false を返す
                .orElse(false);
    }

}
