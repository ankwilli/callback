package com.barclays.chat.requestModel;

import java.io.Serializable;

public class FBMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3806694572302745172L;
	private String textMessage;
	private String userId;
	public String getTextMessage() {
		return textMessage;
	}
	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((textMessage == null) ? 0 : textMessage.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FBMessage other = (FBMessage) obj;
		if (textMessage == null) {
			if (other.textMessage != null)
				return false;
		} else if (!textMessage.equals(other.textMessage))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
}
