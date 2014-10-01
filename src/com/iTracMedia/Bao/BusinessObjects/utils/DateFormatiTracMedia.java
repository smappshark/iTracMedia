package com.iTracMedia.Bao.BusinessObjects.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatiTracMedia
{
    public static String DateToString(Date dt)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat(StringConstants.DateFormatiTracMedia);
        return dateFormat.format(dt);
    }
}
