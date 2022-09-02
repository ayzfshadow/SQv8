package saki.client;

import saki.qq.datapacket.pack.send.SendPack;
import saki.qq.datapacket.pack.send.GrayUinPro_Check;

class mark8_classc extends Thread {
    SendPack a;
    int b;
    final /* synthetic */ mark8_classa c;

    public mark8_classc(mark8_classa mark8_classa, SendPack mark18_classao, int i) {
        this.c = mark8_classa;
        this.a = mark18_classao;
        this.b = i;
    }

    public void run() {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= this.b) {
                break;
            }
            this.c.b(this.a);
            try {
                Thread.sleep(5000);
                i = i2;
            } catch (InterruptedException e) {
                return;
            }
        }
        if (this.a instanceof GrayUinPro_Check) {
            this.c.b.a(5, (byte[]) null);
        }
    }
}
