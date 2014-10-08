package com.iTracMedia.Dispatcher;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iTracMedia.Bao.Beans.RequestBeans.Mapping;
import com.iTracMedia.Bao.Beans.ResponseBeans.CommonReponse;
import com.iTracMedia.Bao.BusinessObjects.iTracMedia.MappingBao;
import com.iTracMedia.Bao.BusinessObjects.utils.DateFormatiTracMedia;

@RestController
@RequestMapping ("/map")
public class MappingDispatcher
{
    @Autowired
    MappingBao objMappingBao;

    @RequestMapping (value = "/columns", method = RequestMethod.POST)
    @ResponseBody
    public CommonReponse saveColumnMappings(@RequestBody Mapping mappingData)
    {
        CommonReponse objCommonReponse = new CommonReponse();
        objCommonReponse.setServerDate(DateFormatiTracMedia.DateToString(new Date()));
        try
        {
            objCommonReponse.setMessage(objMappingBao.mapColumnsBao(mappingData));
            objCommonReponse.setCode(0);
        }
        catch (Exception e)
        {
            objCommonReponse.setCode(1);
            objCommonReponse.setMessage(e.getMessage());
        }
        return objCommonReponse;
    }
    
    @RequestMapping (value = "/objects", method = RequestMethod.POST)
    @ResponseBody
    public CommonReponse saveObjectMappings(@RequestBody ArrayList<Mapping> mappingData)
    {
        CommonReponse objCommonReponse = new CommonReponse();
        objCommonReponse.setServerDate(DateFormatiTracMedia.DateToString(new Date()));
        try
        {
            objCommonReponse.setCode(0);
            objCommonReponse.setMessage(objMappingBao.mapObjectsBao(mappingData));
        }
        catch (Exception e)
        {
            objCommonReponse.setCode(1);
            objCommonReponse.setMessage(e.getMessage());
        }
        return objCommonReponse;
    }
}
