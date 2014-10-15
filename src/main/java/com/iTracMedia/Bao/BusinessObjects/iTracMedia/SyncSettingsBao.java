package com.iTracMedia.Bao.BusinessObjects.iTracMedia;

import org.springframework.beans.factory.annotation.Autowired;

import com.iTracMedia.Bao.Beans.RequestBeans.SyncSettingsRequest;
import com.iTracMedia.Bao.BusinessObjects.ISyncSettingsBao;
import com.iTracMedia.Dao.iTracMedia.SyncSettingsDao;

public class SyncSettingsBao implements ISyncSettingsBao
{
    @Autowired
    SyncSettingsDao objSyncSettingsDao;

    public String SaveSyncSettings(SyncSettingsRequest syncSettings) throws Exception
    {
        return objSyncSettingsDao.SaveSyncSettings(syncSettings);
    }

}