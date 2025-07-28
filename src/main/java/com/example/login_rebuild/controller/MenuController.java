package com.example.login_rebuild.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    @GetMapping("/menu")
    public String view() {
        // メニュー画面を表示するための処理
        return "menu"; // menu.htmlを表示
    }
}
