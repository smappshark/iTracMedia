package com.iTracMedia.Dao;

import com.sforce.soap.partner.QueryResult;

public interface ISyncDataDao
{
    public String syncData(QueryResult queryResults) throws Exception;
}