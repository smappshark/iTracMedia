package com.iTracMedia.Dispatcher;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iTracMedia.Bao.Beans.RequestBeans.SyncObjectRequest;
import com.iTracMedia.Bao.Beans.ResponseBeans.CommonReponse;
import com.iTracMedia.Bao.BusinessObjects.iTracMedia.SyncDataBao;
import com.iTracMedia.Bao.BusinessObjects.utils.DateFormatiTracMedia;

@RestController
@RequestMapping ("/sync")
public class SyncDataDispatcher
{
    @Autowired
    SyncDataBao objSyncDataBao;

    static Logger log = Logger.getLogger(SyncDataDispatcher.class.getName());

    @RequestMapping (method = RequestMethod.POST)
    @ResponseBody
    public CommonReponse syncData(@RequestBody SyncObjectRequest sfRequest)
    {

        log.debug("\n TIMESTAMP:" + sfRequest.getTimestamp() + "\n ORGID:" + sfRequest.getOrgId() + "\n USER:" + sfRequest.getUserName() + " \n SFOBJECT:" + sfRequest.getSfObject() + "\n");
        CommonReponse objCommonReponse = new CommonReponse();
        objCommonReponse.setServerDate(DateFormatiTracMedia.DateToString(new Date()));
        try
        {
            objCommonReponse.setCode(0);
            objCommonReponse.setMessage(objSyncDataBao.syncData(sfRequest));
        }
        catch (Exception e)
        {
            objCommonReponse.setCode(1);
            objCommonReponse.setMessage(e.getMessage());
        }
        return objCommonReponse;
    }
}
