package saki.qq.datapacket.pack.send;

import saki.qq.datapacket.pack.ByteWriter;
import saki.qq.datapacket.pack.packageb.Protobuff;

public class OidbSvc_0x8a0_0 extends T0B01 {
    private long a;
    private long b;

    public OidbSvc_0x8a0_0(int i, long j, long j2) {
        super("OidbSvc.0x8a0_0");
        setSeq(i);
        this.a = j2;
        this.b = j;
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeBytes(Protobuff.writeVarint(1, 5));
        mark15_classa.writeBytes(Protobuff.writeVarint(2, this.a));
        mark15_classa.writeBytes(Protobuff.writeVarint(3, 0));
        byte[] a2 = mark15_classa.getDataAndDestroy();
        mark15_classa.recreate();
        mark15_classa.writeBytes(Protobuff.writeVarint(1, this.b));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(2, a2));
        byte[] a3 = mark15_classa.getDataAndDestroy();
        mark15_classa.recreate();
        mark15_classa.writeBytes(Protobuff.writeVarint(1, 2208));
        mark15_classa.writeBytes(Protobuff.writeVarint(2, 0));
        mark15_classa.writeBytes(Protobuff.writeVarint(3, 0));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(4, a3));
        return mark15_classa.getDataAndDestroy();
    }
}
