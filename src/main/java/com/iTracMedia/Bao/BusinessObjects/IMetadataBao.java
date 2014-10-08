package com.iTracMedia.Bao.BusinessObjects;

import java.util.List;

import com.iTracMedia.Bao.Beans.ListOfTables;
import com.iTracMedia.Bao.Beans.TableMetadata;

public interface IMetadataBao
{
    public abstract List<TableMetadata> getTableMetadata(String tableName) throws Exception;

    public abstract List<ListOfTables> listAllTables() throws Exception;
}
