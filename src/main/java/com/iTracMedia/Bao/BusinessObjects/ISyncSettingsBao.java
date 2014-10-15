package com.iTracMedia.Bao.BusinessObjects;

import com.iTracMedia.Bao.Beans.RequestBeans.SyncSettingsRequest;

public interface ISyncSettingsBao
{
    public String SaveSyncSettings(SyncSettingsRequest syncSettings) throws Exception;
}
