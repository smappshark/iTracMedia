package com.iTracMedia.Bao.BusinessObjects;

import com.iTracMedia.Bao.Beans.RequestBeans.MappingColumnsRequest;
import com.iTracMedia.Bao.Beans.RequestBeans.MappingObjectsRequest;

public interface IMappingBao
{
    public String mapColumnsBao(MappingColumnsRequest mappingData) throws Exception;

    public abstract String mapObjectsBao(MappingObjectsRequest mappingData) throws Exception;
}
