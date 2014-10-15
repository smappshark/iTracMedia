package com.iTracMedia.Dao;

import com.iTracMedia.Bao.Beans.RequestBeans.SyncSettingsRequest;

public interface ISyncSettingsDao
{
    public String SaveSyncSettings(SyncSettingsRequest syncSettings) throws Exception;
}