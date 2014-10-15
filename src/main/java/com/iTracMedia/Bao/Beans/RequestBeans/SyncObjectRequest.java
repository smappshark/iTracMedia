package com.iTracMedia.Bao.Beans.RequestBeans;

public class SyncObjectRequest
{
    private String timestamp;
    private String sfObject;
    private String orgId;
    private String userName;

    public String getOrgId()
    {
        return orgId;
    }

    public void setOrgId(String orgId)
    {
        this.orgId = orgId;
    }

    public String getSfObject()
    {
        return sfObject;
    }

    public void setSfObject(String sfObject)
    {
        this.sfObject = sfObject;
    }

    public String getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(String timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

}
