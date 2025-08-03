package com.example.login_rebuild.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

//画面から送られてくる入力データを受け取るためのクラスを置く場所
//入力フォームの内容を一時的に保存する役割
@Data
public class LoginForm {
    @NotBlank(message = "ログインIDを入力してください")
    private String loginId;
    @NotBlank(message = "パスワードを入力してください")
    private String password;
}
