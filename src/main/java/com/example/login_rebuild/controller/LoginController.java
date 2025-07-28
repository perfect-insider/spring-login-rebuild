package com.example.login_rebuild.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.login_rebuild.form.LoginForm;
import com.example.login_rebuild.service.LoginService;

import lombok.RequiredArgsConstructor;

//ユーザーからのリクエスト（画面操作やURLアクセス）を受け取る場所
//どの画面を表示するか、どの処理を実行するかを決める
@Controller
@RequiredArgsConstructor
public class LoginController {
    // loginServiceを使って、ユーザー情報の検索やログイン処理を行う
    private final LoginService service;

    @GetMapping("/login")
    public String view(Model model, LoginForm form) {
        // viewにフォームオブジェクトを指定する事で、model.addAttributeを省略可能
        // model.addAttribute("loginForm", form);

        // serviceを使って、ログインIDでユーザー情報を検
        return "login"; // login.htmlを表示
    }

    @PostMapping("/login")
    public String login(Model model, LoginForm form) {
        var userInfo = service.searchUsersById(form.getLoginId());
        var isCorrectUserAuth = userInfo.isPresent() &&
                form.getPassword().equals(userInfo.get().getPassword());

        if (isCorrectUserAuth) {
            // ログイン成功時の処理
            return "redirect:/menu"; // ログイン成功後のリダイレクト先
        } else {
            // ログイン失敗時の処理
            model.addAttribute("errorMsg", "ログインIDまたはパスワードが間違っています");
            return "login";
        }
    }
}
