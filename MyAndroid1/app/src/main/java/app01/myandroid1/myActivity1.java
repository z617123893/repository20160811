package app01.myandroid1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * 首页
 * @author zhaofuqiang
 */
public class myActivity1 extends AppCompatActivity {
    Intent intent=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
//将Activity加入到集合
        ((App)getApplication()).appList.add(this);


    }
    public void setLinerClick(View view){
        switch (view.getId()){
            case R.id.l1:
                intent=new Intent(this,Activity_xxkc.class);
                startActivity(intent);
               break;
            case R.id.l2:
                intent=new Intent(this,Activity_Kcxx.class);
                startActivity(intent);
                break;
            case R.id.l3:
                intent=new Intent(this,Activity_Xsxx.class);
                startActivity(intent);
                break;
            case R.id.l4:
                intent=new Intent(this,Activity_kcxx2.class);
                startActivity(intent);
                break;
            case R.id.l5:
                intent=new Intent(this,Bz_activity.class);
                startActivity(intent);
                break;
            case R.id.l6:
                intent=new Intent(this,Activity_tcxt.class);
                startActivity(intent);
                break;



        }

    }

}
