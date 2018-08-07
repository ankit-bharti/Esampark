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
public class client_props {
    static String name, faname, ration, dob, address, gender, phno, email, username, password, category, duration, reject_msg;
    static String url1="",url2="",url3="",req_no="",ques,answer,date_accpt;
    static int status;
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
    public void setpassword(String temp)
    {
        password=temp;
    }
    public String getpassword()
    {
        return password;
    }
    public void setcategory(String temp)
    {
        category=temp;
    }
    public String getcategory()
    {
        return category;
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
    public void setreq(String temp)
    {
        req_no=temp;
    }
    public String getreq()
    {
        return req_no;
    }
     public void setstatus(int temp)
    {
        status=temp;
    }
    public int getstatus()
    {
        return status;
    }
    public void setreject_msg(String temp)
    {
        reject_msg=temp;
    }
    public String getreject_msg()
    {
        return reject_msg;
    }
    public void setques(String temp)
    {
        ques=temp;
    }
    public String getques()
    {
        return ques;
    }
     public void setanswer(String temp)
    {
        answer=temp;
    }
    public String getanswer()
    {
        return answer;
    }
     public void setdate_accpt(String temp)
    {
        date_accpt=temp;
    }
    public String getdate_accpt()
    {
        return date_accpt;
    }
    
}
