package app01.myandroid1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaofuqiang
 * Created by zhaofuqiang on 2016/8/9.
 */
public class Course implements Serializable{
   private int courseId;
    private String courseName;
    private String teacherName;
    private List<Student> studentList=new ArrayList<Student>();

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Course(String courseName, int courseId, String teacherName) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.teacherName = teacherName;
    }

    /**
     * 学生选课进行添加学生对象
     * @param student
     * @return
     */
    public boolean addStu(Student student){
        //判断学生是否为空
        if(student==null){
            return false;
        }
        //判断学生姓名是否存在
        for(int i=0;i<studentList.size();i++){
            if(studentList.get(i).getStuName().equals(student.getStuName())){
                return false;
            }
        }
        //判断已选人数
        if(studentList.size()>=10){
            return false;
        }
//添加学生
        studentList.add(student);
        return true;

    };

}
