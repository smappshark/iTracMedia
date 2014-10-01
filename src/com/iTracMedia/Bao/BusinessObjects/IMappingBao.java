package com.iTracMedia.Bao.BusinessObjects;

import java.util.List;

import com.iTracMedia.Bao.Beans.RequestBeans.Mapping;

public interface IMappingBao
{
    public abstract String mapColumnsBao(Mapping mappingData) throws Exception;

    public abstract String mapObjectsBao(List<Mapping> mappingData) throws Exception;
}