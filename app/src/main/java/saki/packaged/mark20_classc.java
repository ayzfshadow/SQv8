package saki.packaged;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class mark20_classc {
    public static final String a = (Environment.getExternalStorageDirectory() + "/SetQQ/cache/");

    private static Bitmap a(String str) {
        return b(String.valueOf(a) + "face/" + str + ".png");
    }

    public static Bitmap a(String str, boolean z) {
        Bitmap bitmap = null;
        if (z) {
            bitmap = a(str);
        }
        return bitmap == null ? d(str) : bitmap;
    }

    public static void a(String str, int i, mark20_classb mark20_classb) {
        new Thread(new mark20_classd(i, mark20_classb, str)).start();
    }

    private static void a(String str, byte[] bArr) {
        b("face/" + str + ".png", bArr);
    }

    private static Bitmap b(String str) {
        File file = new File(String.valueOf(a) + str);
        if (file.exists()) {
            try {
                return BitmapFactory.decodeStream(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Bitmap b(String str, boolean z) {
        Bitmap bitmap = null;
        if (z) {
            bitmap = c(str);
        }
        return bitmap == null ? e(str) : bitmap;
    }

    private static void b(String str, byte[] bArr) {
        File file = new File(String.valueOf(a) + str);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                return;
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private static Bitmap c(String str) {
        return b(String.valueOf(a) + "logo/" + str + ".png");
    }

    private static void c(String str, byte[] bArr) {
        b("logo/" + str + ".png", bArr);
    }

    private static Bitmap d(String str) {
        byte[] a2 = mark20_classf.a("http://q2.qlogo.cn/headimg_dl?dst_uin=" + str + "&spec=100");
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(a2, 0, a2.length);
        if (decodeByteArray == null) {
            return null;
        }
        a(str, a2);
        return decodeByteArray;
    }

    private static Bitmap e(String str) {
        byte[] a2 = mark20_classf.a("http://p.qlogo.cn/gh/" + str + "/" + str + "/40?t=" + System.currentTimeMillis());
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(a2, 0, a2.length);
        if (decodeByteArray == null) {
            return null;
        }
        c(str, a2);
        return decodeByteArray;
    }
}
