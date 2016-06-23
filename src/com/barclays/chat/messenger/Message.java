package com.barclays.chat.messenger;

public class Message {
	
	private String seq;

    private Attachments[] attachments;

    private String mid;

    public String getSeq ()
    {
        return seq;
    }

    public void setSeq (String seq)
    {
        this.seq = seq;
    }

    public Attachments[] getAttachments ()
    {
        return attachments;
    }

    public void setAttachments (Attachments[] attachments)
    {
        this.attachments = attachments;
    }

    public String getMid ()
    {
        return mid;
    }

    public void setMid (String mid)
    {
        this.mid = mid;
    }

}
