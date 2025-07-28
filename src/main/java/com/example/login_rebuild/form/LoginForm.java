package com.example.login_rebuild.form;

import lombok.Data;

//画面から送られてくる入力データを受け取るためのクラスを置く場所
//入力フォームの内容を一時的に保存する役割
@Data
public class LoginForm {
    private String loginId;
    private String password;
}
