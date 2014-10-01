package com.iTracMedia.Bao.Beans.Model;

import java.sql.Timestamp;

public class ObjectMappings
{
    private int objectmappingsid;
    private String sObject;
    private String tableName;
    private Timestamp createdOn;

    public int getObjectmappingsid()
    {
        return objectmappingsid;
    }

    public void setObjectmappingsid(int objectmappingsid)
    {
        this.objectmappingsid = objectmappingsid;
    }

    public String getsObject()
    {
        return sObject;
    }

    public void setsObject(String sObject)
    {
        this.sObject = sObject;
    }

    public String getTableName()
    {
        return tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public Timestamp getCreatedOn()
    {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn)
    {
        this.createdOn = createdOn;
    }

}
