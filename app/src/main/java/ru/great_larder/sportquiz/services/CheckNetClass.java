package ru.great_larder.sportquiz.services;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import androidx.annotation.IntRange;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class CheckNetClass {
    boolean out;
    @IntRange(from = 0, to = 3)
    public int getConnectionType(Context context) {
        int result = 0; //Возвращает тип соединения. 0: нет; 1: мобильные данные; 2: Wi-Fi; 3: VPN
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkCapabilities capabilities = cm.getNetworkCapabilities(cm.getActiveNetwork());
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        result = 2;
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        result = 1;
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN)) {
                        result = 3;
                }
            }
        }
        return result;
    }
    public Single<Boolean> isInternetAvailable() {
        return  Single.fromCallable(()->{
            try {
                //int timeoutMs = 500;
                Socket socket = new Socket();
                InetSocketAddress socketAddress = new InetSocketAddress("8.8.8.8", 53);
                
                socket.connect(socketAddress/*, timeoutMs*/);
                socket.close();
                return true;
            } catch (IOException e) {
                return false;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
