package com.iTracMedia.Bao.Beans.ResponseBeans;

import java.util.List;

import com.iTracMedia.Bao.Beans.ListOfTables;
import com.iTracMedia.Bao.Beans.TableMetadata;

public class MetadataReponse extends CommonReponse
{
    private List<TableMetadata> Metadata;
    private List<ListOfTables> Tables;

    public List<TableMetadata> getMetadata()
    {
        return Metadata;
    }

    public void setMetadata(List<TableMetadata> data)
    {
        Metadata = data;
    }

    public List<ListOfTables> getTables()
    {
        return Tables;
    }

    public void setTables(List<ListOfTables> tables)
    {
        Tables = tables;
    }

}
