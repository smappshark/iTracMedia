package com.iTracMedia.Bao.Beans.RequestBeans;

public class SalesForceRequest
{
    private String syncTime;
    private String tableName;
    private String orgId;
    private String user;

    public String getTableName()
    {
        return tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getOrgId()
    {
        return orgId;
    }

    public void setOrgId(String orgId)
    {
        this.orgId = orgId;
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getSyncTime()
    {
        return syncTime;
    }

    public void setSyncTime(String syncTime)
    {
        this.syncTime = syncTime;
    }

   
}
