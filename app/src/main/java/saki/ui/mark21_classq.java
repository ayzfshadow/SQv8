package saki.ui;

import android.os.Message;

class mark21_classq extends mark21_classc {
    final /* synthetic */ LogView a;

    mark21_classq(LogView mark21_classp) {
        this.a = mark21_classp;
    }

    public void a(int i, Object obj) {
        sendMessage(Message.obtain(this, 0, new mark21_classr(i, obj.toString())));
    }

    public void handleMessage(Message message) {
        this.a.b.a((mark21_classr) message.obj);
    }
}
