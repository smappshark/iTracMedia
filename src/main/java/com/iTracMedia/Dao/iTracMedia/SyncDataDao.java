package com.iTracMedia.Dao.iTracMedia;

import java.sql.Connection;
import java.util.ResourceBundle;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.lang3.StringUtils;

import com.iTracMedia.Bao.BusinessObjects.utils.ReadProperties;
import com.iTracMedia.Dao.ISyncDataDao;
import com.iTracMedia.Dao.utils.DBConnectionUtil;
import com.iTracMedia.Dao.utils.Queries;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.sobject.SObject;

public class SyncDataDao implements ISyncDataDao
{
    static ResourceBundle resource = ReadProperties.getBundle("config");

    public String syncData(QueryResult queryResults) throws Exception
    {
        DBConnectionUtil objDBConnectionUtil = new DBConnectionUtil();
        Connection conn = null;
        int resultsCount = queryResults.getSize();
        if (resultsCount > 0)
        {
            Object[][] objBatch = new Object[resultsCount][11];
            int counter = 0;
            for (SObject contact: queryResults.getRecords())
            {
                objBatch[counter][0] = (String) contact.getField("Name");
                objBatch[counter][1] = (String) contact.getField("Name");
                objBatch[counter][2] = (String) contact.getField("Name");
                objBatch[counter][3] = (String) contact.getField("Title");
                objBatch[counter][4] = (String) contact.getField("Email");
                objBatch[counter][5] = (String) contact.getField("Phone");
                objBatch[counter][6] = (String) contact.getField("Fax");
                objBatch[counter][7] = (String) contact.getField("MobilePhone");
                objBatch[counter][8] = (String) contact.getField("HomePhone");
                objBatch[counter][9] = (String) contact.getField("OtherPhone");
                objBatch[counter][10] = (String) contact.getField("LeadSource");
                counter++;
            }
            QueryRunner query = new QueryRunner();
            String strQuery = StringUtils.replace(Queries.ContactsSyncQuery, "{iTracMediaDatabaseName}", resource.getString("DBNAME"));
            try
            {
                conn = objDBConnectionUtil.getJNDIConnection(resource.getString("JDBCRourceName"));
                query.batch(conn, strQuery, objBatch);
            }
            catch (Exception e)
            {
                throw e;
            }
            finally
            {
                DbUtils.closeQuietly(conn);
            }
        }
        return "Successfully Done";
    }
}