package org.qingqiao.main;

import org.qingqiao.bean.Clazz;
import org.qingqiao.bean.Student;
import org.qingqiao.dao.StudentDao;

import java.util.List;
import java.util.Scanner;

public class JDBCMain {
    // 实例化StudentDao
    static StudentDao studentDao = new StudentDao();
    // 实例化Scanner
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // insert();
        // update();
        // queryall();
    }

    private static void queryall(){
        List<Student> students = studentDao.queryAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void insert(){
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

    private static void update(){
        System.out.println("请输入学生编号");
        int id = sc.nextInt();
        // 为了回显,需要根据id查询数据
        Student oldstudent = studentDao.queryStudentById(id);
        System.out.println(oldstudent);
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
        Student newStudent = new Student(id, name, sex, age, address, score, new Clazz(cid, "只要是个字符串就行"));
        int i = studentDao.updateStudent(newStudent);
        if(i > 0){
            System.out.println("修改成功");
        }
    }
}
