package com.iTracMedia.Dao;

import java.util.List;

import com.iTracMedia.Bao.Beans.ListOfTables;
import com.iTracMedia.Bao.Beans.TableMetadata;

public interface IMetadataDao
{
    public List<TableMetadata> getTableMetadata(String tableName) throws Exception;

    public List<ListOfTables> listAllTables() throws Exception;
}
