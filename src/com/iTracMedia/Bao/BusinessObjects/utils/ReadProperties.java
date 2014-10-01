package com.iTracMedia.Bao.BusinessObjects.utils;

import java.util.ResourceBundle;

public class ReadProperties
{
    private static ResourceBundle resource = null;

    public static ResourceBundle getBundle(String resourcePath)
    {
        if (resource == null)
        {
            resource = ResourceBundle.getBundle(resourcePath);
            return resource;
        }
        return resource;
    }
}