package com.iTracMedia.Bao.Beans.Model;

public class Salesforce_contact
{
    private int id;
    private int contactid;
    private int salesforce_userid;
    private String salesforce_contactid;
    private String type;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getContactid()
    {
        return contactid;
    }

    public void setContactid(int contactid)
    {
        this.contactid = contactid;
    }

    public int getSalesforce_userid()
    {
        return salesforce_userid;
    }

    public void setSalesforce_userid(int salesforce_userid)
    {
        this.salesforce_userid = salesforce_userid;
    }

    public String getSalesforce_contactid()
    {
        return salesforce_contactid;
    }

    public void setSalesforce_contactid(String salesforce_contactid)
    {
        this.salesforce_contactid = salesforce_contactid;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
