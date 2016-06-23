package com.barclays.chat.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.barclays.chat.requestModel.NomiCustomerInfo;
import com.barclays.chat.responseModel.ChatMessage;
import com.barclays.chat.responseModel.NomiChatGatewayResponse;
import com.barclays.chat.util.CommonUtil;
@Component
public class IntegrateChatGatewayService {
	String jsessionId="";
	String jsessionIdNC013="";
	NomiChatGatewayResponse responseNC6=null;
	
public NomiChatGatewayResponse callCheckServiceAvailability(HttpServletRequest httpServletRequest){
 	String serverURL="http://localhost:8080/gatewaynomi";   //local URI-http://localhost:8080/gatewaynomi  SIT uri -https://643t.wload.barclays.co.uk:61700/gatewaynomi;
	String requestURL="/service/w";
	String restURL=serverURL+requestURL;
	NomiChatGatewayResponse response=new NomiChatGatewayResponse();
	RestTemplate restTemplate = new RestTemplate();
    String opCode="NC003";
    String csrfToken=null;	
       if(opCode.equalsIgnoreCase("NC003")){
    	   HttpHeaders requestHeaders = new HttpHeaders();
    	   response=callNC003Service(restURL, restTemplate,requestHeaders,httpServletRequest);
	       if(response.getOp_status().equalsIgnoreCase("00000")){
	    	   response=callNC018Service(restURL, restTemplate, requestHeaders,httpServletRequest);
	       }
	       if(response.getOp_status().equalsIgnoreCase("00000")  && response.getAgentAvailable().equalsIgnoreCase("true")){
	    	   response=callNC013Service(restURL, restTemplate, requestHeaders,httpServletRequest);
	    	   csrfToken=response.getCsrfToken();
	       }
	      else if(response.getOp_status().equalsIgnoreCase("NME02")){
	    	   System.out.println("We're sorry, but no agents are currently online to chat. Please try again later.");
	       }
	       else{
	    	   System.out.println("Something went wrong. Please try again later.");
	       }
       }
	return response;
}

public NomiChatGatewayResponse initiateChat(HttpServletRequest httpServletRequest,NomiCustomerInfo nomicustInfo) {
	NomiChatGatewayResponse response;
	String serverURL="http://localhost:8080/gatewaynomi";   //local URI-http://localhost:8080/gatewaynomi  SIT uri -https://643t.wload.barclays.co.uk:61700/gatewaynomi;
	String requestURL="/service/w";
	String restURL=serverURL+requestURL;
	RestTemplate restTemplate = new RestTemplate();
   	HttpHeaders headers = new HttpHeaders();
   	headers.add("Cookie",nomicustInfo.getjSessionId());
   	response=callNC004Service(restURL,restTemplate,headers,nomicustInfo.getCsrfToken(),httpServletRequest,nomicustInfo);
	return response;
}

public NomiChatGatewayResponse checkAgentPickedOrNot(HttpServletRequest httpServletRequest,NomiCustomerInfo nomicustInfo) {
	NomiChatGatewayResponse response;
	String serverURL="http://localhost:8080/gatewaynomi";   //local URI-http://localhost:8080/gatewaynomi  SIT uri -https://643t.wload.barclays.co.uk:61700/gatewaynomi;
	String requestURL="/service/w";
	String restURL=serverURL+requestURL;
	RestTemplate restTemplate = new RestTemplate();
   	HttpHeaders headers = new HttpHeaders();
   	headers.add("Cookie",nomicustInfo.getjSessionId());
	response=callNC005Service(restURL,restTemplate,headers,nomicustInfo.getCsrfToken(),httpServletRequest);
	return response;
}

public NomiChatGatewayResponse callChatOperationNC006(HttpServletRequest httpServletRequest,NomiCustomerInfo nomicustInfo,String requestType) {
	NomiChatGatewayResponse response = null;
   	String serverURL="http://localhost:8080/gatewaynomi";   //local URI-http://localhost:8080/gatewaynomi  SIT uri -https://643t.wload.barclays.co.uk:61700/gatewaynomi;
	String requestURL="/service/w";
	String restURL=serverURL+requestURL;
	RestTemplate restTemplate = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();
   	headers.add("Cookie",nomicustInfo.getjSessionId());
   	response=callNC006Service(restURL,restTemplate,headers,nomicustInfo.getCsrfToken(),httpServletRequest,requestType,nomicustInfo.getQuestion());
   	return response;
}

@SuppressWarnings("unchecked")
private NomiChatGatewayResponse callNC003Service(String restURL, RestTemplate restTemplate,
		HttpHeaders headers,HttpServletRequest httpServletRequest) {
	 MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>(); 
		params.add("opCode", "NC003");
		params.add("product", "Retail");
		params.add("appId", "");
	   NomiChatGatewayResponse response=new NomiChatGatewayResponse();
	   HttpEntity<Object> requestEntity = new HttpEntity(params, headers);
	   ResponseEntity<NomiChatGatewayResponse> responseEntity = restTemplate.exchange(restURL,HttpMethod.POST,requestEntity,NomiChatGatewayResponse.class);
	   response.setOp_status(responseEntity.getBody().getOp_status());
	   return response;
}

private NomiChatGatewayResponse callNC018Service(String restURL, RestTemplate restTemplate,
		HttpHeaders headers, HttpServletRequest httpServletRequest) {
       MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("opCode", "NC018");
		params.add("product", "Retail");
		params.add("appId", "");
	   NomiChatGatewayResponse response=new NomiChatGatewayResponse();
	   HttpEntity requestEntity = new HttpEntity(params, headers);
	   ResponseEntity<NomiChatGatewayResponse> responseEntity = restTemplate.exchange(restURL,HttpMethod.POST,requestEntity,NomiChatGatewayResponse.class);
	   response.setOp_status(responseEntity.getBody().getOp_status());
	   response.setAgentAvailable(responseEntity.getBody().getAgentAvailable());
	   return response;
}

private NomiChatGatewayResponse callNC013Service(String restURL, RestTemplate restTemplate,
		HttpHeaders headers, HttpServletRequest httpServletRequest) {
	 MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
	   params.add("opCode", "NC013");
	   params.add("appId", "");
	   params.add("email", "");
	   params.add("first_name", "");
	   params.add("last_name", "");
	   params.add("salutation", "");
	   params.add("Existing_Wealth_Customer__c", "");
	   NomiChatGatewayResponse response=new NomiChatGatewayResponse();
	   HttpEntity requestEntity = new HttpEntity(params, headers);
	   ResponseEntity<NomiChatGatewayResponse> responseEntity = restTemplate.exchange(restURL,HttpMethod.POST,requestEntity,NomiChatGatewayResponse.class);
	   jsessionId=getJsesionIdFromChatGateway(responseEntity);
	   jsessionIdNC013=jsessionId;
	   response.setOp_status(responseEntity.getBody().getOp_status());
	   response.setCsrfToken(responseEntity.getBody().getCsrfToken());
	   response.setjSessionId(jsessionIdNC013);
	   return response;
}

private NomiChatGatewayResponse callNC004Service(String restURL, RestTemplate restTemplate,
		HttpHeaders headers,String csrfToken, HttpServletRequest httpServletRequest,NomiCustomerInfo nomiCustomerInfo) {
	 MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
	   params.add("opCode","NC004");
	   params.add("name",nomiCustomerInfo.getCustName());
       params.add("question",nomiCustomerInfo.getQuestion());
       params.add("product","Retail");
       params.add("pagename","");
       params.add("appId","");
       params.add("csrfToken",csrfToken);
       params.add("errorCode","");
	   NomiChatGatewayResponse response=new NomiChatGatewayResponse();
	   headers.add("accept","application/json");
	   HttpEntity requestEntity = new HttpEntity(params, headers);
	   ResponseEntity<NomiChatGatewayResponse> responseEntity = restTemplate.exchange(restURL,HttpMethod.POST,requestEntity,NomiChatGatewayResponse.class);
	   response.setOp_status(responseEntity.getBody().getOp_status());
	   return response;
}

private NomiChatGatewayResponse callNC005Service(String restURL, RestTemplate restTemplate,
		HttpHeaders headers,String csrfToken, HttpServletRequest httpServletRequest) {
	   MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
	   params.add("opCode", "NC005");
       params.add("appId", "");
       params.add("csrfToken", csrfToken);
	   NomiChatGatewayResponse response=new NomiChatGatewayResponse();
	   HttpEntity requestEntity = new HttpEntity(params, headers);
	   ResponseEntity<NomiChatGatewayResponse> responseEntity = restTemplate.exchange(restURL,HttpMethod.POST,requestEntity,NomiChatGatewayResponse.class);
	   jsessionId=getJsesionIdFromChatGateway(responseEntity);
	   response.setOp_status(responseEntity.getBody().getOp_status());
	   response.setHasAgentPickedUp(responseEntity.getBody().getHasAgentPickedUp());
	   response.setAgentName(responseEntity.getBody().getAgentName());
	   return response;
}

private NomiChatGatewayResponse callNC006Service(String restURL, RestTemplate restTemplate,
		HttpHeaders headers,String csrfToken,HttpServletRequest httpServletRequest,String requestType,String userMsg) {
	   MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
	   CommonUtil utilObject=new CommonUtil();
	   if("U002".equalsIgnoreCase(requestType)){
		   params.add("requestType", requestType);
	       params.add("opCode", "NC006");
	       params.add("userMsg", "{\"messageList\":[{\"userMsg\":\""+userMsg+"\"}]}\"");
	       params.add("msgId","18:50:17"); //utilObject.getCurrentTime());
	       params.add("appId", "");
	       params.add("csrfToken", csrfToken);
	   }else if("U001".equalsIgnoreCase(requestType)){
		   params.add("requestType", requestType);
	       params.add("opCode", "NC006");
	       params.add("appId", "");
	       params.add("csrfToken", csrfToken);
	  }else if("U003".equalsIgnoreCase(requestType)){
		   params.add("requestType", requestType);
	       params.add("opCode", "NC006");
	       params.add("appId", "");
	       params.add("csrfToken", csrfToken);
	   }
	   NomiChatGatewayResponse response=new NomiChatGatewayResponse();
	   HttpEntity requestEntity = new HttpEntity(params, headers);
	   ResponseEntity<NomiChatGatewayResponse> responseEntity = restTemplate.exchange(restURL,HttpMethod.POST,requestEntity,NomiChatGatewayResponse.class);
	   jsessionId=getJsesionIdFromChatGateway(responseEntity);
	   response.setOp_status(responseEntity.getBody().getOp_status());
	   if(responseEntity.getBody().getOp_status().equalsIgnoreCase("00000")){
	   ArrayList<ChatMessage> chatList=new ArrayList<ChatMessage>();
	   		if(responseEntity.getBody().getChatMessage().size()>0){
					for(int i=0;i<responseEntity.getBody().getChatMessage().size();i++){   
						   String message=responseEntity.getBody().getChatMessage().get(i).getMessage();
						   String displayName=responseEntity.getBody().getChatMessage().get(i).getDisplayName();
						   String timeStamp=responseEntity.getBody().getChatMessage().get(i).getTimeStamp();
						   String action=responseEntity.getBody().getChatMessage().get(i).getAction();
						   String agentOrGuest=responseEntity.getBody().getChatMessage().get(i).getAgentOrGuest();
						   ChatMessage chatMessage=new ChatMessage();
						   chatMessage.setMessage(message);
						   chatMessage.setDisplayName(displayName);
						   chatMessage.setTimeStamp(timeStamp);
						   chatMessage.setAction(action);
						   chatMessage.setAgentOrGuest(agentOrGuest);
						   chatList.add(i,chatMessage);
					}
				response.setChatMessage(chatList);
	   		}
	   }else{
		   System.out.println("Error occured in NC006 call");
	   }
	   System.out.println("response---"+response.getOp_status());
	   return response;
}

private String getJsesionIdFromChatGateway(ResponseEntity responseEntity){
	HttpHeaders httpHeaders=responseEntity.getHeaders();
	Set<String> keys=httpHeaders.keySet();
	String setCookie="";
	String jSessionID="";
	for(String header : keys){
		if(header.equalsIgnoreCase("Set-Cookie"))
		{
			setCookie=httpHeaders.get(header).get(0);
		}
	}
	
	if(setCookie!=null || setCookie!="")
	{
		jSessionID=setCookie.split(";")[0];
		return jSessionID;
	}
	return jSessionID;
	
}

}
