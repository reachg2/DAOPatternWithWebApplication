import java.sql.Connection;
import java.util.List;

public interface StudentDAO {
    public Connection getCon();
    public int insert(StudentModel sm);
    public int delete(String name);
    public int update(StudentModel sm);
    public List<StudentModel> selectAll();
    public List<StudentModel> select(String sname);
}
