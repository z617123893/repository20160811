package app01.myandroid1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 *查看学生信息
 */
public class Activity_Cxjg2 extends AppCompatActivity {
TextView textView;
    List<Course> clist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__cxjg);
        //将Activity加入到集合
        ((App)getApplication()).appList.add(this);
        //所有课程信息
        clist=((App)getApplication()).clist;
        textView=(TextView) findViewById(R.id.kctxt);
        Intent intent=getIntent();
        //获取到的学生姓名
        String name=intent.getStringExtra("name");
        //获取到的学生选课列表
        List<Course> list=selectStu(name);

        String str="0";
        for(int i=0;i<list.size();i++){
            Course c=list.get(i);
            str+=c.getCourseName()+",";
        }

        textView.setText(name+"同学:已选课程为--"+str);

    }

    /**
     * 根据姓名查询学生所选课程
     * @param stuName
     * @return
     */
    public List<Course> selectStu(String stuName){
        //学生所选的课程
        List<Course> selectCourse=new ArrayList<>();
        //遍历所有的课程
        for(int i=0;i<clist.size();i++){
            //取得每个课程的学生列表
            List<Student> studentList=clist.get(i).getStudentList();
            //判断此学生是否选课
            for(int j=0;j<studentList.size();j++){
                if(studentList.get(j).getStuName().equals(stuName)){
                    //添加课程到list
                    selectCourse.add(clist.get(i));
//退出
                    break;
                }

            }

        }

        return selectCourse;
    }



}
