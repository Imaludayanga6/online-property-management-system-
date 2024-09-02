package support;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/supedit2")  
public class supedit2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
        String email=request.getParameter("email");  
        String subject=request.getParameter("subject");  
        String massage=request.getParameter("massage");  
          
        sup e=new sup();  
        e.setId(id);  
        e.setName(name);  
        e.setEmail(email);  
        e.setSubject(subject);  
        e.setMassage(massage);  
          
        int status=supdao.update(e);  
        if(status>0){  
            response.sendRedirect("supview");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}