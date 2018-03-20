import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StudentDAOImp implements StudentDAO{
    
    //Connection con;
    @Override
     public Connection getCon()
    {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentDB","root", "");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
   
    //ORM object relation mapping: comparing the component of object oriented to database(relation) class->table object-> row
    @Override
    public int insert(StudentModel sm)
    {
        Connection con = getCon();
        try {
            PreparedStatement ps = con.prepareStatement("insert into StudentModel values(?,?,?,?)");
            ps.setString(1,sm.getName());
            ps.setInt(2,sm.getAge());
            ps.setInt(3,sm.getPhone());
            ps.setString(4,sm.getEmail());
            ps.execute();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    @Override
    public int delete(String name)
    {
        Connection con = getCon();
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM `StudentModel` WHERE name = ?");
            ps.setString(1,name);
            ps.execute();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    @Override
     public int update(StudentModel sm)
    {
        Connection con = getCon();
         
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE `StudentModel` SET `name`=?,`age`=?,`phone`=?,`email`=? WHERE name = ?");
            ps.setString(1, sm.getName());
            ps.setString(2, Integer.toString(sm.getAge()));
            ps.setString(3, Integer.toString(sm.getPhone()));
            ps.setString(4, sm.getEmail());
            ps.setString(5, sm.getName());
            ps.execute();
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    @Override
    public List<StudentModel> selectAll()
    {
       
        List<StudentModel> t = new LinkedList<StudentModel>();
        Connection con = getCon();
        try {
            Statement stt = con.createStatement();
            ResultSet rs = stt.executeQuery("Select * from StudentModel");
            String name,email;
            int age,phone;
            while(rs.next())
            {
                StudentModel sm = new StudentModel();
                name = rs.getString(1);
                age = rs.getInt(2);
                phone = rs.getInt(3);
                email = rs.getString(4);
                sm.setName(name);
                sm.setAge(age);
                sm.setPhone(phone);
                sm.setEmail(email);
                t.add(sm);
            }
            return t;
        } catch (SQLException ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
            return t;
        }
    }
    
    @Override
    public List<StudentModel> select(String sname)
    {
        
        List<StudentModel> t = new LinkedList<StudentModel>();
        Connection con = getCon();
        try {
            PreparedStatement ps = con.prepareStatement("Select * from StudentModel where name = ?");
            ps.setString(1,sname);
            ResultSet rs = ps.executeQuery();
            String name,email;
            int age,phone;
            while(rs.next())
            {
                StudentModel sm = new StudentModel();
                name = rs.getString("name");
                age = rs.getInt("age");
                phone = rs.getInt("phone");
                email = rs.getString("email");
                
                sm.setName(name);
                sm.setAge(age);
                sm.setPhone(phone);
                sm.setEmail(email);
                t.add(sm);
            }
            return t;
        } catch (SQLException ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
            return t;
        }
    }
}
