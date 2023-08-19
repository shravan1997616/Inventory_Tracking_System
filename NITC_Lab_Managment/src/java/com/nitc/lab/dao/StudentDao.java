
package com.nitc.lab.dao;
import com.nitc.lab.entities.Student;
import java.sql.*;
public class StudentDao {
    private Connection con;

    public StudentDao(Connection con) {
        this.con = con;
    }
    
    // method to insert user to data base
    
    public boolean saveStudent(Student student){
        boolean f=false;
        try{
            String query = "insert into student(id,pass,name,email) values (?,?,?,?)";
            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setString(1, student.getId());
            pstmt.setString(2, student.getPass());
            pstmt.setString(3, student.getName());
            pstmt.setString(4, student.getEmail());
       
            pstmt.executeUpdate();
            f = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
    
    public Student getStudentIdAndPassword(String id, String pass) {
        Student user = null;

        try {

            String query = "select * from student where id =? and pass=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, pass);

            ResultSet set = pstmt.executeQuery();

            if (set.next()) {
                user = new Student();

//             data from db
                String name = set.getString("name");
//             set to user object
                user.setName(name);

                user.setId(set.getString("id"));
                user.setPass(set.getString("pass"));
                user.setEmail(set.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
