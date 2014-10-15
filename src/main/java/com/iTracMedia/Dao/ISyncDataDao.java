package com.iTracMedia.Dao;

import java.util.List;

import com.iTracMedia.Bao.Beans.Model.ColumnMappings;
import com.iTracMedia.Bao.Beans.RequestBeans.SyncObjectRequest;
import com.sforce.soap.partner.QueryResult;

public interface ISyncDataDao
{
    public String syncData(List<ColumnMappings> listCM, QueryResult queryResults, SyncObjectRequest sfRequest) throws Exception;
}