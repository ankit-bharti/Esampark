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
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor;
import javax.swing.JFileChooser;
import java.io.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
public class client_code {
    static String err;
    public boolean get_connection()
    {
        client_props p=new client_props();
        try {
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            return true;
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(cllient_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return false;
        } catch (SQLException ex) {
            //Logger.getLogger(cllient_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return false;
        }
    }
    public String get_err()
    {
        return err;
    }
    public boolean new_user()
    {
        try {
            client_props p=new client_props();
             Class.forName(p.getjdbcdriver());           
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());

            String str="insert into userinfo values('"+p.getname()+"','"+p.getfaname()+"','"+
                    p.getration()+"','"+p.getdob()+"','"+p.getadd()+"','"+p.getgen()+
                    "','"+p.getphno()+"','"+p.getemail()+"','"+p.getpassword()+"','"+
                    p.getusername()+"')";
            Statement st=con.createStatement();
           int result=st.executeUpdate(str);
             Class.forName(p.getjdbcdriver());           
            Connection con1=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            String str1="insert into forgot_pass values(?,?,?)";
            PreparedStatement pst=con1.prepareStatement(str1);
            pst.setString(1, p.getusername());
            pst.setString(2, p.getques());
            pst.setString(3, p.getanswer());
            
            
           int res=pst.executeUpdate();
           //st.close();
           if(result==1 && res==1)
           {
               return true;
           }
           else
           {
               err="details not saved";
               return false;
           }
        } catch (Exception ex) {
            //Logger.getLogger(client_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return false;
        }
    }
    public boolean login()
    {
        try {
            int flag=0;
            client_props p=new client_props();
            String str="select username,passwrd from userinfo";
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(str);
            if(rs.next())
            {
                do
                {
                    String un=rs.getString(1),pw=rs.getString(2);
                    if(un.equals(p.getusername()) && pw.equals(p.getpassword()))
                    {
                       flag=1;
                       break;
                    }
                    else if(!un.equals(p.getusername()) && pw.equals(p.getpassword()))
                    {
                        flag=2;
                        break;
                    }
                    else if(un.equals(p.getusername()) && !pw.equals(p.getpassword()))
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
    public String select_id()
    {
        client_props p= new client_props();
        JFileChooser obj1=new JFileChooser();
        int option=obj1.showOpenDialog(null);
        
        if(option==0)
        {
            try {
                String path=obj1.getSelectedFile().getAbsolutePath();
                InputStream in = new FileInputStream(path);
                String target="D:\\javalab\\netbeans\\Esampark\\src\\id_proof\\"+p.getusername()+"_id.jpg";
                OutputStream out= new FileOutputStream(target);
                byte[] buf=new byte[1024];
                int len;
                while((len=in.read(buf))>0)
                {
                    out.write(buf);
                }
                return target;
            } catch (Exception ex) {
                //Logger.getLogger(client_code.class.getName()).log(Level.SEVERE, null, ex);
                err=ex.toString();
                String str="";
            return str;
                            }
            }
        else
        {
            return "cancelled";
        }
        
    }
    public String select_residence()
    {
        client_props p= new client_props();
        JFileChooser obj1=new JFileChooser();
        int option=obj1.showOpenDialog(null);
        if(option==0)
        {
            try {
                String path=obj1.getSelectedFile().getAbsolutePath();
                InputStream in = new FileInputStream(path);
                String target="D:\\javalab\\netbeans\\Esampark\\src\\residence_proof\\"+p.getusername()+"_res.jpg";
                OutputStream out= new FileOutputStream(target);
                byte[] buf=new byte[1024];
                int len;
                while((len=in.read(buf))>0)
                {
                    out.write(buf);
                }
                return target;
            } catch (Exception ex) {
                //Logger.getLogger(client_code.class.getName()).log(Level.SEVERE, null, ex);
                err=ex.toString();
                String str="";
            return str;
                            }
            }
        else
        {
            return "cancelled";
        }
        
    }
    public String select_category()
    {
        client_props p= new client_props();
        JFileChooser obj1=new JFileChooser();
        int option=obj1.showOpenDialog(null);
        if(option==0)
        {
            try {
                String path=obj1.getSelectedFile().getAbsolutePath();
                InputStream in = new FileInputStream(path);
                String target="D:\\javalab\\netbeans\\Esampark\\src\\category_proof\\"+p.getusername()+"_cat.jpg";
                OutputStream out= new FileOutputStream(target);
                byte[] buf=new byte[1024];
                int len;
                while((len=in.read(buf))>0)
                {
                    out.write(buf);
                }
                return target;
            } catch (Exception ex) {
                //Logger.getLogger(client_code.class.getName()).log(Level.SEVERE, null, ex);
                err=ex.toString();
                String str="";
            return str;
                            }
        }
        else
        {
            return "cancelled";
        }
    }
    public float charges()
    {
        try {
            String str;
            client_props p= new client_props();
           
            str="select "+p.getduration()+" from charges where category=?";
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst=con.prepareStatement(str);
            pst.setString(1, p.getcategory());
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                float charge=rs.getFloat(1);
                return charge;
            }
            else
            {
                err="nothing found";
                return 0;
            }
        } catch (Exception ex) {
            //Logger.getLogger(client_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return 0;
        }
        
    }
    public boolean find()
    {
        try {
            client_props p=new client_props();
            String str="select * from userinfo where username=?";
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst=con.prepareStatement(str);
            pst.setString(1, p.getusername());
            ResultSet res=pst.executeQuery();
            if(res.next())
            {
                p.setration(res.getString(3));
                return true;
            }
            else
            {
                err="no ration no. found in database";
                return false;
            }
            
        } catch (Exception ex) {
            //Logger.getLogger(client_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return false;
        }
    }
    public boolean buspass_create()
    {
        try {
            client_props p=new client_props();
            String str="insert into businfo values(?,'',?,?,?,?,?,0,getdate(),'')";
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst=con.prepareStatement(str);
            pst.setString(1, p.getration());
            pst.setString(2, p.getcategory());
            pst.setString(3, p.getduration());
            pst.setString(4, p.geturl1());
            pst.setString(5, p.geturl2());
            pst.setString(6, p.geturl3());
            int res=pst.executeUpdate();
            if(res==1)
            {
                return true;
            }
            else
            {
                err="sorry, cannot submit the details";
                return false;
            }
        } catch (Exception ex) {
            //Logger.getLogger(client_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return false;
        }
    }
    public String req_no()
    {
        try {
            client_props p=new client_props();
            int random1=(int) (Math.random()*100);
            int random2=(int)(Math.random()*100);
            String req=Integer.toString(random1)+p.getration()+Integer.toString(random2);
            String str="update businfo set req_no=? where ration_no=?";
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst=con.prepareStatement(str);
            pst.setString(1, req);
            pst.setString(2, p.getration());
            int res=pst.executeUpdate();
            if(res==1)
            {
                
                return req;
            }
            else
            {
                err="sorry, request no cannot be generated";
                return "";
            }
        } catch (Exception ex) {
            //Logger.getLogger(client_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return "";
        }
    }
    public String check_status()
    {
        try {
            client_props p=new client_props();
            String str1="select ration_no from userinfo where username=?";
            Class.forName(p.getjdbcdriver());
            Connection con1=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst1=con1.prepareStatement(str1);
            pst1.setString(1, p.getusername());
            ResultSet res1=pst1.executeQuery();
            if(res1.next())
            {
                p.setration(res1.getString(1));
                String str2="select req_no,req_status from businfo where ration_no=?";
                Class.forName(p.getjdbcdriver());
            Connection con2=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst2=con2.prepareStatement(str2);
            pst2.setString(1, p.getration());
            ResultSet res2=pst2.executeQuery();
            if(res2.next())
            {
                p.setreq(res2.getString(1));
                p.setstatus(res2.getInt(2));
                //p.setreject_msg(res2.getString(3));
                if(p.getstatus()==0 && !p.getreq().equals(""))
                {
                    return "YOUR REQUEST IS UNDER VERIFICATION PROCESS. YOUR BUS PASS IS NOT AVAILABLE YET";
                }
                
                else if(p.getstatus()==1)
                {
                    return "YOUR REQUEST HAS BEEN ACCEPTED. YOUR BUS PASS IS AVAILABLE";
                }
                else
                {
                    String str3="select msg from msg where ration_no=?";
                Class.forName(p.getjdbcdriver());
            Connection con3=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst3=con3.prepareStatement(str3);
            pst3.setString(1, p.getration());
            ResultSet res3=pst3.executeQuery();
            if(res3.next())
            {
                p.setreject_msg(res3.getString(1));
                    return "SORRY YOUR REQUEST HAS BEEN REJECTED. "+p.getreject_msg();
            }
            else
                
            {
                err="no reject message found";
                        return "";
            }
                }
            }
            else
            {
                return "SORRY, WE HAVE NOT RECIEVED YOUR REQUEST";
            }
                
            }
            else
            {
                err="no ration no found for you";
                return "";
            }
        } catch (Exception ex) {
           // Logger.getLogger(client_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return "";
        }
    }
    public boolean forgot_pass()
    {
        try {
            client_props p= new client_props();
            String str="select f.ques,f.answer,u.passwrd from forgot_pass f, userinfo u where f.username=u.username and f.username=?";
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst=con.prepareStatement(str);
            pst.setString(1, p.getusername());
            ResultSet res=pst.executeQuery();
            if(res.next())
            {
                p.setques(res.getString(1));
                p.setanswer(res.getString(2));
                p.setpassword(res.getString(3));
                return true;
              
            }
            else
            {
                err="no hint found for this username";
               return false;
            }
           } catch (Exception ex) {
            //Logger.getLogger(client_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return false;
        }
    }
    public boolean check_username()
    {
        try {
            int flag=0;
            client_props p= new client_props();
            String str="select username from userinfo";
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            Statement st=con.createStatement();
            ResultSet res=st.executeQuery(str);
            if(res.next())
            {
                do{
                    if(res.getString(1).equals(p.getusername()))
                    {
                        flag=1;
                        break;
                    }
                }while(res.next());
                if(flag==1)
                {
                    err="this username already exist";
                    return false;
                }
                else
                {
                    return true;
                }
            }
            else
            {
                return true;
            }
        } catch (Exception ex) {
            //Logger.getLogger(client_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return false;
        }
    }
    public int check_apply()
    {
        try {
            client_props p= new client_props();
            String str="select ration_no from userinfo where username=?";
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst=con.prepareStatement(str);
            pst.setString(1, p.getusername());
            ResultSet res=pst.executeQuery();
            if(res.next())
            {
                p.setration(res.getString(1));
            }
            else
            {
                err="no ration no found";
                return 0;
            }
            String str1="select req_status from businfo where ration_no=?";
            Class.forName(p.getjdbcdriver());
            Connection con1=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst1=con1.prepareStatement(str1);
            pst1.setString(1, p.getration());
            ResultSet res1=pst1.executeQuery();
            if(res1.next())
            {
                int status=res1.getInt(1);
                if(status==0)
                {
                    return 1;
                }
                else if(status==-1)
                {
                    return 2;
                }
                else
                {
                    return 3;
                }
            }
            else
            {
                return 2;
            }
        } catch (Exception ex) {
           // Logger.getLogger(client_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return 0;
        }
        
    }
    public boolean pass_generate()
    {
        try {
            client_props p= new client_props();
            String str="select b.req_no, u.name, u.fname, u.ration_no, u.address,b.accpt_date, b.category, b.duration from businfo b, userinfo u where b.ration_no=u.ration_no and u.username=?";
            Class.forName(p.getjdbcdriver());
            Connection con=DriverManager.getConnection(p.getdb(),p.getserver(),p.getdpass());
            PreparedStatement pst=con.prepareStatement(str);
            pst.setString(1, p.getusername());
            ResultSet res=pst.executeQuery();
            if(res.next())
            {
                p.setreq(res.getString(1));
                p.setname(res.getString(2));
                p.setfaname(res.getString(3));
                p.setration(res.getString(4));
                p.setadd(res.getString(5));
                SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
                String accpt=formatter.format(res.getDate(6));
                p.setdate_accpt(accpt);
                p.setcategory(res.getString(7));
                p.setduration(res.getString(8));
                return true;
            }
            else
            {
                err="details not found";
                return false;
            }
        } catch (Exception ex) {
            //Logger.getLogger(client_code.class.getName()).log(Level.SEVERE, null, ex);
            err=ex.toString();
            return false;
        }
    }
}
