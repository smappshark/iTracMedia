package com.iTracMedia.Dao;

import java.util.List;

import com.iTracMedia.Bao.Beans.RequestBeans.Mapping;

public interface IMappingDao
{
    public String mapColumnsDao(Mapping mappingData) throws Exception;

    public String mapObjectsDao(List<Mapping> mappingData) throws Exception;
}