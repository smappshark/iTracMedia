package com.iTracMedia.Bao.BusinessObjects.iTracMedia;

import com.iTracMedia.Bao.BusinessObjects.ISyncDataBao;
import com.iTracMedia.Dao.ISyncDataDao;
import com.iTracMedia.Dao.iTracMedia.SyncDataDao;
import com.iTracMedia.Dao.utils.Queries;
import com.iTracMedia.Dao.utils.SFConnectionUtil;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.QueryResult;

public class SyncDataBao implements ISyncDataBao
{
    public static PartnerConnection SFDCconnection = null;
    
    @Override
    public String syncData() throws Exception
    {
        QueryResult queryResults;
        ISyncDataDao objISyncDataDao = new SyncDataDao();
        try
        {
            SFDCconnection = SFConnectionUtil.getSFDCConnection();
            queryResults = SFDCconnection.query(Queries.SFDCQueryForContacts);
        }
        catch (Exception e)
        {
           throw e;
        }
        return objISyncDataDao.syncData(queryResults);
    }
}