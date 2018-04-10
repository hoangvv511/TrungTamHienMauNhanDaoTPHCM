package fighting.teamlego.trungtamhienmaunhandaotphcm;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    ImageView imageView_splash;
    Animation fromtop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imageView_splash = (ImageView) findViewById(R.id.imv_splash);

        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);

        imageView_splash.setAnimation(fromtop);
        final Intent intent = new Intent(this, MainActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000 );

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
                timer.start();
    }
}
