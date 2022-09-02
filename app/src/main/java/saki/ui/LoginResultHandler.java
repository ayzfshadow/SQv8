package saki.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;
import saki.client.packagea.mark9_classa;
import saki.qq.global.mark12_classc;
import saki.ui.packageb.mark23_classa;

class LoginResultHandler extends Handler implements mark23_classa {
    SimpleDateFormat a;
    /* access modifiers changed from: package-private */
    public final /* synthetic */ LoginActivity b;

    private LoginResultHandler(LoginActivity loginActivity) {
        this.b = loginActivity;
        this.a = new SimpleDateFormat("yyyy年MM月dd");
    }

    /* synthetic */ LoginResultHandler(LoginActivity loginActivity, LoginResultHandler mark21_classd) {
        this(loginActivity);
    }

    /* access modifiers changed from: private */
    public void a(int i, Object obj) {
        Message message = new Message();
        message.what = i;
        message.obj = obj;
        sendMessage(message);
    }

    public void a(int i, byte[] bArr) {
        Message message = new Message();
        message.what = i;
        message.obj = bArr;
        sendMessage(message);
    }

    public void a(String str, boolean z) {
        new mark21_classe(this, str, z).start();
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                this.b.c();
                return;
            case 1:
                this.b.a();
                return;
            case 2:
                this.b.showChaptcha((byte[]) message.obj);
                return;
			case -2:
                this.b.requireDeviceUnlock(new String((byte[])(message.obj)));
                return;
			case -3:
                this.b.requireDeviceUnlockCode();
                return;
			case -4:
                this.b.requireDeviceUnlockCodeAgain();
                return;
            case 3:
                this.b.a(new String((byte[]) message.obj));
                return;
            case 4:
                long parseLong = Long.parseLong(new String((byte[]) message.obj));
                if (parseLong == Long.MAX_VALUE) {
                    
                    return;
                }
                if (parseLong > 0) {
                    
                    if (parseLong <= System.currentTimeMillis()) {
                        Toast.makeText(this.b, "授权已到期", 0).show();
                    } else {
                        return;
                    }
                } else if (parseLong == -1) {
                    
                } else if (parseLong == 0) {
                    
                }
                this.b.a((String) null);
                return;
            case 5:
                this.b.startService(mark9_classa.a((Context) this.b, mark12_classc.c, mark12_classc.d, true));
                return;
            case 6:
                this.b.a((Bitmap) message.obj);
				return;
			case 7:
                this.b.toast( new String((byte[])message.obj));
                return;
            default:
                return;
        }
    }
}
