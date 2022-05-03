package org.qingqiao.main;

import org.qingqiao.bean.Student;
import org.qingqiao.dao.StudentDao;

import java.util.List;

public class JDBCMain {

    public static void main(String[] args) {
        // 实例化StudentDao
        StudentDao studentDao = new StudentDao();
        List<Student> students = studentDao.queryAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
