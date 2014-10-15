package com.iTracMedia.Dao;

import com.iTracMedia.Bao.Beans.RequestBeans.MappingColumnsRequest;
import com.iTracMedia.Bao.Beans.RequestBeans.MappingObjectsRequest;

public interface IMappingDao
{
    public String mapColumnsDao(MappingColumnsRequest mappingData) throws Exception;

    public String mapObjectsDao(MappingObjectsRequest mappingData) throws Exception;
}