package com.iTracMedia.Bao.BusinessObjects;

import com.iTracMedia.Bao.Beans.RequestBeans.SyncObjectRequest;

public interface ISyncDataBao
{
    public abstract String syncData(SyncObjectRequest sfRequest) throws Exception;
}
