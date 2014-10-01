package com.iTracMedia.Bao.BusinessObjects.iTracMedia;

import java.util.List;

import com.iTracMedia.Bao.Beans.ListOfTables;
import com.iTracMedia.Bao.Beans.TableMetadata;
import com.iTracMedia.Bao.BusinessObjects.IMetadataBao;
import com.iTracMedia.Dao.IMetadataDao;
import com.iTracMedia.Dao.iTracMedia.MetadataDao;

public class MetadataBao implements IMetadataBao
{
    @Override
    public List<TableMetadata> getTableMetadata(String tableName) throws Exception
    {
        IMetadataDao objIMetadataDao = new MetadataDao();
        return objIMetadataDao.getTableMetadata(tableName);
    }

    @Override
    public List<ListOfTables> listAllTables() throws Exception
    {
        IMetadataDao objIMetadataDao = new MetadataDao();
        return objIMetadataDao.listAllTables();

    }
}