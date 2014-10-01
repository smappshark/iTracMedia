package com.iTracMedia.Bao.Beans.Model;

import java.sql.Timestamp;

public class ColumnMappings
{
    private int columnmappingsid;
    private String sObject;
    private String tableName;
    private String sfField;
    private String selectedField;
    private Timestamp createdOn;

    public int getColumnmappingsid()
    {
        return columnmappingsid;
    }

    public void setColumnmappingsid(int columnmappingsid)
    {
        this.columnmappingsid = columnmappingsid;
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

    public String getSfField()
    {
        return sfField;
    }

    public void setSfField(String sfField)
    {
        this.sfField = sfField;
    }

    public String getSelectedField()
    {
        return selectedField;
    }

    public void setSelectedField(String selectedField)
    {
        this.selectedField = selectedField;
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
