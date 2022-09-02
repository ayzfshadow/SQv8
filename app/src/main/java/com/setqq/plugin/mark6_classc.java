package com.setqq.plugin;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.saki.aidl.AppInterface;

public class mark6_classc implements ServiceConnection {
    AppInterface a;
    String b;
    String c;
    String d;
    private Context e;

    public mark6_classc(Context context, String str, String str2, String str3) {
        this.e = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public AppInterface a() {
        return this.a;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a = AppInterface.Stub.asInterface(iBinder);
        if (this.a != null) {
            new mark6_classa(this.e, this.c, this.b, this.d, this);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
