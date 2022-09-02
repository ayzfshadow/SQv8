package saki.ui.packagea;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import saki.qq.datapacket.pack.packagea.mark16_classe;

class mark22_classz extends Handler {
    final /* synthetic */ GroupListViewAdapter a;

    mark22_classz(GroupListViewAdapter mark22_classw) {
        this.a = mark22_classw;
    }

    public void a(long j) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = Long.valueOf(j);
        sendMessage(obtain);
    }

    public void a(long j, Bitmap bitmap) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = new mark22_classaa(this, j, bitmap);
        sendMessage(obtain);
    }

    public void a(mark16_classe mark16_classe) {
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = mark16_classe;
        sendMessage(obtain);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 0:
                this.a.b((mark16_classe) message.obj);
                return;
            case 1:
                boolean unused = this.a.c(((Long) message.obj).longValue());
                return;
            case 2:
                mark22_classaa mark22_classaa = (mark22_classaa) message.obj;
                boolean unused2 = this.a.b(mark22_classaa.a, mark22_classaa.b);
                return;
            default:
                return;
        }
    }
}
