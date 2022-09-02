package saki.qq.datapacket.pack.send;

import saki.toolkit.HexToolKit;

public class OidbSvc_0x496 extends T0B01 {
    public OidbSvc_0x496(int i) {
        super("OidbSvc.0x496");
        setSeq(i);
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        return HexToolKit.a("08 96 09 10 00 22 04 20 01 28 01");
    }
}
