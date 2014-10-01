package com.iTracMedia.Bao.Beans;

public class TableMetadata
{
    private String ColumnName;
    private String DataType;
    private int MaxLength;
    private int Precision;
    private int Scale;
    private boolean IsNullable;
    private String ColumnKey;

    public String getColumnName()
    {
        return ColumnName;
    }

    public void setColumnName(String columnName)
    {
        ColumnName = columnName;
    }

    public String getDataType()
    {
        return DataType;
    }

    public void setDataType(String dataType)
    {
        DataType = dataType;
    }

    public int getMaxLength()
    {
        return MaxLength;
    }

    public void setMaxLength(int maxLength)
    {
        MaxLength = maxLength;
    }

    public int getPrecision()
    {
        return Precision;
    }

    public void setPrecision(int precision)
    {
        Precision = precision;
    }

    public int getScale()
    {
        return Scale;
    }

    public void setScale(int scale)
    {
        Scale = scale;
    }

    public boolean isIsNullable()
    {
        return IsNullable;
    }

    public void setIsNullable(boolean isNullable)
    {
        IsNullable = isNullable;
    }

    public String getColumnKey()
    {
        return ColumnKey;
    }

    public void setColumnKey(String columnKey)
    {
        ColumnKey = columnKey;
    }
}