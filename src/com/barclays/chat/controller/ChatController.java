package com.barclays.chat.controller;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.barclays.chat.messenger.WebhookPojo;
import com.barclays.chat.requestModel.FBMessage;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;



@Controller
public class ChatController {

	@RequestMapping(value = "/chatPage.html", method = RequestMethod.GET)
	public String chatPage(@ModelAttribute FBMessage fbMessage,Model model) {
	    model.addAttribute("fbMessage", new FBMessage());
	    return "chatPage";
	}
	
	
	@RequestMapping(value = "/textReply.html", method = RequestMethod.POST)
	/*public @ResponseBody WebhookPojo textReply(@ModelAttribute WebhookPojo webhookPojo,Model model) {*/
	public @ResponseBody String textReply(@RequestParam(value = "message",defaultValue = "" ,required = false) JSONObject message, Model model) {
		JSONParser parser = new JSONParser();
		try {
			/*Object obj = parser.parse(new FileReader("/Users/appshah/Documents/crunchify.txt"));*/
			JSONObject genreJsonObject = message;
			JSONObject updated = (JSONObject) genreJsonObject.get("updated");
			String time = (String) updated.get("time");
			System.out.println(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		return "success"; 
	}
}
