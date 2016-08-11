package app01.myandroid1;

import java.io.Serializable;

/**
 * @author zhaofuqiang
 * Created by zhaofuqiang on 2016/8/9.
 */
public class Student implements Serializable{
    private String stuName;
    private int sex;//学生性别 0男1女
    private int age;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Student(int age, int sex, String stuName) {
        this.age = age;
        this.sex = sex;
        this.stuName = stuName;
    }
}
