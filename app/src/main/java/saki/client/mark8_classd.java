package saki.client;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

public class mark8_classd implements Thread.UncaughtExceptionHandler {
    private static mark8_classd c;
    private Thread.UncaughtExceptionHandler a;
    private Context b;

    public static mark8_classd a() {
        if (c == null) {
            c = new mark8_classd();
        }
        return c;
    }

    private void a(String str) {
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/SQ/log/" + System.currentTimeMillis() + ".log");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
        }
    }

    public void a(long j) {
        Log.e("SQ Crash", String.valueOf(j) + "ms 后退出程序!");
        if (j != 0) {
            try {
                Thread.sleep(j);
            } catch (InterruptedException e) {
                Log.e("SQ Crash", "error :", e);
            }
        }
        Process.killProcess(Process.myPid());
        System.exit(0);
    }

    public void a(Context context) {
        this.b = context;
        this.a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (th == null && this.a != null) {
            this.a.uncaughtException(thread, th);
        }
        if (th != null) {
            th.printStackTrace();
            StringBuilder sb = new StringBuilder();
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            printWriter.close();
            sb.append("\r\n" + stringWriter.toString() + "\r\n");
            a(sb.toString());
            return;
        }
        a(3000);
    }
}
