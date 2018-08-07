/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esampark;

/**
 *
 * @author kcs pc
 */
public class oprtr_props {
    static String opt_id,opt_username,opt_password, cust_id,mnth, due_date, date_out, pay_date,payment_mode,mode_no, cust_name, cust_add;
    static int bill_no,status;
    static float units,bill_amount, fine, total_amount,payable_amount;
    public void setopt_id(String temp)
    {
        opt_id=temp;
    }
    public String getopt_id()
    {
        return opt_id;
    }
    public void setopt_username(String temp)
    {
        opt_username=temp;
    }
    public String getopt_username()
    {
        return opt_username;
    }
    public void setopt_password(String temp)
    {
        opt_password=temp;
    }
    public String getopt_password()
    {
        return opt_password;
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
      public void setbill_no(int temp)
    {
        bill_no=temp;
    }
    public int getbill_no()
    {
        return bill_no;
    }
    public void setcust_id(String temp)
    {
        cust_id=temp;
    }
    public String getcust_id()
    {
        return cust_id;
    }
    public void setmnth(String temp)
    {
        mnth=temp;
    }
    public String getmnth()
    {
        return mnth;
    }
    public void setdue_date(String temp)
    {
        due_date=temp;
    }
    public String getdue_date()
    {
        return due_date;
    }
    public void setdate_out(String temp)
    {
        date_out=temp;
    }
    public String getdate_out()
    {
        return date_out;
    }
    public void setunits(float temp)
    {
        units=temp;
    }
    public Float getunits()
    {
        return units;
    }
    public void setbill_amount(float temp)
    {
        bill_amount=temp;
    }
    public Float getbill_amount()
    {
        return bill_amount;
    }
    public void setfine(float temp)
    {
        fine=temp;
    }
    public Float getfine()
    {
        return fine;
    }
    public void settotal(float temp)
    {
        total_amount=temp;
    }
    public Float gettotal()
    {
        return total_amount;
    }
    public void setstatus(int temp)
    {
        status=temp;
    }
    public int getstatus()
    {
        return status;
    }
    public void setpay_amount(float temp)
    {
        payable_amount=temp;
    }
    public Float getpay_amount()
    {
        return payable_amount;
    }
    public void setpay_date(String temp)
    {
        pay_date=temp;
    }
    public String getpay_date()
    {
        return pay_date;
    }
    public void setpayement_mode(String temp)
    {
        payment_mode=temp;
    }
    public String getpayment_mode()
    {
        return payment_mode;
    }
    public void setmode_no(String temp)
    {
        mode_no=temp;
    }
    public String getmode_no()
    {
        return mode_no;
    }
    public void setname(String temp)
    {
        cust_name=temp;
    }
    public String getname()
    {
        return cust_name;
    }
    public void setadd(String temp)
    {
        cust_add=temp;
    }
    public String getadd()
    {
        return cust_add;
    }
      
}
