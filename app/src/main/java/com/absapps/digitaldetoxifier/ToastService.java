package com.absapps.digitaldetoxifier;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

public class ToastService extends Service {

    String TAG = ">>>>>>>>>>>>>>>>>>";

    public ToastService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("aa","aa");
        return null;
    }

    private final static int INTERVAL = 1000 * 60 * 5;
    Handler mHandler = new Handler();

    Runnable mHandlerTask = new Runnable() {
        @Override
        public void run() {
            mHandler.postDelayed(mHandlerTask, INTERVAL);
            String Text = "take some rest...";
            ShowToast(Text);
            ShowCoountDownToast();
            //mHandler.postDelayed(mHandlerTask, INTERVAL);
        }
    };

    private void ShowCoountDownToast() {
        ShowToast("5.....");
        ShowToast("4....");
        ShowToast("3...");
        ShowToast("2..");
        ShowToast("1.");
        ShowToast("Go!");
    }

    void startRepeatingTask() {
        mHandlerTask.run();
    }

    void stopRepeatingTask() {
        mHandler.removeCallbacks(mHandlerTask);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "start");
        //Sleep(INTERVAL);
        startRepeatingTask();
        return 0;
    }

    public void ShowToast(final String ToastText) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), ToastText, Toast.LENGTH_SHORT).show();
                }
            });
    }

    public void Sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
