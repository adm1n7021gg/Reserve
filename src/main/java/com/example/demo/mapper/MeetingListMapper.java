package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.MeetingCustomerList;
import com.example.demo.domain.MeetingList;

@Mapper
public interface MeetingListMapper {

	List<MeetingList> meetingFindAll();

	MeetingList meetingFindOne(Long dateId);

	void meetingInsert(MeetingList meetingList);

	void meetingUpdate(MeetingList meetimgList);

	void meetingDelete(Long dateId);

	List<MeetingCustomerList> meetingcustomerFindAll();

	// JOIN
	public MeetingList selectMeetingList(Long dateId);

	MeetingCustomerList meetingCustomerFindOne(Long id);

	void meetingCustomerInsert(MeetingCustomerList meetingCustomerList);

	void meetingCustomerUpdate(MeetingCustomerList meetingCustomerList);

	void meetingCustomerDelete(Long id);

}