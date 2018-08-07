/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esampark;

import static esampark.client_code.err;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kcs pc
 */
public class oprtr_code {
    static String err;
    public boolean login()
    {
        try {
            int flag=0;
            oprtr_props p=new oprtr_props();
            String str="select * from operator";
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(str);
            if(rs.next())
            {
                do
                {
                    p.setopt_id(rs.getString(1));
                    String un=rs.getString(2),pw=rs.getString(3);
                    if(un.equals(p.getopt_username()) && pw.equals(p.getopt_password()))
                    
                    {
                        
                       flag=1;
                       break;
                    }
                    else if(!un.equals(p.getopt_username()) && pw.equals(p.getopt_password()))
                    {
                        flag=2;
                        break;
                    }
                    else if(un.equals(p.getopt_username()) && !pw.equals(p.getopt_password()))
                    {
                        flag=3;
                        break;
                    }
                }while(rs.next());
                if(flag==0)
                {
                    err="incorrect username and password";
                    
                    return false;
                    
                }
                else if(flag==2)
                {
                    err="incorrect username";
                    return false;
                }
                else if(flag==3)
                {
                    err="incorrect password";
                    return false;
                }
                else
                {
                    
                    return true;
                }
                    
            }
            else
            {
                err="nothing in database";
                return false;
            }
            
                    } catch (Exception ex) {
            //Logger.getLogger(client_code.class.getName()).log(Level.SEVERE, null, ex);
              err=ex.toString();
              return false;
        }
    }
    public String get_err()
    {
        return err;
    }
    public boolean bill_billid()
    {
        try {
            oprtr_props p= new oprtr_props();
            String str="select * from custinfo2 where bill_no=?";
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst= con.prepareStatement(str);
            pst.setInt(1, p.getbill_no());
            ResultSet res=pst.executeQuery();
            if(res.next())
            {
                p.setcust_id(res.getString(1));
                p.setmnth(res.getString(3));
                p.setunits(res.getFloat(4));
                p.setbill_amount(res.getFloat(5));
                SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
                String due_date=formatter.format(res.getDate(6));
                p.setdue_date(due_date);
                SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
                String date_out=format.format(res.getDate(7));
                p.setdate_out(date_out);
                p.setfine(res.getFloat(8));
                p.settotal(res.getFloat(9));
                p.setstatus(res.getInt(10));
                if(p.getstatus()==1)
                {
                    err="already paid";
                    return false;
                }
                else if(p.getstatus()==-1)
                {
                    err="electric connection is no longer available for you";
                    return false;
                }
                else
                {
                    return true;
                }
                
            }
            else
            {
                err="no bill found";
                return false;
            }
        } catch (Exception ex) {
            //Logger.getLogger(oprtr_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return false;
        }
    }
    public boolean disconnect()
    {
        try {
            oprtr_props p=new oprtr_props();
            String str="update custinfo2 set pay_status=-1 where custid=?";
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst= con.prepareStatement(str);
            pst.setString(1, p.getcust_id());
            int res=pst.executeUpdate();
            if(res==1)
            {
                err="your connection has been disconnected";
                return true;
            }
            else
            {
                err="sorry, cannot be disconnected";
                return false;
                        
            }
        } catch (Exception ex) {
            //Logger.getLogger(oprtr_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return false;
        }
            
    }
    public boolean paybill()
    {
        try{
            oprtr_props p= new oprtr_props();
            String str="insert into cust_bill values(?,?,GETDATE(),?,?,?,?)";
              Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst=con.prepareStatement(str);
            pst.setString(1, p.getcust_id());
            pst.setInt(2, p.getbill_no());
            pst.setFloat(3, p.getpay_amount());
            pst.setString(4, p.getpayment_mode());
            pst.setString(5, p.getmode_no());
            pst.setString(6, p.getopt_id());
            int res=pst.executeUpdate();
            if(res==1)
            {
                String str1="update custinfo2 set pay_status=1 where bill_no="+p.getbill_no();
                Class.forName(p.getjdbcdriver());
            Connection con1=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            Statement st=con1.createStatement();
            int result=st.executeUpdate(str1);
            if(result==1)
            {
                return true;
            }
            else
            {
                err="could not update pay status";
                return false;
            }
            }
            else
            {
                err="could not the payment details";
                return false;
            }
            
        }catch(Exception ex)
        {
            err=ex.toString();
            return false;
        }
    }
    public boolean receipt()
    {
        try {
            oprtr_props p =new oprtr_props();
            String str="select name,adress from custinfo where custid=?";
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst=con.prepareStatement(str);
            pst.setString(1, p.getcust_id());
            ResultSet res=pst.executeQuery();
            if(res.next())
            {
                p.setname(res.getString(1));
                p.setadd(res.getString(2));
                String str1="select paydate from cust_bill where bill_no=?";
                Class.forName(p.getjdbcdriver());
            Connection con1=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst1=con1.prepareStatement(str1);
            pst1.setInt(1, p.getbill_no());
            ResultSet res1=pst1.executeQuery();
            if(res1.next())
            {
                SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
                String pay=formatter.format(res1.getDate(1));
                p.setpay_date(pay);
                return true;
            }
            else
            {
                err="could not find pay date";
                return false;
            }
            }
            else
            {
                err="cannot find name and address of customer";
                return false;
            }
        } catch (Exception ex) {
            //Logger.getLogger(oprtr_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return false;
        }
    }
    
}
