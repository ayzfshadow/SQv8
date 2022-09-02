package saki.qq.datapacket.pack.send.packagea;

import java.util.Collections;
import saki.client.mark8_classa;
import saki.client.mark8_classf;
import saki.log.DebugLogger;
import saki.qq.global.ImgStore;
import saki.qq.datapacket.pack.send.MessageSvc_PbSendMsg;

class mark19_classe implements mark8_classf {
    ImgStore a;
    private MessageSvc_PbSendMsg b;
    private mark8_classa c;
    private int d;
    private int e;

    public mark19_classe(mark8_classa mark8_classa, int i, int i2, MessageSvc_PbSendMsg mark18_classt, ImgStore mark12_classe) {
        this.a = mark12_classe;
        this.b = mark18_classt;
        this.c = mark8_classa;
        this.d = i2;
        this.e = i;
    }

    public void a() {
        DebugLogger.a(this, "上传图片");
        if (this.b.d == 2) {
            this.c.a.a(this.b.c, this.a, this);
        }
    }

    public boolean a(ImgStore mark12_classe) {
        if (mark12_classe != this.a) {
            return false;
        }
        this.b.a(new mark19_classb(mark12_classe).a(this.d));
        DebugLogger.a(this, "上传完毕!" + this.b.e.size() + "|" + this.e);
        if (this.b.e.size() == this.e) {
            DebugLogger.a(this, "发送消息");
            Collections.sort(this.b.e);
            this.c.b(this.b);
        }
        return true;
    }
}
