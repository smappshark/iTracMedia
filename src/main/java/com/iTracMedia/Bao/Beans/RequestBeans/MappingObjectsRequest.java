package com.iTracMedia.Bao.Beans.RequestBeans;

import java.util.List;

public class MappingObjectsRequest extends OrgDetails
{
    private List<MappingColumnsRequest> fields;

    public List<MappingColumnsRequest> getFields()
    {
        return fields;
    }

    public void setFields(List<MappingColumnsRequest> fields)
    {
        this.fields = fields;
    }

}
