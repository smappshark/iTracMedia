package com.iTracMedia.Dao.iTracMedia;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.iTracMedia.Bao.Beans.ListOfTables;
import com.iTracMedia.Bao.Beans.TableMetadata;
import com.iTracMedia.Bao.BusinessObjects.utils.ReadProperties;
import com.iTracMedia.Dao.IMetadataDao;
import com.iTracMedia.Dao.utils.DBConnectionUtil;
import com.iTracMedia.Dao.utils.Queries;

public class MetadataDao implements IMetadataDao
{
    static Logger log = Logger.getLogger(MetadataDao.class.getName());
    static ResourceBundle resource = ReadProperties.getBundle("config");

    public List<TableMetadata> getTableMetadata(String tableName) throws Exception
    {
        DBConnectionUtil objDBConnectionUtil = new DBConnectionUtil();
        String strQuery = StringUtils.replace(Queries.TableMetadataQuery, "{iTracMediaTableName}", tableName);
        strQuery = StringUtils.replace(strQuery, "{iTracMediaDatabaseName}", resource.getString("DBNAME"));
        log.debug(strQuery);
        List<TableMetadata> listTableMetadata = null;
        Connection conn = null;
        try
        {
            conn = objDBConnectionUtil.getJNDIConnection(resource.getString("JDBCRourceName"));
            try
            {
                QueryRunner query = new QueryRunner();
                listTableMetadata = query.query(conn, strQuery, new BeanListHandler<TableMetadata>(TableMetadata.class));
            }
            catch (SQLException se)
            {
                throw se;
            }
            finally
            {
                DbUtils.closeQuietly(conn);
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        return listTableMetadata;
    }

    public List<ListOfTables> listAllTables() throws Exception
    {
        DBConnectionUtil objDBConnectionUtil = new DBConnectionUtil();
        String strQuery = StringUtils.replace(Queries.ListofTables, "{iTracMediaDatabaseName}", resource.getString("DBNAME"));
        List<ListOfTables> listOfTables = null;
        Connection conn = null;
        try
        {
            conn = objDBConnectionUtil.getJNDIConnection(resource.getString("JDBCRourceName"));
            try
            {
                QueryRunner query = new QueryRunner();
                listOfTables = query.query(conn, strQuery, new BeanListHandler<ListOfTables>(ListOfTables.class));
            }
            catch (SQLException se)
            {
                throw se;
            }
            finally
            {
                DbUtils.closeQuietly(conn);
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        return listOfTables;
    }

}
