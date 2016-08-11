package app01.myandroid1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Activity_xxtj extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xxtj);
        //将Activity加入到集合
        ((App)getApplication()).appList.add(this);

    }

}
