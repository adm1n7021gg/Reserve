package com.example.demo.domain;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class MeetingCustomerList {

	/** ID */
	private Long id;

	/** 日付ID */
	@NotNull
	@Digits(integer = 8, fraction = 0)
	private Long dateId;

	/** 名前 */
	@NotBlank
	@Size(max = 50)
	private String name;

	/** 枚数 */
	@NotNull
	@Range( min = 1, max = 99)
	private int number;

	/** 備考 */
	private String comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDateId() {
		return dateId;
	}

	public void setDateId(Long dateId) {
		this.dateId = dateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}