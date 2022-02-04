package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.MeetingCustomerList;
import com.example.demo.service.MeetingCustomerListService;

/**
 * お客さんのリストを操作するコントローラー
 * @author keita
 *
 */
@Controller
@RequestMapping("meetingcustomer")
public class MeetingCustomerListController {

	@Autowired
	private MeetingCustomerListService meetingCustomerListService;


	// お客さん情報新規作成画面の表示
	@GetMapping("/customerNew/{dateId}")
	public String newMeetingCustomerList(@PathVariable("dateId") Long dateId, @ModelAttribute MeetingCustomerList meetingCustomerList,
			Model model) {
		model.addAttribute("meetingCustomerList", meetingCustomerList);
		return "meetingcustomer/customerNew";
	}

	// お客さん情報編集画面の表示
	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		MeetingCustomerList meetingCustomerList = meetingCustomerListService.findOne(id);
		model.addAttribute("meetingCustomerList", meetingCustomerList);
		return "meetingcustomer/customerEdit";
	}

	// customerデータの保存
	@PostMapping
	public String meetingcustomerCreate(
			@Valid @ModelAttribute MeetingCustomerList meetingCustomerList,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "meetingcustomer/customerNew";
		}
		meetingCustomerListService.insert(meetingCustomerList);
		return "redirect:/meetinglist";
	}

	// お客さんデータの更新
	@GetMapping("/update/{id}")
	@Transactional(readOnly = false)
	public String update(@PathVariable Long id,
			@Valid @ModelAttribute MeetingCustomerList meetingCustomerList, BindingResult result) {
		if (result.hasErrors()) {
			return "/meetingcustomer/customerEdit";
		}
		meetingCustomerList.setId(id);
		meetingCustomerListService.update(meetingCustomerList);
		return "redirect:/meetingList";
	}

	// お客さんデータの削除
	@PostMapping("/{id}")
	public String delete(@PathVariable Long id) {
		meetingCustomerListService.delete(id);
		return "redirect:/meetingList";
	}

}