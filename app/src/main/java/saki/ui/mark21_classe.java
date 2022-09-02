package saki.ui;

import android.graphics.Bitmap;
import com.setqq.packagea.mark5_classa;
import saki.packaged.mark20_classc;

class mark21_classe extends Thread {
    final /* synthetic */ LoginResultHandler a;
    private final /* synthetic */ String b;
    private final /* synthetic */ boolean c;

    mark21_classe(LoginResultHandler mark21_classd, String str, boolean z) {
        this.a = mark21_classd;
        this.b = str;
        this.c = z;
    }

    public void run() {
        Bitmap a2 = mark20_classc.a(this.b, this.c);
        if (a2 != null) {
            this.a.a(6, (Object) a2);
        }
        this.a.a(4, (Object) String.valueOf(mark5_classa.a(this.a.b, Long.parseLong(this.b))).getBytes());
    }
}
