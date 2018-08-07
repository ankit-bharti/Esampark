package esampark;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kcs pc
 */
import java.util.*;
public class admin_props {
    static String name, faname, ration, dob, address, gender, phno, email, username, category, duration;
    static String url1="",url2="",url3="",req_no="",dos;
    static float monthly,quarter,halfyr,charges;
    static int total,checked,pending;
    static ArrayList<String> req_arr=new ArrayList<String>();
    static boolean idvalid,resvalid,catvalid;
    public void setcategory(String temp)
    {
        category=temp;
    }
    public String getcategory()
    {
        return category;
    }
    public void setmonthly(float temp)
    {
        monthly=temp;
    }
    public float getmonthly()
    {
        return monthly;
    }
   public void setcharges(float temp)
    {
        charges=temp;
    }
    public float getcharges()
    {
        return charges;
    }
    public void setquarter(float temp)
    {
        quarter=temp;
    }
    public float getquarter()
    {
        return quarter;
    }
    public void sethalfyr(float temp)
    {
        halfyr=temp;
    }
    public float gethalfyr()
    {
        return halfyr;
    }
    public String getjdbcdriver()
    {
        return "sun.jdbc.odbc.JdbcOdbcDriver";
    }
    public String getdb()
    {
        return "jdbc:odbc:e-sampark";
    }
     public String getserver()
    {
        return "sa";
    }
      public String getdpass()
    {
        return "yashig12";
    }
      public void setreq_array(ArrayList<String> temp)
      {
          req_arr.clear();
          for(int i=0;i<temp.size();i++)
          {
              req_arr.add(temp.get(i));
          }
      }
      public ArrayList<String> getreq_array()
      {
          return req_arr;
      }
      public void setreq_no(String temp)
    {
        req_no=temp;
    }
    public String getreq_no()
    {
        return req_no;
    }
     public void setname(String temp)
    {
        name=temp;
    }
    public String getname()
    {
        return name;
    }
    public void setfaname(String temp)
    {
        faname=temp;
    }
    public String getfaname()
    {
        return faname;
    }
    public void setration(String temp)
    {
        ration=temp;
    }
    public String getration()
    {
        return ration;
    }
    public void setdob(String temp)
    {
        dob=temp;
    }
    public String getdob()
    {
        return dob;
    }
    public void setadd(String temp)
    {
        address=temp;
    }
    public String getadd()
    {
        return address;
    }
    public void setgen(String temp)
    {
        gender=temp;
    }
    public String getgen()
    {
        return gender;
    }
    public void setphno(String temp)
    {
        phno=temp;
    }
    public String getphno()
    {
        return phno;
    }
    
    public void setemail(String temp)
    {
        email=temp;
    }
    public String getemail()
    {
        return email;
    }
    public void setusername(String temp)
    {
        username=temp;
    }
    public String getusername()
    {
        return username;
    }
    public void setduration(String temp)
    {
        duration=temp;
    }
    public String getduration()
    {
        return duration;
    }
    public void seturl1(String temp)
    {
        url1=temp;
    }
    public String geturl1()
    {
        return url1;
    }
    public void seturl2(String temp)
    {
        url2=temp;
    }
    public String geturl2()
    {
        return url2;
    }
    public void seturl3(String temp)
    {
        url3=temp;
    }
    public String geturl3()
    {
        return url3;
    }
     public void setdos(String temp)
    {
        dos=temp;
    }
    public String getdos()
    {
        return dos;
    }
    public void settotal(int temp)
    {
        total=temp;
    }
    public int gettotal()
    {
        return total;
    }
    public void setchecked(int temp)
    {
        checked=temp;
    }
    public int getchecked()
    {
        return checked;
    }
    public void setpending(int temp)
    {
        pending=temp;
    }
    public int getpending()
    {
        return pending;
    }
    public void setidvalid(boolean temp)
    {
        idvalid=temp;
    }
    public boolean getidvalid()
    {
        return idvalid;
    }
    public void setresvalid(boolean temp)
    {
        resvalid=temp;
    }
    public boolean getresvalid()
    {
        return resvalid;
    }
    public void setcatvalid(boolean temp)
    {
        catvalid=temp;
    }
    public boolean getcatvalid()
    {
        return catvalid;
    }
    
}
