package org.qingqiao.dao;

import org.qingqiao.bean.Clazz;
import org.qingqiao.bean.Student;
import org.qingqiao.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 数据控制 负责和数据库进行交互(增删改查)
public class StudentDao {

    // 查询所有学生数据
    public List<Student> queryAll(){
        ArrayList<Student> list = new ArrayList<>();
        try {
            // 使用工具类获取连接
            Connection conn = JDBCUtil.getConn();
            // 编写sql语句
            String sql = "select s.*,c.name cname from student s left join clazz c on s.cid = c.id";
            // 创建预编译对象
            PreparedStatement ps = conn.prepareStatement(sql);
            // 执行sql语句
            ResultSet rs = ps.executeQuery();
            // 处理结果集
            while(rs.next()){
                Clazz clazz = new Clazz(rs.getInt(7),rs.getString(8));
                Student student = new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getDouble(6),clazz);
                list.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    // 查询所有班级数据
    public List<Clazz> queryAllClazz(){
        ArrayList<Clazz> list = new ArrayList<>();
        try {
            // 使用工具类获取连接
            Connection conn = JDBCUtil.getConn();
            // 编写sql语句
            String sql = "select * from clazz";
            // 创建预编译对象
            PreparedStatement ps = conn.prepareStatement(sql);
            // 执行sql语句
            ResultSet rs = ps.executeQuery();
            // 处理结果集
            while(rs.next()){
                Clazz clazz = new Clazz(rs.getInt(1),rs.getString(2));
                list.add(clazz);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    // 添加数据
    public int insertStudent(Student s){
        int i = 0;
        try {
            Connection conn = JDBCUtil.getConn();
            String sql = "insert into student(name,sex,age,address,score,cid) values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,s.getName());
            ps.setString(2,s.getSex());
            ps.setInt(3,s.getAge());
            ps.setString(4,s.getAddress());
            ps.setDouble(5,s.getScore());
            ps.setInt(6,s.getClazz().getId());

            i = ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
}
