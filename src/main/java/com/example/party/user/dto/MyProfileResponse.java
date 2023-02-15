package com.example.party.user.dto;

import com.example.party.user.entity.User;

import lombok.Getter;

@Getter
public class MyProfileResponse {
	private final String email; //user
	private final String nickName; //user
	private final String phoneNum; //user
	private final String proFileUrl; //profile
	private final String comment; //profile
	private final int participationCount; //profile

	public MyProfileResponse(User user) {
		this.email = user.getEmail();
		this.nickName = user.getNickname();
		this.phoneNum = user.getPhoneNum();
		this.proFileUrl = user.getProfileImg();
		this.comment = user.getComment();
		this.participationCount = user.getParticipationCnt();
	}

}
