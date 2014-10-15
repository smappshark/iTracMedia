package com.iTracMedia.Dispatcher;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iTracMedia.Bao.Beans.RequestBeans.SyncSettingsRequest;
import com.iTracMedia.Bao.Beans.ResponseBeans.CommonReponse;
import com.iTracMedia.Bao.BusinessObjects.iTracMedia.SyncSettingsBao;
import com.iTracMedia.Bao.BusinessObjects.utils.DateFormatiTracMedia;

@RestController
@RequestMapping ("/sync")
public class SyncSettingsDispatcher
{
    @Autowired
    SyncSettingsBao objSyncSettingsBao;

    @RequestMapping (value = "/settings", method = RequestMethod.POST)
    @ResponseBody
    public CommonReponse saveColumnMappings(@RequestBody SyncSettingsRequest syncSettings)
    {
        CommonReponse objCommonReponse = new CommonReponse();
        objCommonReponse.setServerDate(DateFormatiTracMedia.DateToString(new Date()));
        try
        {
            objCommonReponse.setMessage(objSyncSettingsBao.SaveSyncSettings(syncSettings));
            objCommonReponse.setCode(0);
        }
        catch (Exception e)
        {
            objCommonReponse.setCode(1);
            objCommonReponse.setMessage(e.getMessage());
        }
        return objCommonReponse;
    }

}
