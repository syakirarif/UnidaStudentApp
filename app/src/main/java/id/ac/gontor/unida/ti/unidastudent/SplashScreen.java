package id.ac.gontor.unida.ti.unidastudent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by syakirarifu on 10/27/2016.
 */

public class SplashScreen extends Activity {

    //lama tayang splah screen
    private static int splashInterval = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), WelcomeActivity.class);
                startActivity(i);
                //this.finish();
            }

            //private void finish() {
            //}
        }, splashInterval);
    };
}
