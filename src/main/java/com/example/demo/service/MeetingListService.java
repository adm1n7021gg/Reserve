package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.MeetingList;
import com.example.demo.mapper.MeetingListMapper;

@Service
public class MeetingListService {

	@Autowired
	private MeetingListMapper meetingListMapper;

	// Meeting_listを全件取得する
	@Transactional(readOnly = true)
	public List<MeetingList> findAll() {
		return MeetingListMapper.MeetingFindAll();
	}

	// live_listから1件取得する
	@Transactional
	public MeetingList findOne(Long dateId) {
		return meetingListMapper.meetingFindOne(dateId);
	}

	// live_listに新規登録する
	@Transactional
	public void insert(MeetingList meetingList) {
		meetingListMapper.meetingInsert(meetingList);
	}

	// live_listを更新する
	@Transactional
	public void update(MeetingList meetingList) {
		meetingListMapper.meetingUpdate(meetingList);
	}

	// live_listから1件削除する
	@Transactional
	public void delete(Long dateId) {
		meetingListMapper.meetingDelete(dateId);
	}

	// JOIN dateIdを結合
	public MeetingList selectMeetingList(Long dateId) {
		return meetingListMapper.selectMeetingList(dateId);
	}
}