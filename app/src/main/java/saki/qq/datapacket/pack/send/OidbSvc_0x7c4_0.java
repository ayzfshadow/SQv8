package saki.qq.datapacket.pack.send;

import saki.qq.global.mark12_classc;
import saki.qq.datapacket.pack.ByteWriter;
import saki.qq.datapacket.pack.packageb.Protobuff;

public class OidbSvc_0x7c4_0 extends T0B01 {
    public OidbSvc_0x7c4_0(int i) {
        super("OidbSvc.0x7c4_0");
        setSeq(i);
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeBytes(Protobuff.writeVarint(1, mark12_classc.c));
        mark15_classa.writeBytes(Protobuff.writeVarint(2, 0));
        mark15_classa.writeBytes(Protobuff.writeVarint(3, 0));
        mark15_classa.writeBytes(Protobuff.writeVarint(4, 100));
        byte[] a = mark15_classa.getDataAndDestroy();
        mark15_classa.recreate();
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(2, a));
        mark15_classa.writeBytes(Protobuff.writeVarint(3, 2));
        byte[] a2 = mark15_classa.getDataAndDestroy();
       mark15_classa.recreate();
        mark15_classa.writeBytes(Protobuff.writeVarint(1, 1988));
        mark15_classa.writeBytes(Protobuff.writeVarint(2, 0));
        mark15_classa.writeBytes(Protobuff.writeVarint(3, 0));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(4, a2));
        return mark15_classa.getDataAndDestroy();
    }
}
