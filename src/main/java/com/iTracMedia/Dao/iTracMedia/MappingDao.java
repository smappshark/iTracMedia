package com.iTracMedia.Dao.iTracMedia;

import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.lang3.StringUtils;

import com.iTracMedia.Bao.Beans.RequestBeans.ColumnsMapping;
import com.iTracMedia.Bao.Beans.RequestBeans.MappingColumnsRequest;
import com.iTracMedia.Bao.Beans.RequestBeans.MappingObjectsRequest;
import com.iTracMedia.Bao.BusinessObjects.utils.ReadProperties;
import com.iTracMedia.Dao.IMappingDao;
import com.iTracMedia.Dao.utils.DBConnectionUtil;
import com.iTracMedia.Dao.utils.Queries;

public class MappingDao implements IMappingDao
{
	
    static ResourceBundle resource = ReadProperties.getBundle("config");

    public String mapColumnsDao(MappingColumnsRequest mappingData) throws Exception
    {
        Connection conn = null;
        DBConnectionUtil objDBConnectionUtil = new DBConnectionUtil();
        String sObject = mappingData.getsObject(), tableName = mappingData.getTableName(), orgId = mappingData.getOrgId(), timestamp = mappingData.getTimestamp(), username = mappingData.getUserName();
        List<ColumnsMapping> objFields = mappingData.getFields();
        int fieldsCount = objFields.size();
        if (fieldsCount > 0)
        {
            Object[][] objBatch = new Object[fieldsCount][7];
            int counter = 0;
            for (ColumnsMapping field: objFields)
            {
                objBatch[counter][0] = sObject;
                objBatch[counter][1] = tableName;
                objBatch[counter][2] = field.getSfField();
                objBatch[counter][3] = field.getSelectedField();
                objBatch[counter][4] = orgId;
                objBatch[counter][5] = username;
                objBatch[counter][6] = timestamp;
                counter++;
            }
            QueryRunner query = new QueryRunner();
            String strQuery = StringUtils.replace(Queries.inertIntoColumnMappings, "{iTracMediaDatabaseName}", resource.getString("DBNAME"));
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

    public String mapObjectsDao(MappingObjectsRequest mappingData) throws Exception
    {
        Connection conn = null;
        DBConnectionUtil objDBConnectionUtil = new DBConnectionUtil();
        int fieldsCount = mappingData.getFields().size();
        if (fieldsCount > 0)
        {
            List<MappingColumnsRequest> objReq = mappingData.getFields(); 
            Object[][] objBatch = new Object[fieldsCount][5];
            int counter = 0;
            for (MappingColumnsRequest field: objReq)
            {
                objBatch[counter][0] = field.getsObject();
                objBatch[counter][1] = field.getTableName();
                objBatch[counter][2] = mappingData.getOrgId();
                objBatch[counter][3] = mappingData.getUserName();
                objBatch[counter][4] = mappingData.getTimestamp();
                counter++;
            }
            QueryRunner query = new QueryRunner();
            String strQuery = StringUtils.replace(Queries.inertIntoObjectMappings, "{iTracMediaDatabaseName}", resource.getString("DBNAME"));
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