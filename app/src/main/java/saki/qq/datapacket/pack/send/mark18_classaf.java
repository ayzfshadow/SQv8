package saki.qq.datapacket.pack.send;

import com.qq.taf.jce.JceOutputStream;
import saki.qq.datapacket.pack.packagea.mark16_classg;

public class mark18_classaf extends mark16_classg {
    final /* synthetic */ OnlinePush_RespPush a;
    private long b;
    private int c;
    private byte[] d;

    public mark18_classaf(OnlinePush_RespPush mark18_classad, long j, int i, byte[] bArr) {
        this.a = mark18_classad;
        this.b = j;
        this.c = i;
        this.d = bArr;
    }

    public void writeTo(JceOutputStream mark2_classf) {
        mark2_classf.a(this.b, 0);
        mark2_classf.a(0, 1);
        mark2_classf.a(this.c, 2);
        mark2_classf.a(this.d, 3);
    }
}
