package support;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/supview")  
public class supview extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='customer.html'>Add a New Ticket</a>");  
        out.println("<h1>Employees List</h1>");  
          
        List<sup> list=supdao.getAllcustomer();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>email</th><th>subject</th><th>massage</th><th>Edit</th><th>Delete</th></tr>");  
        for(sup e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td>"
         		+ "<td>"+e.getSubject()+"</td><td>"+e.getMassage()+"</td><td><a href='supedit?id="+e.getId()+"'>edit</a></td>"
         				+ "<td><a href='supdelete?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}
