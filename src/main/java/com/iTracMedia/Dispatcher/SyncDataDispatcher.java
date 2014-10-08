package com.iTracMedia.Dispatcher;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iTracMedia.Bao.Beans.RequestBeans.SalesForceRequest;

@RestController
@RequestMapping ("/sync")
public class SyncDataDispatcher
{

    @RequestMapping (method = RequestMethod.POST)
    @ResponseBody
    public String syncData(@RequestBody SalesForceRequest sfRequest)
    {
        return sfRequest.getUser();
    }
}
