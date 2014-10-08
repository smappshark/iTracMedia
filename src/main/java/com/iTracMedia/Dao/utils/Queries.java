package com.iTracMedia.Dao.utils;

public class Queries
{
    public static final String TableMetadataQuery = "SELECT COLUMN_NAME AS ColumnName, DATA_TYPE AS DataType, CHARACTER_MAXIMUM_LENGTH AS MaxLength, NUMERIC_PRECISION AS 'Precision', NUMERIC_SCALE AS Scale, IS_NULLABLE AS IsNullable, COLUMN_KEY AS ColumnKey FROM information_schema.columns WHERE table_schema = '{iTracMediaDatabaseName}' AND table_name = '{iTracMediaTableName}' ORDER BY COLUMN_NAME";
    public static final String ContactsSyncQuery = "INSERT INTO {iTracMediaDatabaseName}.contacts (fullname, firstname, lastname, title, email, businessphone, businessfax, mobilephone, homephone, businessphoneext, leadsource) values(?,?,?,?,?,?,?,?,?,?,?)";
    public static final String SFDCQueryForContacts = "SELECT AssistantName, AssistantPhone, Birthdate, Jigsaw, Department, Description, Email, Fax, HomePhone, LastCURequestDate, LastCUUpdateDate, LeadSource, MobilePhone, Name, OtherPhone, Phone, Title FROM Contact";
    public static final String inertIntoColumnMappings = "INSERT INTO {iTracMediaDatabaseName}.columnmappings (sObject, tableName, sfField, selectedField) values(?,?,?,?)";
    public static final String ListofTables = "SELECT DISTINCT(TABLE_NAME) AS 'TableName' FROM information_schema.tables WHERE TABLE_SCHEMA = '{iTracMediaDatabaseName}'";
    public static final String inertIntoObjectMappings = "INSERT INTO {iTracMediaDatabaseName}.objectmappings (sObject, tableName) values(?,?)";

}