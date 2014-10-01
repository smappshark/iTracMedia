package com.iTracMedia.Bao.Beans.Model;

import java.sql.Date;

public class Users
{
    private int userid;
    private int companyid;
    private String firstname;
    private String lastname;
    private String phoneno;
    private String cellno;
    private String email;
    private String password;
    private String managerid;
    private String title;
    private String disclaimer;
    private String signaturestatus;
    private String signatureline;
    private String country;
    private String region;
    private int regionid;
    private String city;
    private int cityid;
    private String office;
    private int officeid;
    private String team;
    private int teamid;
    private int adminlevel;
    private Date deleted_at;

    public int getUserid()
    {
        return userid;
    }

    public void setUserid(int userid)
    {
        this.userid = userid;
    }

    public int getCompanyid()
    {
        return companyid;
    }

    public void setCompanyid(int companyid)
    {
        this.companyid = companyid;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getPhoneno()
    {
        return phoneno;
    }

    public void setPhoneno(String phoneno)
    {
        this.phoneno = phoneno;
    }

    public String getCellno()
    {
        return cellno;
    }

    public void setCellno(String cellno)
    {
        this.cellno = cellno;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getManagerid()
    {
        return managerid;
    }

    public void setManagerid(String managerid)
    {
        this.managerid = managerid;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDisclaimer()
    {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer)
    {
        this.disclaimer = disclaimer;
    }

    public String getSignaturestatus()
    {
        return signaturestatus;
    }

    public void setSignaturestatus(String signaturestatus)
    {
        this.signaturestatus = signaturestatus;
    }

    public String getSignatureline()
    {
        return signatureline;
    }

    public void setSignatureline(String signatureline)
    {
        this.signatureline = signatureline;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public int getRegionid()
    {
        return regionid;
    }

    public void setRegionid(int regionid)
    {
        this.regionid = regionid;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public int getCityid()
    {
        return cityid;
    }

    public void setCityid(int cityid)
    {
        this.cityid = cityid;
    }

    public String getOffice()
    {
        return office;
    }

    public void setOffice(String office)
    {
        this.office = office;
    }

    public int getOfficeid()
    {
        return officeid;
    }

    public void setOfficeid(int officeid)
    {
        this.officeid = officeid;
    }

    public String getTeam()
    {
        return team;
    }

    public void setTeam(String team)
    {
        this.team = team;
    }

    public int getTeamid()
    {
        return teamid;
    }

    public void setTeamid(int teamid)
    {
        this.teamid = teamid;
    }

    public int getAdminlevel()
    {
        return adminlevel;
    }

    public void setAdminlevel(int adminlevel)
    {
        this.adminlevel = adminlevel;
    }

    public Date getDeleted_at()
    {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at)
    {
        this.deleted_at = deleted_at;
    }
}