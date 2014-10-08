package com.iTracMedia.Bao.Beans.ResponseBeans;


public class CommonReponse
{
    private int Code;
    private String Message;
    private String ServerDate;

    public int getCode()
    {
        return Code;
    }

    public void setCode(int code)
    {
        this.Code = code;
    }

    public String getMessage()
    {
        return Message;
    }

    public void setMessage(String message)
    {
        this.Message = message;
    }

    public String getServerDate()
    {
        return ServerDate;
    }

    public void setServerDate(String date)
    {
        this.ServerDate = date;
    }
}
