package app01.myandroid1;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义Application
 * Created by zhaofuqiang on 2016/8/10.
 */
public class App extends Application{

    List<Course> clist=new ArrayList<Course>();
    //所有activity集合
    List<AppCompatActivity> appList=new ArrayList<AppCompatActivity>();
    @Override
    public void onCreate() {
        super.onCreate();
        //Toast.makeText(getApplicationContext(),"----APP----",Toast.LENGTH_SHORT).show();
        clist.add(new Course("这是一本书",1,"张老师"));
        clist.add(new Course("这是一门课",2,"王老师"));
        clist.add(new Course("这是一朵花",3,"刘老师"));
    }




    }
