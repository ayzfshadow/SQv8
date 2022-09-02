package saki.client;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.core.internal.view.SupportMenu;
import com.ayzf.sqv8.R;
import saki.ui.PagerActivity;
import android.os.PowerManager.WakeLock;

public class SQNotification {
    Notification a = new Notification();
    Service b;

    private PowerManager.WakeLock wakeLock;

    public SQNotification(Service service) {
        Builder builder;
        this.b = service;
        Intent intent = new Intent(service, PagerActivity.class);
        intent.setFlags(536870912);
        PendingIntent activity = PendingIntent.getActivity(service, 0, intent, 0);
        if (Build.VERSION.SDK_INT >= 26) {
            String str = "setqq.com.saki.com";
            String string = service.getString(R.string.AppName);
            Builder builder2 = new Builder(service, str);
            NotificationChannel notificationChannel = new NotificationChannel(str, string, 4);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(SupportMenu.CATEGORY_MASK);
            notificationChannel.setShowBadge(true);
            notificationChannel.setLockscreenVisibility(1);
            ((NotificationManager) service.getSystemService("notification")).createNotificationChannel(notificationChannel);
            builder = builder2;
        } else {
            builder = new Builder(service);
        }
        builder.setContentIntent(activity);
        builder.setSmallIcon(R.drawable.qq);
        builder.setContentTitle(service.getResources().getString(R.string.AppName));
        this.a = builder.setContentText("后台运行中").build();
        this.a.flags |= 32;
        
        
        
        
        
    }

    public void start() {
        this.b.startForeground(3027, this.a);
        Log.d("wake","");
        PowerManager pm = (PowerManager)b.getSystemService(Context.POWER_SERVICE);
        this. wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "SQv8Lock");
        wakeLock.acquire();
    }

    public void stop() {
        this.b.stopForeground(true);
        if (wakeLock != null) {
            wakeLock.release();
            wakeLock = null;
        }
    }
    
    
}
