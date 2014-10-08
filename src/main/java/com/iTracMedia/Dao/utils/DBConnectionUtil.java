package com.iTracMedia.Dao.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnectionUtil
{
    private static Connection connection = null;
    private static DataSource ds = null;
    private static Context ctx = null;

    public Connection getJNDIConnection(String jdbcRourceName) throws NamingException, SQLException
    {
        ctx = new InitialContext();
        ds = (DataSource) ctx.lookup(jdbcRourceName);
        connection = ds.getConnection();
        return connection;
    }

}