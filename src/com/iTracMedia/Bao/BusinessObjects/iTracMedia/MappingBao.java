package com.iTracMedia.Bao.BusinessObjects.iTracMedia;

import java.util.List;

import com.iTracMedia.Bao.Beans.RequestBeans.Mapping;
import com.iTracMedia.Bao.BusinessObjects.IMappingBao;
import com.iTracMedia.Dao.IMappingDao;
import com.iTracMedia.Dao.iTracMedia.MappingDao;

public class MappingBao implements IMappingBao
{

    @Override
    public String mapColumnsBao(Mapping mappingData) throws Exception
    {
        IMappingDao objIMappingDao = new MappingDao();
        return objIMappingDao.mapColumnsDao(mappingData);
    }

    @Override
    public String mapObjectsBao(List<Mapping> mappingData) throws Exception
    {
        IMappingDao objIMappingDao = new MappingDao();
        return objIMappingDao.mapObjectsDao(mappingData);

    }
}