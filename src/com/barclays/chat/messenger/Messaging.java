package com.barclays.chat.messenger;

public class Messaging {

	 private Message message;

	    private String timestamp;

	    private Sender sender;

	    private Recipient recipient;

	    public Message getMessage ()
	    {
	        return message;
	    }

	    public void setMessage (Message message)
	    {
	        this.message = message;
	    }

	    public String getTimestamp ()
	    {
	        return timestamp;
	    }

	    public void setTimestamp (String timestamp)
	    {
	        this.timestamp = timestamp;
	    }

	    public Sender getSender ()
	    {
	        return sender;
	    }

	    public void setSender (Sender sender)
	    {
	        this.sender = sender;
	    }

	    public Recipient getRecipient ()
	    {
	        return recipient;
	    }

	    public void setRecipient (Recipient recipient)
	    {
	        this.recipient = recipient;
	    }

}
