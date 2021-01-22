package com.h5190045.selim_gecu_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.util.Log;

import com.h5190045.selim_gecu_final.R;
import com.h5190045.selim_gecu_final.util.NetworkUtil;

public class SplashActivity extends AppCompatActivity { //Bu dosya Splash ekranıdır

    Context context = this;
    NetworkUtil networkUtil;

    //Aşağıdaki metod, başlangıçta çalışan metoddur ve layout olarak activity_splash.xml set edilmiştir
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }

    //Aşağıdaki fonksiyon 3 saniyelik bir sayaç başlatır. Bu sırada internet kontrolü yapılır.
    //3 saniye sonunda internet bağlı ise e1 ekranı ölür ve e2 ekranı açılır.
    //3 saniye sonunda internet bağlı değil ise, kullanıcının karşısına alert dialog çıkartılır
    private void init() {
        if (checkConnection()) {
            CountDownTimer countDownTimer = new CountDownTimer(3000, 1000) {
                @Override
                public void onTick(long l) {

                    Log.e("COUNTER", "TİCK");
                }

                @Override
                public void onFinish() {
                    openNextActivity();
                }
            };
            countDownTimer.start();
        } else {
            openInternetAlertDialog();
        }


    }

    private void openNextActivity() { //2. ekrana gider

        Intent secondActivityIntent=new Intent(getApplicationContext(),ListActivity.class);
        startActivity(secondActivityIntent);
        finish();

    }

    boolean checkConnection() { //İnternete bağlı olup olmadığını sorgular
        if (networkUtil.checkInternetConnection(this)) {
            return true;
        } else {
            return false;
        }

    }

    private void openInternetAlertDialog() { //İnternet ayarlarına gitme uyarısını gösterir
        AlertDialog.Builder internetAlert = new AlertDialog.Builder(context);
        internetAlert.setTitle(getString(R.string.not_connected_title));
        internetAlert.setMessage(getString(R.string.not_connected_message));
        internetAlert.setPositiveButton(getString(R.string.not_connected_positive_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                startActivityForResult(intent, 0);
                finishAffinity();
                System.exit(0);
            }
        });
        internetAlert.setNegativeButton(getString(R.string.not_connected_negative_button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
                System.exit(0);
            }
        });
        internetAlert.show();
    }

}