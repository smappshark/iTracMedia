package com.iTracMedia.Bao.BusinessObjects.iTracMedia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iTracMedia.Bao.Beans.ListOfTables;
import com.iTracMedia.Bao.Beans.TableMetadata;
import com.iTracMedia.Bao.BusinessObjects.IMetadataBao;
import com.iTracMedia.Dao.iTracMedia.MetadataDao;

public class MetadataBao implements IMetadataBao
{
    @Autowired
    MetadataDao objMetadataDao;
    public List<TableMetadata> getTableMetadata(String tableName) throws Exception
    {
        return objMetadataDao.getTableMetadata(tableName);
    }

    public List<ListOfTables> listAllTables() throws Exception
    {
        return objMetadataDao.listAllTables();

    }
}
