package com.iTracMedia.Security;

import java.io.IOException;
import java.util.Date;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.iTracMedia.Bao.Beans.ResponseBeans.CommonReponse;
import com.iTracMedia.Bao.BusinessObjects.utils.DateFormatiTracMedia;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter
{
    static Logger log = Logger.getLogger(AuthenticationFilter.class.getName());
    @Override
    public void filter(ContainerRequestContext request) throws IOException
    {
        String route = request.getUriInfo().getRequestUri().toString();
        String method = request.getMethod().toUpperCase(); 
        boolean isAutheticated = true;
        if (!isAutheticated)
        {
            log.error(method + "\t" + route + " - Authentication failed...");
            CommonReponse res = new CommonReponse();
            res.setCode(1);
            res.setMessage("Unauthorized");
            res.setServerDate(DateFormatiTracMedia.DateToString(new Date()));
            request.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(new Gson().toJson(res)).build());
        }
        else
        {
            log.info(method + "\t" + route + " - Authentication done...");
        }
    }
}