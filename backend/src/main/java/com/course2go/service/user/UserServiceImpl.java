package com.course2go.service.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.course2go.dao.FollowDao;
import com.course2go.model.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course2go.dao.UserDao;
import com.course2go.model.user.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	FollowDao followDao;

	@Override
	public List<UserDto> searchUser(String requestNickname, String keyword) {
		System.out.println("UserServiceImple : searchUser(" + requestNickname + ", " + keyword + ") 실행");
		List<UserDto> result = new ArrayList<>(); // 유저검색결과를 포함한 결과
		List<User> nameContainingList = userDao.findByUserNameContaining(keyword); // 검색한 이름을 포함하는 유저들의 리스트
		System.out.println(nameContainingList.toString());
		List<User> nickNameContainingList = userDao.findByUserNicknameContaining(keyword); // 검색한 닉네임을 포함하는 유저들의 리스트
		System.out.println(nickNameContainingList.toString());

		for (int i = 0; i < nameContainingList.size(); i++) {
			User tmpUser = nameContainingList.get(i);
			UserDto userDto = new UserDto();
			if(requestNickname.equals(tmpUser.getUserNickname())){
				// 검색한 이름을 포함하는 유저가 본인인 경우
				nameContainingList.remove(i);
				continue;
			}else{
				userDto.setUserName(tmpUser.getUserName());
				userDto.setUserNickname(tmpUser.getUserNickname());
				userDto.setUserImage(tmpUser.getUserImage());
			}
			result.add(userDto);
		}

		for (int i = 0; i < nickNameContainingList.size(); i++) {
			User tmpUser = nickNameContainingList.get(i);
			UserDto userDto = new UserDto();
			if(requestNickname.equals(tmpUser.getUserNickname())){
				// 검색한 닉네임을 포함하는 유저가 본인인 경우
				nickNameContainingList.remove(i);
				continue;
			}else{
				userDto.setUserName(tmpUser.getUserName());
				userDto.setUserNickname(tmpUser.getUserNickname());
				userDto.setUserImage(tmpUser.getUserImage());
			}
			result.add(userDto);
		}
		System.out.println(result.toString());
		return result;
	}

	@Override
	public String getUserNicknameByUid(String uid) {
		return userDao.findById(uid).get().getUserNickname();
	}

	@Override
	public String getUidByUserNickname(String userNickname) {
		return userDao.findUserByUserNickname(userNickname).get().getUid();
	}
}
