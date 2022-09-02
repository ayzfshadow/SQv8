package saki.qq.datapacket.pack.send;

import saki.qq.datapacket.pack.ByteWriter;
import saki.qq.datapacket.pack.packageb.Protobuff;

public class OidbSvc_0x7a2_0 extends T0B01 {
    public OidbSvc_0x7a2_0(int i) {
        super("OidbSvc.0x7a2_0");
        setSeq(i);
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeBytes(Protobuff.writeVarint(1, 1954));
        mark15_classa.writeBytes(Protobuff.writeVarint(2, 0));
        mark15_classa.writeBytes(Protobuff.writeVarint(3, 0));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(4, Protobuff.writeVarint(1, 0)));
        return mark15_classa.getDataAndDestroy();
    }
}
