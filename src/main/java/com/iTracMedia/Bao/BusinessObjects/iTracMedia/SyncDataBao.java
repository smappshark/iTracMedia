package com.iTracMedia.Bao.BusinessObjects.iTracMedia;

import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.iTracMedia.Bao.Beans.Model.ColumnMappings;
import com.iTracMedia.Bao.Beans.RequestBeans.OrgDetails;
import com.iTracMedia.Bao.Beans.RequestBeans.SyncObjectRequest;
import com.iTracMedia.Bao.BusinessObjects.ISyncDataBao;
import com.iTracMedia.Bao.BusinessObjects.utils.ReadProperties;
import com.iTracMedia.Dao.iTracMedia.SyncDataDao;
import com.iTracMedia.Dao.utils.DBConnectionUtil;
import com.iTracMedia.Dao.utils.SFConnectionUtil;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.soap.partner.QueryResult;

public class SyncDataBao implements ISyncDataBao
{
    @Autowired
    SyncDataDao objSyncDataDao;

    public static PartnerConnection SFDCconnection = null;
    static Logger log = Logger.getLogger(SyncDataBao.class.getName());
    static ResourceBundle resource = ReadProperties.getBundle("config");

    public String syncData(SyncObjectRequest sfRequest) throws Exception
    {
        QueryResult queryResults = null;
        List<ColumnMappings> listTableMetadata = null;
        Connection conn = null;
        try
        {
            DBConnectionUtil objDBConnectionUtil = new DBConnectionUtil();
            String strSOQL = "", strQuery = "SELECT DISTINCT(sfField), selectedField, tableName FROM " + resource.getString("DBNAME") + ".columnmappings WHERE sObject = '" + sfRequest.getSfObject() + "' AND OrgId ='" + sfRequest.getOrgId() + "'", strLastSyncTimeQuery = StringUtils.EMPTY;
            conn = objDBConnectionUtil.getJNDIConnection(resource.getString("JDBCRourceName"));
            QueryRunner query = new QueryRunner();
            listTableMetadata = query.query(conn, strQuery, new BeanListHandler<ColumnMappings>(ColumnMappings.class));
            if (listTableMetadata.size() > 0)
            {
                strLastSyncTimeQuery = "SELECT SFTimestamp as timestamp FROM " + resource.getString("DBNAME") + "." + listTableMetadata.get(0).getTableName() + " WHERE OrgId ='" + sfRequest.getOrgId() + "' " + "ORDER BY contactid DESC LIMIT 1";
                OrgDetails result = (OrgDetails) query.query(conn, strLastSyncTimeQuery, new BeanHandler<OrgDetails>(OrgDetails.class));
                strSOQL = "SELECT ";
                for (ColumnMappings columnMappings: listTableMetadata)
                {
                    strSOQL += columnMappings.getSfField() + ",";
                }
                strSOQL = StringUtils.chop(strSOQL);
                strSOQL += " FROM " + sfRequest.getSfObject();
                if (result != null) {
                    strSOQL += " WHERE CreatedDate > " + result.getTimestamp();
                }
                SFDCconnection = SFConnectionUtil.getSFDCConnection();
                queryResults = SFDCconnection.query(strSOQL);
            } else {
                throw new Exception("Filed Mapping Notfound");
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            DbUtils.closeQuietly(conn);
        }
        return objSyncDataDao.syncData(listTableMetadata, queryResults, sfRequest);
    }
}