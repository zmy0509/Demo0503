package org.qingqiao.main;

import org.qingqiao.bean.Clazz;
import org.qingqiao.bean.Student;
import org.qingqiao.dao.StudentDao;

import java.util.List;
import java.util.Scanner;

public class JDBCMain {
    // 实例化StudentDao
    static StudentDao studentDao = new StudentDao();

    public static void main(String[] args) {
        // insert();
        queryall();
    }

    private static void queryall(){
        List<Student> students = studentDao.queryAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void insert(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名");
        String name = sc.next();
        System.out.println("请输入性别");
        String sex = sc.next();
        System.out.println("请输入年龄");
        int age = sc.nextInt();
        System.out.println("请输入地址");
        String address = sc.next();
        System.out.println("请输入成绩");
        double score = sc.nextDouble();
        // 调用查询所有班级信息
        List<Clazz> clazzes = studentDao.queryAllClazz();
        System.out.println(clazzes);
        System.out.println("请输入班级");
        int cid = sc.nextInt();
        Student student = new Student(0, name, sex, age, address, score, new Clazz(cid, "只要是个字符串就行"));
        int i = studentDao.insertStudent(student);
        if(i > 0){
            System.out.println("添加成功");
        }
    }
}
