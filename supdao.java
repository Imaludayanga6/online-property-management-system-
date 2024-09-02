package support;

import java.util.*;
import java.sql.*; 

public class supdao {  
	  
	    public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.jdbc.Driver");  
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cussupport","root","Imal#@1234");  
	        }catch(Exception e){
	        	System.out.println(e);
	        	}  
	        return con;  
	    }  
	    public static int save(sup e){  
	        int status=0;  
	        try{  
	            Connection con=supdao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into support(name,email,subject,massage) values (?,?,?,?)");  
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getEmail());  
	            ps.setString(3,e.getSubject());  
	            ps.setString(4,e.getMassage());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex)
	        {
	        	ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int update(sup e){  
	        int status=0;  
	        try{  
	            Connection con=supdao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update support set name=?,email=?,subject=?,massage=? where id=?");  
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getEmail());  
	            ps.setString(3,e.getSubject());  
	            ps.setString(4,e.getMassage());  
	            ps.setInt(5,e.getId());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex)
	        {ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=supdao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from support where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static sup getcustomerById(int id){  
	    	sup e=new sup();  
	          
	        try{  
	            Connection con=supdao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from support where id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs = ps.executeQuery();  
	            if(rs.next()){  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setEmail(rs.getString(3));  
	                e.setSubject(rs.getString(4));  
	                e.setMassage(rs.getString(5));  
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
	    }  
	    public static List<sup> getAllcustomer(){  
	        List<sup> list=new ArrayList<sup>();  
	          
	        try{  
	            Connection con=supdao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from support");  
	            ResultSet rs = ps.executeQuery();  
	            while(rs.next()){  
	            	sup e=new sup();  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setEmail(rs.getString(3));  
	                e.setSubject(rs.getString(4));  
	                e.setMassage(rs.getString(5));  
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    } 
}


