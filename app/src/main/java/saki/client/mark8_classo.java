package saki.client;

import java.io.IOException;
import java.io.InputStream;

class mark8_classo extends Thread {
    InputStream a;
    final /* synthetic */ SQSocket b;

    public mark8_classo(SQSocket mark8_classn, InputStream inputStream) {
        this.b = mark8_classn;
        this.a = inputStream;
    }

    public void run() {
        while (true) {
            try {
                this.b.unpack(this.b.a(this.a));
            } catch (IOException e) {
                this.b.a(e);
                return;
            }
        }
    }
}
