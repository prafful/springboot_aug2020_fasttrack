package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.FriendDao;
import com.example.demo.entity.FriendEntity;
import com.example.demo.pojo.Friend;

@Service
public class FriendService {

	@Autowired
	private FriendDao friendDao;
	
	
	public List<FriendEntity> getFriends() {
		
		return friendDao.getFriends();
	}
	
	
	public List<FriendEntity> addDbFriend(Friend f){
	
		return friendDao.addDbFriend(f);
	}
	
}
