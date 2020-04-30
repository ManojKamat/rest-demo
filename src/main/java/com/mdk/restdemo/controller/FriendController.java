package com.mdk.restdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdk.restdemo.model.Friend;
import com.mdk.restdemo.service.FriendService;

@RestController
public class FriendController {

	@Autowired
	private FriendService friendService;

	@GetMapping("/friend")
	public Iterable<Friend> read() {
		return friendService.findAll();
	}

	@PostMapping("/friend")
	public Friend create(@RequestBody Friend friend) {
		return friendService.save(friend);
	}

	@PutMapping("/friend")
	public Friend update(@RequestBody Friend friend) {
		return friendService.save(friend);
	}

	@DeleteMapping("/friend/{id}")
	public void delete(@PathVariable int id) {
		friendService.deleteById(id);
	}

	@GetMapping("/friend/search")
	public Iterable<Friend> search(@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName) {
		if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
			return friendService.findByFirstNameAndLastName(firstName, lastName);
		} else if (!StringUtils.isEmpty(firstName)) {
			return friendService.findByFirstName(firstName);
		} else if (!StringUtils.isEmpty(lastName)) {
			return friendService.findByLastName(lastName);
		}
		return null;
	}
}
