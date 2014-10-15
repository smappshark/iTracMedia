package com.iTracMedia.Dao.iTracMedia;

import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.iTracMedia.Bao.Beans.Model.ColumnMappings;
import com.iTracMedia.Bao.Beans.RequestBeans.SyncObjectRequest;
import com.iTracMedia.Bao.BusinessObjects.utils.ReadProperties;
import com.iTracMedia.Dao.ISyncDataDao;
import com.iTracMedia.Dao.utils.DBConnectionUtil;
import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.sobject.SObject;

public class SyncDataDao implements ISyncDataDao
{
    static ResourceBundle resource = ReadProperties.getBundle("config");
    static Logger log = Logger.getLogger(SyncDataDao.class.getClass());

    public String syncData(List<ColumnMappings> listCM, QueryResult queryResults, SyncObjectRequest sfRequest) throws Exception
    {
        DBConnectionUtil objDBConnectionUtil = new DBConnectionUtil();
        Connection conn = null;
        int resultsCount = queryResults.getSize();
        String sqlQuery = StringUtils.EMPTY;
        String fileds = StringUtils.EMPTY;
        if (resultsCount > 0)
        {
            Object[][] objBatch = new Object[resultsCount][listCM.size() + 3];
            int counter = 0;
            for (SObject contact: queryResults.getRecords())
            {
                int cntr = 0;
                for (ColumnMappings cm: listCM)
                {
                    objBatch[counter][cntr] = (String) contact.getField(cm.getSfField());
                    cntr++;
                }
                objBatch[counter][cntr] = sfRequest.getOrgId();
                cntr++;
                objBatch[counter][cntr] = sfRequest.getUserName();
                cntr++;
                objBatch[counter][cntr] = sfRequest.getTimestamp();
                counter++;
            }
            sqlQuery = "INSERT INTO " + resource.getString("DBNAME") + "." + listCM.get(0).getTableName() + "(";
            for (ColumnMappings cm: listCM)
            {
                sqlQuery += cm.getSelectedField() + ",";
                fileds += "?,";
            }
            sqlQuery += "OrgId, SFUser, SFTimestamp";
            fileds += "?,?,?";
            sqlQuery += ") values (" + fileds + ")";
            QueryRunner query = new QueryRunner();
            try
            {
                conn = objDBConnectionUtil.getJNDIConnection(resource.getString("JDBCRourceName"));
                query.batch(conn, sqlQuery, objBatch);
            }
            catch (Exception e)
            {
                throw e;
            }
            finally
            {
                DbUtils.closeQuietly(conn);
            }
            return "Successfully Done";
        }
        else
        {
            return "No Records to Update";
        }

    }
}