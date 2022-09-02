package saki.ui.packagea;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;

class mark22_classe extends Handler {
    final /* synthetic */ mark22_classb a;

    mark22_classe(mark22_classb mark22_classb) {
        this.a = mark22_classb;
    }

    public void a(int i, Bitmap bitmap) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        obtain.obj = bitmap;
        sendMessage(obtain);
    }

    public void a(mark22_classd mark22_classd) {
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = mark22_classd;
        sendMessage(obtain);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 0:
                this.a.a((mark22_classd) message.obj);
                return;
            case 1:
                this.a.a(message.arg1, (Bitmap) message.obj);
                return;
            default:
                return;
        }
    }
}
