package com.example.demo.controller;

import java.util.List;

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
import com.example.demo.domain.MeetingList;
import com.example.demo.service.MeetingListService;

/**
 * ライブ日程のリストを表示するコントローラー
 * ログイン後始めに表示されるページ
 * @author keita
 */

@Controller
@RequestMapping("MeetingList")
public class MeetingListController {

	@Autowired
	private MeetingListService meetingListService;

	/**
	 * @param model MeetingList.htmlへデータを持っていく
	 * @return MeetingList.htmlへ遷移
	 */

	// Meeting一覧画面の表示
	@GetMapping("/MeetingList")
	public String findAll(Model model) {
		List<MeetingList> meetingList = meetingListService.findAll();
		model.addAttribute("meetingList", meetingList);
		return "MeetingList";
	}

	/**
	 * MeetigListデータ入力画面に遷移する
	 * @param model MeetingList.htmlへデータを持っていく
	 * @return MeetingList.htmlへ遷移
	 */

	// 集会室取り置き日程新規作成画面の表示
	@GetMapping("new")
	public String newMeetingList(@ModelAttribute MeetingList meetingList, Model model) {
		model.addAttribute("meetingList", meetingList);
		return "Meeting/new";
	}

	// 集会室取り置き日程編集画面の表示
	@GetMapping("{dateId}/edit")
	public String edit(@PathVariable Long dateId, Model model) {
		MeetingList meetingList = meetingListService.findOne(dateId);
		model.addAttribute("meetingList", meetingList);
		return "Meeting/edit";
	}

	// 時間外予約取り置きリスト表示画面の表示
	@GetMapping("{dateId}")
	public String show(@PathVariable Long dateId, Model model) {
		MeetingList MeetingListChoise = meetingListService.selectMeetingList(dateId);

		// MeetingCustomerListに何もなければnullを渡す
		try {
			List<MeetingCustomerList> meetingCustomerLists = meetingListChoise.getCustomers();
			model.addAttribute("meetingCustomerLists", meetingCustomerLists);
		} catch (NullPointerException e) {
			// TODO: handle exception
			model.addAttribute("meetingCustomerLists", null);
		}

		MeetingList meetingList = meetingListService.findOne(dateId);
		model.addAttribute("meetingList", meetingList);
		return "buildings/Meeting/show";
	}

	// Live日程データの保存
	@PostMapping
	@Transactional
	public String create(@Valid @ModelAttribute MeetingList meetingList,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "/buildings/Meeting/new";
		}
		meetingListService.insert(meetingList);
		return "redirect:/MeetingList";
	}

	// Live日程データの更新
	@GetMapping("/update/{dateId}")
	@Transactional(readOnly = false)
	public String update(@PathVariable Long dateId,
			@Valid @ModelAttribute MeetingList meetingList, BindingResult result) {
		if (result.hasErrors()) {
			return "/buildings/Meeting/edit";
		}
		meetingList.setDateId(dateId);
		meetingListService.update(meetingList);
		return "redirect:/buildings";
	}

	// Live日程データの削除
	@PostMapping("/{dateId}")
	@Transactional
	public String delete(@PathVariable Long dateId) {
		meetingListService.delete(dateId);
		return "redirect:/liveList";
	}
}