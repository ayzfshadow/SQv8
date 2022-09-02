package saki.qq.datapacket.pack.send;

import saki.qq.datapacket.pack.ByteWriter;
import saki.qq.datapacket.pack.packageb.Protobuff;

public class OidbSvc_Ox89a_0 extends T0B01 {
    private long a;
    private boolean b;

    public OidbSvc_Ox89a_0(int i, long j, boolean z) {
        super("OidbSvc.0x89a_0");
        setSeq(i);
        this.a = j;
        this.b = z;
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeBytes(Protobuff.writeVarint(1, this.a));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(2, Protobuff.writeVarint(17, (long) (this.b ? 268435455 : 0))));
        byte[] a2 = mark15_classa.getDataAndDestroy();
       mark15_classa.recreate();
        mark15_classa.writeBytes(Protobuff.writeVarint(1, 2202));
        mark15_classa.writeBytes(Protobuff.writeVarint(2, 0));
        mark15_classa.writeBytes(Protobuff.writeVarint(3, 0));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(4, a2));
        return mark15_classa.getDataAndDestroy();
    }
}
