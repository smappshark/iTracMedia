package com.iTracMedia.Bao.Beans.RequestBeans;

import java.util.List;

public class MappingColumnsRequest extends OrgDetails
{
    private String sObject;
    private String tableName;
    private List<ColumnsMapping> fields;

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

    public List<ColumnsMapping> getFields()
    {
        return fields;
    }

    public void setFields(List<ColumnsMapping> fields)
    {
        this.fields = fields;
    }

}
