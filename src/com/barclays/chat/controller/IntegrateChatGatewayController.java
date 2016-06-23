package com.barclays.chat.controller;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.barclays.chat.requestModel.NomiChatGatewayRequest;
import com.barclays.chat.requestModel.NomiCustomerInfo;
import com.barclays.chat.responseModel.ChatMessage;
import com.barclays.chat.responseModel.NomiChatGatewayResponse;
import com.barclays.chat.service.IntegrateChatGatewayService;
import com.google.gson.Gson;
 
@Controller
public class IntegrateChatGatewayController {

	@RequestMapping(value = "/welcome.html", method = RequestMethod.GET)
	public String welcomePage(Model model) {
	    model.addAttribute("nomiCustomerInfo", new NomiCustomerInfo());
	    return "startConversation";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "initiateChatOperation.html",produces="application/json")
	public @ResponseBody String initiateChatOperation(@RequestParam("custName") String custName, @RequestParam("question") String question,
			HttpServletRequest httpServletRequest,Model model) {
		NomiCustomerInfo nomiCustomerInfo=new NomiCustomerInfo();
		NomiChatGatewayResponse nomiChatGatewayResponse=null;
		IntegrateChatGatewayService chatGatewayService=new IntegrateChatGatewayService();
		nomiChatGatewayResponse=chatGatewayService.callCheckServiceAvailability(httpServletRequest);
		if(nomiChatGatewayResponse.getOp_status().equalsIgnoreCase("00000")){
			nomiCustomerInfo.setjSessionId(nomiChatGatewayResponse.getjSessionId());
			nomiCustomerInfo.setCsrfToken(nomiChatGatewayResponse.getCsrfToken());
			nomiCustomerInfo.setCustName(custName);
			nomiCustomerInfo.setQuestion(question);
			nomiChatGatewayResponse=chatGatewayService.initiateChat(httpServletRequest, nomiCustomerInfo);
			if(nomiChatGatewayResponse.getOp_status().equalsIgnoreCase("00000")){
				nomiChatGatewayResponse.setHasAgentPickedUp("false");
				while(nomiChatGatewayResponse.getHasAgentPickedUp().equalsIgnoreCase("false"))
				{
				nomiChatGatewayResponse=chatGatewayService.checkAgentPickedOrNot(httpServletRequest, nomiCustomerInfo);
				}
				if(nomiChatGatewayResponse.getHasAgentPickedUp().equalsIgnoreCase("true")){
					nomiChatGatewayResponse.setOp_status("00000");
				}
			}else if(nomiChatGatewayResponse.getOp_status().equalsIgnoreCase("NME02")){
				nomiChatGatewayResponse.setOp_status("NME02");
			}else{
				nomiChatGatewayResponse.setOp_status("00003");
			}
			nomiChatGatewayResponse.setCsrfToken(nomiCustomerInfo.getCsrfToken());
			nomiChatGatewayResponse.setjSessionId(nomiCustomerInfo.getjSessionId());
			nomiChatGatewayResponse.setOp_status("00000");
			
		}else if(nomiChatGatewayResponse.getOp_status().equalsIgnoreCase("NME02")){
			nomiChatGatewayResponse.setOp_status("NME02");
		}else{
			nomiChatGatewayResponse.setOp_status("00003");
		}
		Gson gson=new Gson();
		String jsonResponse=gson.toJson(nomiChatGatewayResponse);
		return jsonResponse;
	}

	@RequestMapping(method = RequestMethod.POST, value = "startConversation.html",produces="application/json")
	public @ResponseBody String startConversation(@RequestParam("custName") String custName, @RequestParam("question") String question,
			@RequestParam("jSessionId") String jSessionId,@RequestParam("csrfToken") String csrfToken,@RequestParam("requestType") String requestType,HttpServletRequest httpServletRequest,Model model) {
		NomiCustomerInfo nomiCustomerInfo=new NomiCustomerInfo();
		nomiCustomerInfo.setCsrfToken(csrfToken);
		nomiCustomerInfo.setjSessionId(jSessionId);
		nomiCustomerInfo.setCustName(custName);
		nomiCustomerInfo.setQuestion(question);
		NomiChatGatewayResponse nomiChatGatewayResponse=null;
		ArrayList<ChatMessage> chatList=null;
		IntegrateChatGatewayService chatGatewayService=new IntegrateChatGatewayService();
		nomiChatGatewayResponse=chatGatewayService.callChatOperationNC006(httpServletRequest, nomiCustomerInfo,requestType);
		if(nomiChatGatewayResponse.getOp_status().equalsIgnoreCase("00000")){
				 chatList=(ArrayList<ChatMessage>) nomiChatGatewayResponse.getChatMessage();
				 nomiChatGatewayResponse.setOp_status("00000");
			     /*Map<String, Object> modelChat = new HashMap<String, Object>();
			     modelChat.put("chatList", chatList);*/
		}else if(nomiChatGatewayResponse.getOp_status().equalsIgnoreCase("NME02")){
			nomiChatGatewayResponse.setOp_status("NME02");
		}else{
			nomiChatGatewayResponse.setOp_status("00003");
		}
		
		Gson gson=new Gson();
		String jsonResponse=null;
		jsonResponse=gson.toJson(chatList);
		return jsonResponse;
	}
}