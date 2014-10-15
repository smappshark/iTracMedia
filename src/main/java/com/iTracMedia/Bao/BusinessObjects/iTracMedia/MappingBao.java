package com.iTracMedia.Bao.BusinessObjects.iTracMedia;

import org.springframework.beans.factory.annotation.Autowired;

import com.iTracMedia.Bao.Beans.RequestBeans.MappingColumnsRequest;
import com.iTracMedia.Bao.Beans.RequestBeans.MappingObjectsRequest;
import com.iTracMedia.Bao.BusinessObjects.IMappingBao;
import com.iTracMedia.Dao.iTracMedia.MappingDao;

public class MappingBao implements IMappingBao
{
    @Autowired
    MappingDao objMappingDao;

    public String mapColumnsBao(MappingColumnsRequest mappingData) throws Exception
    {
        return objMappingDao.mapColumnsDao(mappingData);
    }

    public String mapObjectsBao(MappingObjectsRequest mappingData) throws Exception
    {
        return objMappingDao.mapObjectsDao(mappingData);

    }
}