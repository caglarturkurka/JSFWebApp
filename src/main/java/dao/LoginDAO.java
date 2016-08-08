/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Users;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author caglarturkurka
 */
public class LoginDAO {
    
    PreparedStatement ps=null;//SQL sorgumuzu tutacak ve çalıştıracak nesne.
    Connection con=null;//Veri tabanına bağlantı yapmamızı sağlayacak nesne.
   
    
    public boolean check(String username,String password){
        boolean result=false;
        try{
             Class.forName("com.mysql.jdbc.Driver");//Hangi türde bir veri tabanını kullanacağını bildiriyoruz.
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/calismaDB","root","");//Bağlanacağı veri tabanını ve kullanacağı kullanıcı adı-parolayı bildiriyoruz.
            ps=con.prepareStatement("SELECT * FROM users where username=? and password=?");//Yazarlar tablosundaki herşeyi çek diyoruz.
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();//SQL Sorgusundan dönecek sonuç rs sonuç kümesi içinde tutulacak.
            while(rs.next()){
                result=true;
            }   
        }catch(ClassNotFoundException | SQLException exception){
             System.out.println("Bir hata meydana geldi:"+exception);
            
        }finally{
                 try {
                if(con!=null){ //Connection nesnesi belki yukarıda null kalmış olabilir. Kontrol etmekte fayda var.
                    con.close();
                }
                if(ps!=null){ //PreparedStatement nesnesi yukarıda null kalmış olabilir. Kontrol etmekte fayda var.
                    ps.close();
                }
            } catch (SQLException sqlException) {
                System.out.println("Bir hata meydana geldi:"+sqlException);
            }
        }
       
        
            return result;
    }
    
     
}
