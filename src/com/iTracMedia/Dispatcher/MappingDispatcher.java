package com.iTracMedia.Dispatcher;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.iTracMedia.Bao.Beans.RequestBeans.Mapping;
import com.iTracMedia.Bao.Beans.ResponseBeans.MetadataReponse;
import com.iTracMedia.Bao.BusinessObjects.IMappingBao;
import com.iTracMedia.Bao.BusinessObjects.iTracMedia.MappingBao;
import com.iTracMedia.Bao.BusinessObjects.utils.DateFormatiTracMedia;

@Path ("/map")
public class MappingDispatcher
{
    @POST
    @Path ("/columns")
    @Produces (MediaType.APPLICATION_JSON)
    @Consumes (MediaType.APPLICATION_JSON)
    public MetadataReponse saveColumnMappings(Mapping mappingData)
    {
        MetadataReponse objMetadataResponse = new MetadataReponse();
        IMappingBao objIMappingBao = new MappingBao();
        objMetadataResponse.setServerDate(DateFormatiTracMedia.DateToString(new Date()));
        try
        {
            objMetadataResponse.setCode(0);
            objMetadataResponse.setMessage(objIMappingBao.mapColumnsBao(mappingData));
        }
        catch (Exception e)
        {
            objMetadataResponse.setCode(1);
            objMetadataResponse.setMessage(e.getMessage());
        }
        return objMetadataResponse;
    }
    
    @POST
    @Path ("/objects")
    @Produces (MediaType.APPLICATION_JSON)
    @Consumes (MediaType.APPLICATION_JSON)
    public MetadataReponse saveObjectMappings(List<Mapping> mappingData)
    {
        MetadataReponse objMetadataResponse = new MetadataReponse();
        IMappingBao objIMappingBao = new MappingBao();
        objMetadataResponse.setServerDate(DateFormatiTracMedia.DateToString(new Date()));
        try
        {
            objMetadataResponse.setCode(0);
            objMetadataResponse.setMessage(objIMappingBao.mapObjectsBao(mappingData));
        }
        catch (Exception e)
        {
            objMetadataResponse.setCode(1);
            objMetadataResponse.setMessage(e.getMessage());
        }
        return objMetadataResponse;
    }

}