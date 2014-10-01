package com.iTracMedia.Dispatcher;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.iTracMedia.Bao.Beans.ResponseBeans.CommonReponse;
import com.iTracMedia.Bao.BusinessObjects.ISyncDataBao;
import com.iTracMedia.Bao.BusinessObjects.iTracMedia.SyncDataBao;
import com.iTracMedia.Bao.BusinessObjects.utils.DateFormatiTracMedia;

@Path ("/sync")
public class SyncData
{
    @GET
    @Produces (MediaType.APPLICATION_JSON)
    public CommonReponse syncData()
    {
        ISyncDataBao objISyncDataBao = new SyncDataBao();
        CommonReponse objCommonReponse = new CommonReponse();
        objCommonReponse.setServerDate(DateFormatiTracMedia.DateToString(new Date()));
        try
        {
            objCommonReponse.setMessage(objISyncDataBao.syncData());
            objCommonReponse.setCode(0);
        }
        catch (Exception e)
        {
            objCommonReponse.setCode(1);
            objCommonReponse.setMessage(e.toString());
        }
        return objCommonReponse;
    }
}
