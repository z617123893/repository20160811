package app01.myandroid1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Activity_xxkc extends AppCompatActivity {
    Button button;
    EditText editText;
    EditText editText2;
    RadioButton boy;
    RadioButton gril;
  Student student=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xxkc);
        //将Activity加入到集合
        ((App)getApplication()).appList.add(this);
        button = (Button) findViewById(R.id.kcbut);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( createStu()!=null){
                    Intent intent = new Intent(Activity_xxkc.this, Activity_Xxbh.class);
                    intent.putExtra("stu",student);
                    startActivity(intent);
                }

            }
        });

    }

    /**
     * 创建学生对象
     * @return
     */
    public Student createStu(){
        editText = (EditText) findViewById(R.id.name);//姓名
        String name = editText.getText().toString().trim();
        editText2 = (EditText) findViewById(R.id.age);//年龄
        String age = editText2.getText().toString().trim();
        int myage=0;
        try {
            myage = Integer.parseInt(age);
        } catch (NumberFormatException e) {
            myage = 0;
        };


        //性别
        boy = (RadioButton) findViewById(R.id.boy);
        gril = (RadioButton) findViewById(R.id.gril);
        //学生性别 0男1女
        int sex;
        if (boy.isChecked()) {
            sex = 0;
        } else {
            sex = 1;
        }

            return  student=new Student(myage,sex,name);

    }

}
