package com.worksplit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.worksplit.models.RelationshipModel;
import com.worksplit.models.UserModel;
import com.worksplit.service.interfaces.RelationshipService;

import java.util.List;

@RestController
public class RelationshipController {

	@Autowired
	RelationshipService relationshipService;
	
	@RequestMapping(value = "invitefriend", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<RelationshipModel> inviteFriend(@RequestBody RelationshipModel relationship) {
		try {

			return new ResponseEntity<>(relationshipService.inviteFriend(relationship), HttpStatus.OK);
		} catch (Exception e) {

			// For unknown scenarios
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}

	@RequestMapping(value = "acceptrequest", method = RequestMethod.POST)
	public ResponseEntity<RelationshipModel> acceptRequest(RelationshipModel relationship) {
		try {

			return new ResponseEntity<>(relationshipService.acceptRequest(relationship), HttpStatus.OK);
		} catch (Exception e) {

			// For unknown scenarios
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}

	@RequestMapping(value = "removefriend", method = RequestMethod.POST)
	public ResponseEntity<RelationshipModel> removeFriend(RelationshipModel relationship) {
		try {

			return new ResponseEntity<>(relationshipService.acceptRequest(relationship), HttpStatus.OK);
		} catch (Exception e) {

			// For unknown scenarios
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}

	@RequestMapping(value = "blockfriend", method = RequestMethod.POST)
	public ResponseEntity<RelationshipModel> blockFriend(RelationshipModel relationship) {
		try {

			return new ResponseEntity<>(relationshipService.blockFriend(relationship), HttpStatus.OK);
		} catch (Exception e) {

			// For unknown scenarios
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}

	@RequestMapping(value = "unblockfriend", method = RequestMethod.POST)
	public ResponseEntity<RelationshipModel> unblockFriend(RelationshipModel relationship) {
		try {

			return new ResponseEntity<>(relationshipService.unblockFriend(relationship), HttpStatus.OK);
		} catch (Exception e) {

			// For unknown scenarios
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}

	@RequestMapping(value = "getfriends", method = RequestMethod.POST)
	public ResponseEntity<List<UserModel>> getFriends(String emailOrPhone) {
		try {

			return new ResponseEntity<>(relationshipService.getFriends(emailOrPhone), HttpStatus.OK);
		} catch (Exception e) {

			// For unknown scenarios
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

}
