package saki.client;

import android.content.Intent;

class mark8_classl extends Thread {
    final /* synthetic */ SQService a;
    private final /* synthetic */ Intent b;

    mark8_classl(SQService sQService, Intent intent) {
        this.a = sQService;
        this.b = intent;
    }

    public void run() {
        this.a.a(this.b);
    }
}
