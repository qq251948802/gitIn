package in.mango.com.in;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        try {
            PackageManager pm = this.getPackageManager();
            ApplicationInfo appInfo = pm.getApplicationInfo(this.getPackageName(), PackageManager.GET_META_DATA);
            String channel=appInfo.metaData.getString("APP_CHANNEL_KEY");
            Toast.makeText(this,channel+"=="+BuildConfig.APP_TYPE,Toast.LENGTH_LONG).show();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
