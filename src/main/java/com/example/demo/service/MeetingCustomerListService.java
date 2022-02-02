package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.MeetingCustomerList;
import com.example.demo.mapper.MeetingCustomerListMapper;

@Service
public class MeetingCustomerListService {

	@Autowired
	MeetingCustomerListMapper meetingCustomerListMapper;

	// customer_listの情報を1件取得する
	@Transactional
	public MeetingCustomerList findOne(Long id) {
		return meetingCustomerListMapper.meetingCustomerFindOne(id);
	}

	// customer_listへの新規登録処理
	@Transactional
	public void insert(MeetingCustomerList meetingCustomerList) {
		meetingCustomerListMapper.meetingCustomerInsert(meetingCustomerList);
	}

	// customer_listへの更新処理
	@Transactional
	public void update(MeetingCustomerList meetingCustomerList) {
		meetingCustomerListMapper.meetingCustomerUpdate(meetingCustomerList);
	}

	// customer_listへの削除処理
	@Transactional
	public void delete(Long id) {
		meetingCustomerListMapper.meetingCustomerDelete(id);
	}
}