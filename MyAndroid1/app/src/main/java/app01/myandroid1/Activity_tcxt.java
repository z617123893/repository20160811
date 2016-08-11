package app01.myandroid1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class Activity_tcxt extends AppCompatActivity {
   List<AppCompatActivity> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tcxt);
        App app=((App)getApplication());
        list=app.appList;
        list.add(this);
        Button button=(Button)findViewById(R.id.exit);
        //退出
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<list.size();i++){
                    list.get(i).finish();
                }

            }
        });
    }

}
