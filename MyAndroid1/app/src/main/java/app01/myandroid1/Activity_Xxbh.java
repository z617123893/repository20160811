package app01.myandroid1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaofuqiang
 * 选课列表
 */
public class Activity_Xxbh extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView listView;
    Button button;
    //课程列表
    List<Course> clist;
    LayoutInflater layoutInflater;
Student student;
//适配器
    BaseAdapter baseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__xxbh);
        //将Activity加入到集合
        ((App)getApplication()).appList.add(this);
        button=(Button)findViewById(R.id.xxbhbut);
        //添加课程
        listView=(ListView)findViewById(R.id.list);

//
        layoutInflater=this.getLayoutInflater();

//获取自定义application中的数据源
        clist= ((App)getApplication()).clist;
        //获取学生信息
Intent intent=getIntent();
        student=(Student) intent.getSerializableExtra("stu");
        Toast.makeText(Activity_Xxbh.this,student.getStuName(),Toast.LENGTH_SHORT).show();
        //适配器
        baseAdapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return clist.size();
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                //获取list中的课程对象
                Course course=clist.get(i);
                //引入布局文件
               View view1= layoutInflater.inflate(R.layout.course_layout,null);
                TextView textView=(TextView) view1.findViewById(R.id.cid);
                textView.setText(course.getCourseId()+"");
                TextView textView2=(TextView) view1.findViewById(R.id.cname);
                textView2.setText(course.getCourseName());
                TextView textView3=(TextView) view1.findViewById(R.id.tname);
                textView3.setText(course.getTeacherName());
                TextView textView4=(TextView) view1.findViewById(R.id.cnum);
                textView4.setText(course.getStudentList().size()+"");

                return view1;
            }
        };
        //设置baseAdapter关联内容
        listView.setAdapter(baseAdapter);
        //设置点击事件
        listView.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(this,"点击le"+i,Toast.LENGTH_SHORT).show();
        Course course= clist.get(i);

        if(course.addStu(student)){
            Toast.makeText(Activity_Xxbh.this,"--选修成功--",Toast.LENGTH_SHORT).show();
            //通知适配器重新加载
            baseAdapter.notifyDataSetChanged();
         }else {
            Toast.makeText(Activity_Xxbh.this,"--您已添加过此课程，无法重复添加--",Toast.LENGTH_SHORT).show();
        }


    }


}
