package com.setqq.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.saki.aidl.AppServiceInterface;

public class PluginService extends Service {
    private final AppServiceInterface.Stub a = new mark6_classd(this);

    public IBinder onBind(Intent intent) {
        return this.a;
    }
}
