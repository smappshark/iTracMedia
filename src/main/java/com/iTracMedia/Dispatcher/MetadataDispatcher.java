package com.iTracMedia.Dispatcher;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iTracMedia.Bao.Beans.ResponseBeans.MetadataReponse;
import com.iTracMedia.Bao.BusinessObjects.iTracMedia.MetadataBao;
import com.iTracMedia.Bao.BusinessObjects.utils.DateFormatiTracMedia;

@RestController
@RequestMapping ("/metadata")
public class MetadataDispatcher
{
    @Autowired
    MetadataBao objMetadataBao;

    @RequestMapping (value = "/listalltables", method = RequestMethod.GET)
    @ResponseBody
    public MetadataReponse listAllTables()
    {
        MetadataReponse objMetadataResponse = new MetadataReponse();
        objMetadataResponse.setServerDate(DateFormatiTracMedia.DateToString(new Date()));
        try
        {
            objMetadataResponse.setTables(objMetadataBao.listAllTables());
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

    @RequestMapping (value = "/{tableName}", method = RequestMethod.GET)
    @ResponseBody
    public MetadataReponse getTablesMetadata(@PathVariable("tableName") String tableName)
    {
        MetadataReponse objMetadataResponse = new MetadataReponse();
        objMetadataResponse.setServerDate(DateFormatiTracMedia.DateToString(new Date()));
        if (StringUtils.isNotEmpty(tableName))
        {
            try
            {
                objMetadataResponse.setMetadata(objMetadataBao.getTableMetadata(tableName));
                objMetadataResponse.setCode(0);
                objMetadataResponse.setMessage("SUCCESS");
            }
            catch (Exception e)
            {
                objMetadataResponse.setCode(1);
                objMetadataResponse.setMessage(e.toString());
            }
        } else {
            objMetadataResponse.setCode(1);
            objMetadataResponse.setMessage("IN_VALID_INPUT");
        }
        return objMetadataResponse;
    }
}
