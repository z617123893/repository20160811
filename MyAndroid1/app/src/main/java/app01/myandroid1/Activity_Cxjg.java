package app01.myandroid1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 *查看课程结果
 */
public class Activity_Cxjg extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__cxjg);
        //将Activity加入到集合
        ((App)getApplication()).appList.add(this);
        textView=(TextView) findViewById(R.id.kctxt);
        Intent intent=getIntent();
        Course cource=(Course)intent.getSerializableExtra("course");
        int num=cource.getStudentList().size();
        int num2=20-num;
        textView.setText(cource.getCourseName()+"任课老师为"+cource.getTeacherName()+"。现有学生"+num+"人，还可以选修"+num2+"人");
    }

}
