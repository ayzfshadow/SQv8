package saki.qq.datapacket.unpack;

import saki.toolkit.HexToolKit;
import saki.toolkit.ByteReader;
import saki.qq.datapacket.pack.packageb.Protobuff;

public class ReOnlinePush_PbPushTransMsg extends mark14_classap {
    public long a;
    public long b;
    public long c;
    public long d;
    public int e;
    public long f;
    public boolean g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReOnlinePush_PbPushTransMsg(byte[] bArr) {
        super(bArr);
        boolean z = true;
        ByteReader mark10_classd = new ByteReader(bArr);
        if (mark10_classd.readInt() == mark10_classd.restByteCount() + 4) {
            Protobuff mark17_classa = new Protobuff(mark10_classd.readRestBytes());
            this.a = mark17_classa.readVarint(1);
            this.e = (int) mark17_classa.readVarint(3);
            this.f = mark17_classa.readVarint(7);
            mark10_classd.update(mark17_classa.readLD(10));
            this.b = HexToolKit.c(mark10_classd.readBytes(4));
            mark10_classd.readBytes(1);
            if (this.e == 34) {
                this.d = HexToolKit.c(mark10_classd.readBytes(4));
            }
            mark10_classd.readBytes(1);
            this.c = HexToolKit.c(mark10_classd.readBytes(4));
            this.g = mark10_classd.readBytes(1)[0] != 0 ? false : z;
        }
    }
}
