package com.barclays.chat.responseModel;

import java.util.List;

import org.springframework.http.HttpHeaders;

public class NomiChatGatewayResponse {
	
	private String csrfToken;
	private String errorCode;
	private String op_status;
	private String op_msg;
	private String agentAvailable;
	
	//NC005
	private String min;
	private String agentName;
	private String hasAgentPickedUp;
	private String sec;
	private String waitingNo;
	
	//NC006
	private List<ChatMessage> chatMessage;
	private String acknowledged;
	private String msgId;
	private String jSessionId;
	private String restURL;
	private HttpHeaders headers;
	private List<String> messageList;
	
	
	public String getCsrfToken() {
		return csrfToken;
	}
	public void setCsrfToken(String csrfToken) {
		this.csrfToken = csrfToken;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getOp_status() {
		return op_status;
	}
	public void setOp_status(String op_status) {
		this.op_status = op_status;
	}
	public String getOp_msg() {
		return op_msg;
	}
	public void setOp_msg(String op_msg) {
		this.op_msg = op_msg;
	}
	public String getAgentAvailable() {
		return agentAvailable;
	}
	public void setAgentAvailable(String agentAvailable) {
		this.agentAvailable = agentAvailable;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getHasAgentPickedUp() {
		return hasAgentPickedUp;
	}
	public void setHasAgentPickedUp(String hasAgentPickedUp) {
		this.hasAgentPickedUp = hasAgentPickedUp;
	}
	public String getSec() {
		return sec;
	}
	public void setSec(String sec) {
		this.sec = sec;
	}
	public String getWaitingNo() {
		return waitingNo;
	}
	public void setWaitingNo(String waitingNo) {
		this.waitingNo = waitingNo;
	}
	public List<ChatMessage> getChatMessage() {
		return chatMessage;
	}
	public void setChatMessage(List<ChatMessage> chatMessage) {
		this.chatMessage = chatMessage;
	}
	public String getAcknowledged() {
		return acknowledged;
	}
	public void setAcknowledged(String acknowledged) {
		this.acknowledged = acknowledged;
	}
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	public String getjSessionId() {
		return jSessionId;
	}
	public void setjSessionId(String jSessionId) {
		this.jSessionId = jSessionId;
	}
	public String getRestURL() {
		return restURL;
	}
	public List<String> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}
	public void setRestURL(String restURL) {
		this.restURL = restURL;
	}
	public HttpHeaders getHeaders() {
		return headers;
	}
	public void setHeaders(HttpHeaders headers) {
		this.headers = headers;
	}
}
