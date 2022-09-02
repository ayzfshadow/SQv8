package saki.qq.datapacket.pack.send;

import saki.qq.datapacket.pack.ByteWriter;
import saki.qq.datapacket.pack.packageb.Protobuff;

public class OidbSvc_0x570_8 extends T0B01 {
    private long a;
    private long b;
    private int c;

    public OidbSvc_0x570_8(int i, long j, long j2, int i2) {
        super("OidbSvc.0x570_8");
        setSeq(i);
        this.a = j;
        this.b = j2;
        this.c = i2;
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeInt(this.a);
        mark15_classa.writeByte(32);
        mark15_classa.writeShort(1);
        mark15_classa.writeInt(this.b);
        mark15_classa.writeInt(this.c);
        byte[] a2 = mark15_classa.getDataAndDestroy();
       mark15_classa.recreate();
        mark15_classa.writeBytes(Protobuff.writeVarint(1, 1392));
        mark15_classa.writeBytes(Protobuff.writeVarint(2, 8));
        mark15_classa.writeBytes(Protobuff.writeVarint(3, 0));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(4, a2));
        return mark15_classa.getDataAndDestroy();
    }
}
