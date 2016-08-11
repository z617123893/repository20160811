package app01.myandroid1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * 课程信息
 * @author zhaofuqiang
 */
public class Activity_Kcxx extends AppCompatActivity implements AdapterView.OnItemClickListener{
//适配器对象
    private BaseAdapter baseAdapter;
    private ListView listView;
    //导入布局
    LayoutInflater layoutInflater;
    //课程列表
    List<Course> clist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__kcxx);
        //将Activity加入到集合
        ((App)getApplication()).appList.add(this);
        //导入布局
        layoutInflater=this.layoutInflater;
        //获取listview
       ListView listView=(ListView) findViewById(R.id.kclist);
        //获得application中的数据集合
        clist= ((App)getApplication()).clist;
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
                //取得list中课程对象
                Course course=clist.get(i);
                //指定布局显示内容
                View view1=getLayoutInflater().inflate(R.layout.course_layout,null);
                //课程id
                TextView cid=(TextView) view1.findViewById(R.id.cid);
                cid.setText(course.getCourseId()+"");
                //课程名称
                TextView cname=(TextView) view1.findViewById(R.id.cname);
                cname.setText(course.getCourseName());
                //老师名称
                TextView tname=(TextView) view1.findViewById(R.id.tname);
                tname.setText(course.getTeacherName());
                //已选人数
                TextView cnum=(TextView) view1.findViewById(R.id.cnum);
                cnum.setText(course.getStudentList().size()+"");

                return view1;
            }
        };
        //为listview设置适配器
listView.setAdapter(baseAdapter);
        listView.setOnItemClickListener(this);
    }

    /**
     * 点击课程列表查看课程信息
     * @param adapterView
     * @param view
     * @param i
     * @param l
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Course course=clist.get(i);
        //点击课程跳转到查询结果
        Intent intent=new Intent(Activity_Kcxx.this,Activity_Cxjg.class);
        intent.putExtra("course",course);
        //开启Activity
        startActivity(intent);


    }

}
