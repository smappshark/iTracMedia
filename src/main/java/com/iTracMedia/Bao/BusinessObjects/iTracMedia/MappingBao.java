package com.iTracMedia.Bao.BusinessObjects.iTracMedia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iTracMedia.Bao.Beans.RequestBeans.Mapping;
import com.iTracMedia.Bao.BusinessObjects.IMappingBao;
import com.iTracMedia.Dao.iTracMedia.MappingDao;

public class MappingBao implements IMappingBao
{
    @Autowired
    MappingDao objMappingDao;

    public String mapColumnsBao(Mapping mappingData) throws Exception
    {
        return objMappingDao.mapColumnsDao(mappingData);
    }

    public String mapObjectsBao(List<Mapping> mappingData) throws Exception
    {
        return objMappingDao.mapObjectsDao(mappingData);

    }
}