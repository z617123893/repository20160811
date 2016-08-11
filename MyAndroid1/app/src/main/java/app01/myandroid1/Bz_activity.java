package app01.myandroid1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 帮助
 */
public class Bz_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bz);
        //将Activity加入到集合
        ((App)getApplication()).appList.add(this);
        TextView textView=(TextView) findViewById(R.id.text1);
        textView.setText("需要帮助请联系010-12345或访问我们的永久网址www.jige666.com");
    }

}
