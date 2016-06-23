package com.barclays.chat.messenger;

public class WebhookPojo {
	
	 private Entry[] entry;

	    private String object;

	    public Entry[] getEntry ()
	    {
	        return entry;
	    }

	    public void setEntry (Entry[] entry)
	    {
	        this.entry = entry;
	    }

	    public String getObject ()
	    {
	        return object;
	    }

	    public void setObject (String object)
	    {
	        this.object = object;
	    }
}
