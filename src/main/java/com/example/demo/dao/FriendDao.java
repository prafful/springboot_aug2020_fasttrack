package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.FriendEntity;
import com.example.demo.pojo.Friend;
import com.example.demo.repository.FriendRepository;

@Repository
public class FriendDao {

	@Autowired
	private FriendRepository friendRepository;

	public List<FriendEntity> getFriends() {
		
		return friendRepository.findAll();
	}
	
	
	public List<FriendEntity> addDbFriend(Friend f){
		FriendEntity fe = new FriendEntity();
		fe.setName(f.getName());
		fe.setLocation(f.getLocation());
		friendRepository.save(fe);
		return friendRepository.findAll();
	}
	
	
}
