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
		model.addAttribute("contents", "buildings/home :: home_contents");
		return "buildings/Layout/homeLayout";
	}
	
    //ホーム画面からお問い合わせフォーム画面遷移
	@GetMapping("/inquiry")
	public String getInquiry(Model model) {

		model.addAttribute("contents", "buildings/Inquiry/inquiry :: inquiry_contents");
		return "buildings/Layout/homeLayout";
	}

    //お問い合わせフォーム共通レイアウト反映
	@PostMapping("/inquiry")
	public String postInquiry(Model model) {
		return "buildings/Layout/homeLayout";
	}
	//集会室予約取り置きリスト画面遷移＆レイアウト反映
	@GetMapping("/MeetingList")
	public String getMeetingList(Model model) {
		model.addAttribute("contents", "buildings/MeetingList :: MeetingList_contents");
		return "buildings/Layout/homeLayout";
	}
	//集会室予約取り置きリスト画面遷移＆レイアウト反映
	@GetMapping("/Meeting/new")
	public String getnew(Model model) {
		model.addAttribute("contents", "buildings/Meeting/new :: new_contents");
		return "buildings/Layout/homeLayout";
	}
	

}