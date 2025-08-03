package com.example.login_rebuild.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// バリデーションに必要なアノテーションのインポート
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String login(Model model, @Validated LoginForm form, BindingResult bindingResult) {
        // バリデーションチェック
        // LoginFormに@Validatedアノテーションを付けることで、入力値の検証を行う
        // BindingResultは、バリデーションの結果を保持するオブジェクト
        if (bindingResult.hasErrors()) {
            return "login"; // 入力エラーがある場合は再度ログイン画面を表示
        }

        // LoginServiceのauthenticateメソッドの結果で判断
        if (service.authenticate(form.getLoginId(), form.getPassword())) {
            // ログイン成功時の処理
            return "redirect:/menu"; // ログイン成功後のリダイレクト先
        } else {
            // ログイン失敗時の処理
            model.addAttribute("errorMsg", "ログインIDまたはパスワードが間違っています");
            return "login";
        }
    }
}
