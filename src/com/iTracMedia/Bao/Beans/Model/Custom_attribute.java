package com.iTracMedia.Bao.Beans.Model;

public class Custom_attribute
{
    private int id;
    private int companyid;
    private String name;
    private String description;
    private int custom_typeid;
    private String input_type;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getCompanyid()
    {
        return companyid;
    }

    public void setCompanyid(int companyid)
    {
        this.companyid = companyid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getCustom_typeid()
    {
        return custom_typeid;
    }

    public void setCustom_typeid(int custom_typeid)
    {
        this.custom_typeid = custom_typeid;
    }

    public String getInput_type()
    {
        return input_type;
    }

    public void setInput_type(String input_type)
    {
        this.input_type = input_type;
    }
}
