package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.MeetingCustomerList;
import com.example.demo.domain.MeetingList;

@Mapper
public interface MeetingCustomerListMapper{
	
	List<MeetingCustomerList> meetingcustomerFindAll();

	// JOIN
	public MeetingList selectMeetingList(Long dateId);

	MeetingCustomerList meetingCustomerFindOne(Long id);

	void meetingCustomerInsert(MeetingCustomerList meetingCustomerList);

	void meetingCustomerUpdate(MeetingCustomerList meetingCustomerList);

	void meetingCustomerDelete(Long id);
	
}