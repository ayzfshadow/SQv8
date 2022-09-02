package saki.qq.datapacket.unpack;

import saki.toolkit.ByteReader;
import saki.qq.datapacket.pack.packageb.Protobuff;

public class ReImgStore_GroupPicUp extends mark14_classap {
    public long a;
    public byte[] b;
    public long c;
    public byte[] d;

    public ReImgStore_GroupPicUp(byte[] bArr) {
        super(bArr);
        ByteReader mark10_classd = new ByteReader(bArr);
        if (mark10_classd.readInt() == mark10_classd.restByteCount() + 4) {
            Protobuff mark17_classa = new Protobuff(mark10_classd.readRestBytesAndDestroy());
            this.a = mark17_classa.readVarint(1);
            byte[] b2 = mark17_classa.readLD(3);
            if (b2 != null) {
                Protobuff mark17_classa2 = new Protobuff(b2);
                if (mark17_classa2.readLD(5) != null) {
                    this.d = mark17_classa2.readLD(1);
                }
                this.b = mark17_classa2.readLD(8);
                this.c = mark17_classa2.readVarint(9);
            }
        }
    }
}
