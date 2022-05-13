package com.example.tttn.mapper;

import com.example.tttn.entity.User;
import com.example.tttn.payload.response.UserInfo;

public class UserInfoMapper {
	public static UserInfo toUserInfo(User user) {
		return new UserInfo(user.getId(), user.getFirstName(), user.getLastName(), user.getUsername(), user.getEmail(),
				user.getDateOfBirth(), user.getRoles());

	}
}
