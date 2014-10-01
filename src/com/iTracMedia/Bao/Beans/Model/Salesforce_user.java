package com.iTracMedia.Bao.Beans.Model;

public class Salesforce_user
{
    private int id;
    private int subuserid;
    private String salesforce_orgid;
    private String salesforce_userid;
    private String salesforce_refresh_token;
    private String sandbox;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getSubuserid()
    {
        return subuserid;
    }

    public void setSubuserid(int subuserid)
    {
        this.subuserid = subuserid;
    }

    public String getSalesforce_orgid()
    {
        return salesforce_orgid;
    }

    public void setSalesforce_orgid(String salesforce_orgid)
    {
        this.salesforce_orgid = salesforce_orgid;
    }

    public String getSalesforce_userid()
    {
        return salesforce_userid;
    }

    public void setSalesforce_userid(String salesforce_userid)
    {
        this.salesforce_userid = salesforce_userid;
    }

    public String getSalesforce_refresh_token()
    {
        return salesforce_refresh_token;
    }

    public void setSalesforce_refresh_token(String salesforce_refresh_token)
    {
        this.salesforce_refresh_token = salesforce_refresh_token;
    }

    public String getSandbox()
    {
        return sandbox;
    }

    public void setSandbox(String sandbox)
    {
        this.sandbox = sandbox;
    }
}
