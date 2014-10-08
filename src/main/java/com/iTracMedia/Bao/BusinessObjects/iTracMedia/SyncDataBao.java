package com.iTracMedia.Bao.BusinessObjects.iTracMedia;

import org.springframework.beans.factory.annotation.Autowired;

import com.iTracMedia.Bao.BusinessObjects.ISyncDataBao;
import com.iTracMedia.Dao.iTracMedia.SyncDataDao;
import com.iTracMedia.Dao.utils.Queries;
import com.iTracMedia.Dao.utils.SFConnectionUtil;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.QueryResult;

public class SyncDataBao implements ISyncDataBao
{
    @Autowired
    SyncDataDao objSyncDataDao;
    
    public static PartnerConnection SFDCconnection = null;
    
    public String syncData() throws Exception
    {
        QueryResult queryResults;
        try
        {
            SFDCconnection = SFConnectionUtil.getSFDCConnection();
            queryResults = SFDCconnection.query(Queries.SFDCQueryForContacts);
        }
        catch (Exception e)
        {
           throw e;
        }
        return objSyncDataDao.syncData(queryResults);
    }
}