package com.iTracMedia.Dao.iTracMedia;

import java.sql.Connection;
import java.util.ResourceBundle;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.lang3.StringUtils;

import com.iTracMedia.Bao.Beans.RequestBeans.SyncSettingsRequest;
import com.iTracMedia.Bao.BusinessObjects.utils.ReadProperties;
import com.iTracMedia.Dao.ISyncSettingsDao;
import com.iTracMedia.Dao.utils.DBConnectionUtil;
import com.iTracMedia.Dao.utils.Queries;

public class SyncSettingsDao implements ISyncSettingsDao
{

    static ResourceBundle resource = ReadProperties.getBundle("config");

    public String SaveSyncSettings(SyncSettingsRequest syncSettings) throws Exception
    {
        Connection conn = null;
        DBConnectionUtil objDBConnectionUtil = new DBConnectionUtil();
        String strQuery = StringUtils.replace(Queries.inertIntoSyncSchedule, "{iTracMediaDatabaseName}", resource.getString("DBNAME"));
        try
        {
            conn = objDBConnectionUtil.getJNDIConnection(resource.getString("JDBCRourceName"));
            QueryRunner query = new QueryRunner();
            int inserts = query.update(conn, strQuery, syncSettings.getOrgId(), syncSettings.getSfObject(), syncSettings.getSqlTableName(), syncSettings.getStartDate(), syncSettings.getEndDate(), Boolean.parseBoolean(syncSettings.getIsActive()), syncSettings.getOccursAtEvery(), syncSettings.getPreferedStartTime(), syncSettings.getPreferedEndTime(), syncSettings.getOccuranceType(), syncSettings.getOccuranceValue(), Boolean.parseBoolean(syncSettings.getIsMonday()), Boolean.parseBoolean(syncSettings.getIsTuesday()), Boolean.parseBoolean(syncSettings.getIsWednesday()), Boolean.parseBoolean(syncSettings.getIsThursday()), Boolean.parseBoolean(syncSettings.getIsFriday()), Boolean.parseBoolean(syncSettings.getIsSaturday()), Boolean.parseBoolean(syncSettings.getIsSunday()), syncSettings.getCreatedDate(), syncSettings.getUserName(), syncSettings.getTimestamp());
            if (inserts == 1) {
                return "Successfully Done";
            }
            return "Failed";
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
}