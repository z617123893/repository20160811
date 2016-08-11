package app01.myandroid1;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * 学生信息
 */
public class Activity_Xsxx extends AppCompatActivity {
Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity__xsxx);
        //将Activity加入到集合
        ((App)getApplication()).appList.add(this);
        //获取控件
        button=(Button)findViewById(R.id.xsBut);
        //获取控件
        editText=(EditText)findViewById(R.id.name);
        //设置点击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String name= editText.getText().toString().trim();
                if(name!=null&&name!=""){

                    Intent intent=new Intent(Activity_Xsxx.this,Activity_Cxjg2.class);
                    intent.putExtra("name",name);

                    startActivity(intent);
                }

            }
        });
    }


    }
