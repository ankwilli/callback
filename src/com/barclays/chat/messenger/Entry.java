package com.barclays.chat.messenger;

public class Entry {

	private String id;

    private String time;

    private Messaging[] messaging;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTime ()
    {
        return time;
    }

    public void setTime (String time)
    {
        this.time = time;
    }

    public Messaging[] getMessaging ()
    {
        return messaging;
    }

    public void setMessaging (Messaging[] messaging)
    {
        this.messaging = messaging;
    }
}
