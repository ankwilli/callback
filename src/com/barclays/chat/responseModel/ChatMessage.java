package com.barclays.chat.responseModel;


public class ChatMessage 
{
    private String message;
    private String displayName;
    private String timeStamp;
    private String action;
    private String agentOrGuest;
  
	public ChatMessage() {
		
	}

	public ChatMessage(String message, String displayName, String timeStamp,
			String action, String agentOrGuest) {
		super();
		this.message = message;
		this.displayName = displayName;
		this.timeStamp = timeStamp;
		this.action = action;
		this.agentOrGuest = agentOrGuest;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAgentOrGuest() {
		return agentOrGuest;
	}

	public void setAgentOrGuest(String agentOrGuest) {
		this.agentOrGuest = agentOrGuest;
	}
}
