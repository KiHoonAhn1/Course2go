package com.course2go.service.user;

import java.util.List;
import java.util.Optional;

import com.course2go.model.user.User;
import com.course2go.model.user.UserDto;

public interface UserService {
	Optional<User> getUserByUserNickname(String nickname);

	List<UserDto> searchUser(String requestNickname, String userName);
}