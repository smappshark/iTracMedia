package com.iTracMedia.Bao.Beans.Model;

public class Custom_type
{
    private int id;
    private String name;
    private String description;
    private String validate_regex;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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

    public String getValidate_regex()
    {
        return validate_regex;
    }

    public void setValidate_regex(String validate_regex)
    {
        this.validate_regex = validate_regex;
    }
}
