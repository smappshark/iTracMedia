package com.iTracMedia.Dispatcher;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

import com.iTracMedia.Bao.Beans.ResponseBeans.MetadataReponse;
import com.iTracMedia.Bao.BusinessObjects.IMetadataBao;
import com.iTracMedia.Bao.BusinessObjects.iTracMedia.MetadataBao;
import com.iTracMedia.Bao.BusinessObjects.utils.DateFormatiTracMedia;

@Path ("/metadata")
public class MetadataDispatcher
{
    @GET
    @Path ("/listalltables")
    @Produces (MediaType.APPLICATION_JSON)
    public MetadataReponse listAllTables()
    {
        IMetadataBao objIMetadataBao = new MetadataBao();
        MetadataReponse objMetadataResponse = new MetadataReponse();
        objMetadataResponse.setServerDate(DateFormatiTracMedia.DateToString(new Date()));
        try
        {
            objMetadataResponse.setTables(objIMetadataBao.listAllTables());
            objMetadataResponse.setCode(0);
            objMetadataResponse.setMessage("SUCCESS");
        }
        catch (Exception e)
        {
            objMetadataResponse.setCode(1);
            objMetadataResponse.setMessage(e.toString());
        }
        return objMetadataResponse;
    }

    @GET
    @Path ("/{tableName}")
    @Produces (MediaType.APPLICATION_JSON)
    public MetadataReponse getTablesMetadata(@PathParam ("tableName") String tableName)
    {
        MetadataReponse objMetadataResponse = null;
        if (StringUtils.isNotEmpty(tableName))
        {
            IMetadataBao objIMetadataBao = new MetadataBao();
            objMetadataResponse = new MetadataReponse();
            objMetadataResponse.setServerDate(DateFormatiTracMedia.DateToString(new Date()));
            try
            {
                objMetadataResponse.setMetadata(objIMetadataBao.getTableMetadata(tableName));
                objMetadataResponse.setCode(0);
                objMetadataResponse.setMessage("SUCCESS");
            }
            catch (Exception e)
            {
                objMetadataResponse.setCode(1);
                objMetadataResponse.setMessage(e.toString());
            }
        }
        return objMetadataResponse;
    }
}