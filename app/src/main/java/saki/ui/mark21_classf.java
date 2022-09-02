package saki.ui;

import android.os.Handler;
import android.os.Message;

class mark21_classf extends Handler {
    final /* synthetic */ MessageActivity a;

    mark21_classf(MessageActivity messageActivity) {
        this.a = messageActivity;
    }

    public void handleMessage(Message message) {
        this.a.f.setText("");
        this.a.e.setEnabled(false);
    }
}
