package esampark;


import esampark.admin_props;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kcs pc
 */
public class admin_code {
    static String err;
    public String get_err()
    {
        return err;
    }
    public boolean getcharges()
    {
        try {
            admin_props p=new admin_props();
            if(p.getcategory().equalsIgnoreCase("select"))
            {
                err="please choose a category";
                return false;
            }
            String str="select monthly,quarterly,halfyearly from charges where category=?";
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst=con.prepareStatement(str);
            pst.setString(1, p.getcategory());
            ResultSet res=pst.executeQuery();
            if(res.next())
            {
                p.setmonthly(res.getFloat(1));
                p.setquarter(res.getFloat(2));
                p.sethalfyr(res.getFloat(3));
                return true;
                
            }
            else
            {
                err="no charges found";
                return false;
            }
        } catch (Exception ex) {
            //Logger.getLogger(admin_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return false;
        }
    }
    public boolean updatecharges()
    {
        admin_props p=new admin_props();
        if(p.getmonthly()!=0)
        {
            try {
                String str="update charges set monthly="+String.valueOf(p.getmonthly())+" where category=?";
                Class.forName(p.getjdbcdriver());
                Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
                PreparedStatement pst=con.prepareStatement(str);
                pst.setString(1, p.getcategory());
                int res= pst.executeUpdate();
                if(res!=1)
                {
                    err="sorry, charges not updated";
                    return false;
                }
            } catch (Exception ex) {
                //Logger.getLogger(admin_code.class.getName()).log(Level.SEVERE, null, ex);
                err=ex.toString();
                return false;
            }
        
        }
        if(p.getquarter()!=0)
        {
            try {
                String str="update charges set quarterly="+String.valueOf(p.getquarter())+" where category=?";
                Class.forName(p.getjdbcdriver());
                Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
                PreparedStatement pst=con.prepareStatement(str);
                pst.setString(1, p.getcategory());
                int res= pst.executeUpdate();
                if(res!=1)
                {
                    err="sorry, charges not updated";
                    return false;
                }
            } catch (Exception ex) {
                //Logger.getLogger(admin_code.class.getName()).log(Level.SEVERE, null, ex);
                err=ex.toString();
                return false;
            }
        
        }
        if(p.gethalfyr()!=0)
        {
            try {
                String str="update charges set halfyearly="+String.valueOf(p.gethalfyr())+" where category=?";
                Class.forName(p.getjdbcdriver());
                Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
                PreparedStatement pst=con.prepareStatement(str);
                pst.setString(1, p.getcategory());
                int res= pst.executeUpdate();
                if(res!=1)
                {
                    err="sorry, halfyearly charges not updated";
                    return false;
                }
            } catch (Exception ex) {
                //Logger.getLogger(admin_code.class.getName()).log(Level.SEVERE, null, ex);
                err=ex.toString();
                return false;
            }
        
        }
        return true;
    }
    public boolean  get_today_app()
    {
        try {
            admin_props p= new admin_props();
            String str="select req_no from businfo where cur_date=CAST(CURRENT_TIMESTAMP as date) and req_status=0";
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(str);
            ArrayList<String> req=new ArrayList<String>();
            if(res.next())
            {
                
                do
            {
                req.add(res.getString(1));
            }while(res.next());
        
            p.setreq_array(req);
            return true;
            }
            else
            {
                err="no records for today";
                return false;
            }
        } catch (Exception ex) {
            //Logger.getLogger(admin_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return false;
        }
        
    }
    public boolean getdetails()
    {
        try {
            admin_props p= new admin_props();
            String str="select * from businfo where req_no=?";
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst= con.prepareStatement(str);
            pst.setString(1, p.getreq_no());
            ResultSet res=pst.executeQuery();
            if(res.next())
            {
                p.setration(res.getString(1));
                p.setcategory(res.getString(3));
                p.setduration(res.getString(4));
                p.seturl1(res.getString(5));
                p.seturl2(res.getString(6));
                p.seturl3(res.getString(7));
                SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
                String date=format.format(res.getDate(9));
                p.setdos(date);
            }
            else
            {
                err="no details found";
                        return false;
            }
            String str1="select * from userinfo where ration_no=?";
            Class.forName(p.getjdbcdriver());
            Connection con1=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst1= con1.prepareStatement(str1);
            pst1.setString(1, p.getration());
            ResultSet res1=pst1.executeQuery();
            if(res1.next())
            {
                p.setname(res1.getString(1));
                p.setfaname(res1.getString(2));
                p.setdob(res1.getString(4));
                p.setadd(res1.getString(5));
                p.setgen(res1.getString(6));
                p.setphno(res1.getString(7));
               p.setemail(res1.getString(8));
               p.setusername(res1.getString(10));
            }
            else
            {
                err="no details found";
                        return false;
            }
            String str2="select "+p.getduration()+" from charges where category=?";
            Class.forName(p.getjdbcdriver());
            Connection con2=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst2= con2.prepareStatement(str2);
            pst2.setString(1, p.getcategory());
            ResultSet res2=pst2.executeQuery();
            if(res2.next())
            {
                p.setcharges(res2.getFloat(1));
                return true;
            }
            else
            {
                err="no details found";
                return false;
            }
        } catch (Exception ex) {
            //Logger.getLogger(admin_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return false;
        }
        
        
    }
    public boolean get_cat_app()
    {
        try {
            admin_props p= new admin_props();
            String str="select req_no from businfo where category=? and req_status=0";
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst=con.prepareStatement(str);
            pst.setString(1,p.getcategory());
            ResultSet res=pst.executeQuery();
            ArrayList<String> req=new ArrayList<String>();
            if(res.next())
            {
                
                do
            {
                req.add(res.getString(1));
            }while(res.next());
        
            p.setreq_array(req);
            return true;
            }
            else
            {
                err="no records available";
                return false;
            }
        } catch (Exception ex) {
            //Logger.getLogger(admin_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return false;
        }
    }
    public boolean get_date_app()
    {
        
        try {
            admin_props p=new admin_props();
            SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
          java.util.Date dos=formatter.parse(p.getdos());
           String dos1=formatter1.format(dos);
            String str="select req_no from businfo where cur_date=? and req_status=0";
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst=con.prepareStatement(str);
            pst.setString(1,dos1);
            ResultSet res=pst.executeQuery();
            ArrayList<String> req=new ArrayList<String>();
            if(res.next())
            {
                
                do
            {
                req.add(res.getString(1));
            }while(res.next());
        
            p.setreq_array(req);
            return true;
            }
            else
            {
                err="no records available";
                return false;
            }
        } catch (Exception ex) {
            //Logger.getLogger(admin_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return false;
        }
    }
    public boolean accepted()
    {
        try
        {
        client_props cp=new client_props();
        admin_props ap= new admin_props();
        String str="update businfo set req_status=1, accpt_date=GETDATE() where req_no=?";
        Class.forName(ap.getjdbcdriver());
            Connection con=DriverManager.getConnection(ap.getdb(),ap.getserver(),ap.getdpass());
            PreparedStatement pst=con.prepareStatement(str);
            pst.setString(1,ap.getreq_no());
            int res=pst.executeUpdate();
            if(res==1)
            {
                return true;
            }
            else
            {
                err="cannot update request status";
                return false;
            }
        }catch(Exception ex)
        {
            err=ex.toString();
            return false;
        }
    }
    public boolean rejected()
    {
        try
        {
        client_props cp=new client_props();
        admin_props ap= new admin_props();
        String str="update businfo set req_status=-1 where req_no=?";
        Class.forName(ap.getjdbcdriver());
            Connection con=DriverManager.getConnection(ap.getdb(),ap.getserver(),ap.getdpass());
            PreparedStatement pst=con.prepareStatement(str);
            pst.setString(1,ap.getreq_no());
            int res=pst.executeUpdate();
            if(res==1)
            {
                String str1="insert into msg values(?,?)";
                Class.forName(ap.getjdbcdriver());
            Connection con1=DriverManager.getConnection(ap.getdb(),ap.getserver(),ap.getdpass());
            PreparedStatement pst1=con1.prepareStatement(str1);
            pst1.setString(1,ap.getration());
            pst1.setString(2, cp.getreject_msg());
            int res1=pst1.executeUpdate();
            if(res1==1)
            {
                return true;
            }
            else
            {
                err="cannot update reject message";
                return false;
            }
            }
            else
            {
                err="cannot update request status";
                return false;
            }
        }catch(Exception ex)
        {
            err=ex.toString();
            return false;
        }
    }
    public boolean getreport()
    {
        try{
        admin_props p=new admin_props();
        SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
          java.util.Date dos=formatter.parse(p.getdos());
           String dos1=formatter1.format(dos);
        String str="select count(req_no) from businfo where cur_date='"+dos1+"'";
        Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
        PreparedStatement pst= con.prepareStatement(str);
        ResultSet res=pst.executeQuery();
        if(res.next())
        {
            p.settotal(res.getInt(1));
        }
        else
        {
            err="no total count found";
            return false;
        }
        String str1="select count(req_no) from businfo where cur_date='"+dos1+"' and (req_status=1 or req_status=-1)";
        Class.forName(p.getjdbcdriver());
            Connection con1=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
        PreparedStatement pst1=con1.prepareStatement(str1);
        ResultSet res1=pst1.executeQuery();
        if(res1.next())
        {
            p.setchecked(res1.getInt(1));
        }
        else
        {
            err="no checked count found";
            return false;
        }
        String str2="select count(req_no) from businfo where cur_date='"+dos1+"' and req_status=0";
        Class.forName(p.getjdbcdriver());
            Connection con2=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
        PreparedStatement pst2=con2.prepareStatement(str2);
        ResultSet res2=pst2.executeQuery();
        if(res2.next())
        {
            p.setpending(res2.getInt(1));
        }
        else
        {
            err="no pending count found";
            return false;
        }
        return true;
        }catch(Exception ex)
        {
            err=ex.toString();
            return false;
        }
    }
}
