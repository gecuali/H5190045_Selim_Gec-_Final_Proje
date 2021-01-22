package com.h5190045.selim_gecu_final.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {
    //Kullanıcının internete bağlı olup olmadığını kontrol eder
    public  static  boolean checkInternetConnection(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null && networkInfo.isAvailable() && networkInfo.isConnected())
        {
            return  true;
        }
        else
        {
            return  false;
        }

    }
}
