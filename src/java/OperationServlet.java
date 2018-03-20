import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/OperationServlet"})
public class OperationServlet extends HttpServlet {

   
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name,age,phone,email;
        int ageNum,phoneNum;
            
        String op = request.getParameter("op");
        PrintWriter out = response.getWriter();
        if(op.equals("insert"))
        {
            name = request.getParameter("name");
            age = request.getParameter("age");
            ageNum = Integer.parseInt(age);
            phone = request.getParameter("phone");
            phoneNum = Integer.parseInt(phone);
            email = request.getParameter("email");
            StudentModel sm = new StudentModel();
            sm.setName(name);
            sm.setAge(ageNum);
            sm.setPhone(phoneNum);
            sm.setEmail(email);
            StudentDAO td = new StudentDAOImp();
            if(td.insert(sm)==1)
            {
                out.print("Insert success!");
            }
            else 
            {
                out.print("Insert Failed!");
            } 
        }
        else if(op.equals("delete"))
        {
            name = request.getParameter("name");
            StudentDAO td = new StudentDAOImp();
            if(td.delete(name)==1)
            {
                out.print("delete success!");
            }
            else 
            {
                out.print("delete Failed!");
            } 
        }
        else if(op.equals("update"))
        {
            StudentModel sm = new StudentModel();
            name = request.getParameter("name");
            age = request.getParameter("age");
            ageNum = Integer.parseInt(age);
            phone = request.getParameter("phone");
            phoneNum = Integer.parseInt(phone);
            email = request.getParameter("email");
            sm.setName(name);
            sm.setAge(ageNum);
            sm.setPhone(phoneNum);
            sm.setEmail(email);
            StudentDAO td = new StudentDAOImp();
            if(td.update(sm)==1)
            {
                out.print("update success!");
            }
            else 
            {
                out.print("update Failed!");
            } 
        }
        else if(op.equals("select"))
        {
            name = request.getParameter("name");
            List<StudentModel> t = new LinkedList<StudentModel>();
            StudentModel sm = new StudentModel();
            StudentDAO td = new StudentDAOImp();
            t = td.select(name);
            for(int i=0;t.size()>i;i++)
            {
                sm = t.get(i);
                out.println("Name: "+sm.getName());
                out.println("Age: "+sm.getAge());
                out.println("Phone: "+sm.getPhone());
                out.println("Email: "+sm.getEmail());
            }
        }
        else if(op.equals("selectall"))
        {
            List<StudentModel> t = new LinkedList<StudentModel>();
            StudentModel sm = new StudentModel();
            StudentDAO td = new StudentDAOImp();
            t =  td.selectAll();
            for(int i=0;t.size()>i;i++)
            {
                sm = t.get(i);
                out.println("Name: "+sm.getName());
                out.println("Age: "+sm.getAge());
                out.println("Phone: "+sm.getPhone());
                out.println("Email: "+sm.getEmail());
                out.println("----------------------");
            }
        }
    }

}
