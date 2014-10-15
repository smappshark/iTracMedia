package com.iTracMedia.Dao.utils;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.iTracMedia.Bao.BusinessObjects.utils.ReadProperties;
import com.sforce.soap.partner.Connector;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class SFConnectionUtil
{
    private static ResourceBundle resource = ReadProperties.getBundle("config");
    private static PartnerConnection connection = null;
    static Logger log = Logger.getLogger(SFConnectionUtil.class.getName());

    public static PartnerConnection getSFDCConnection() throws Exception
    {
        String authEndpoint = resource.getString("AuthEndpoint");
        String sfToken = resource.getString("SFTOKEN");
        String sfUserName = resource.getString("SFUSERNAME");
        String sfPassword = resource.getString("SFPASSWORD");

        ConnectorConfig config = new ConnectorConfig();
        config.setAuthEndpoint(authEndpoint);
        config.setUsername(sfUserName);
        config.setPassword(sfPassword + sfToken);
        try
        {
            if (connection == null)
            {
                connection = Connector.newConnection(config);
            }
        }
        catch (ConnectionException e)
        {
            throw e;
        }
        return connection;
    }
}