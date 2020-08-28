package com.example.demo.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FriendEntity;
import com.example.demo.pojo.Friend;
import com.example.demo.repository.FriendRepository;
import com.example.demo.service.FriendService;

@RestController
public class FriendsRestController {
	
	List<Friend> friends = new ArrayList<Friend>();
	
	@Autowired
	private FriendService friendService;
	
	public FriendsRestController() {
		// TODO Auto-generated constructor stub
		
		Friend f1 = new Friend(1, "OBB", "Chennai");
		Friend f2 = new Friend(2, "OBBO", "Chennai");
		Friend f3 = new Friend(3, "CAS", "Bengaluru");
		Friend f4 = new Friend(4, "OWIOH", "Japan");
		
		friends.add(f1);
		friends.add(f2);
		friends.add(f3);
		friends.add(f4);
		
	}

	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Spring Boot!!!!using Dev Tools";
	}

	@RequestMapping("/message")
	public String welcomemessage() {
		return "Message -> Welcome to Spring Boot!!!! Again";
	}
	
	@RequestMapping("/all")
	public List<Friend> getAllFriends() {
		return friends;
	}
	
	@RequestMapping(value = "/all/friend/{myid}", method = RequestMethod.GET)
	public  Friend  getFriendById(@PathVariable("myid") int id) {
		Friend tf = new Friend();
		for (int i = 0; i < friends.size(); i++) {
			tf = friends.get(i);
			if(tf.getId() == id) {
				return tf;
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public List<Friend> addFriend(@RequestBody Friend f){
		friends.add(f);
		return friends;
	}
	
	@RequestMapping("/db/welcome")
	public String welcomedb() {
		
		return "Welcome to Spring Boot and Spring Data JPA!!";
	}
	
	
	
	@RequestMapping("/db/friends/all")
	public List<FriendEntity> getFriends() {
		
		return friendService.getFriends();
	}
	
	@RequestMapping(value = "/db/friends/add", method = RequestMethod.POST)
	public List<FriendEntity> addDbFriend(@RequestBody Friend f){
		return friendService.addDbFriend(f);
	}
}
