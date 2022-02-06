package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String getHome(Model model) {

		//ホーム画面遷移
		model.addAttribute("contents", "home :: home_contents");
		return "Layout/homeLayout";
	}
	
    //ホーム画面からお問い合わせフォーム画面遷移
	@GetMapping("/inquiry")
	public String getInquiry(Model model) {

		model.addAttribute("contents", "Inquiry/inquiry :: inquiry_contents");
		return "Layout/homeLayout";
	}

    //お問い合わせフォーム共通レイアウト反映
	@PostMapping("/inquiry")
	public String postInquiry(Model model) {
		return "Layout/homeLayout";
	}

}