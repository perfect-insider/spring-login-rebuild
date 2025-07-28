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

    public Optional<UserInfo> searchUsersById(String loginId) {
        // UserInfoRepositoryを使って、ログインIDでユーザー情報を検索
        return repository.findById(loginId);
    }

}
