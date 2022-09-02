package saki.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import saki.client.SQService;

class mark21_classh extends Handler {
    final /* synthetic */ PagerActivity a;

    mark21_classh(PagerActivity pagerActivity) {
        this.a = pagerActivity;
    }

    public void handleMessage(Message message) {
        Toast.makeText(this.a, "您的账号已在其他设备登录", 1).show();
        this.a.stopService(new Intent(this.a, SQService.class));
        this.a.finish();
    }
}
