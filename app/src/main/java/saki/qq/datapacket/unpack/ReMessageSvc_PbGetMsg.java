package saki.qq.datapacket.unpack;

import java.util.ArrayList;
import saki.toolkit.HexToolKit;
import saki.toolkit.ByteReader;
import saki.qq.global.mark12_classc;
import saki.qq.datapacket.pack.packageb.Protobuff;

public class ReMessageSvc_PbGetMsg extends mark14_classap {
    public ArrayList a = new ArrayList();

    public ReMessageSvc_PbGetMsg(byte[] bArr) {
        super(bArr);
        ByteReader mark10_classd = new ByteReader(bArr);
        if (mark10_classd.readInt() == mark10_classd.restByteCount() + 4) {
            Protobuff mark17_classa = new Protobuff(a(mark10_classd.readRestBytesAndDestroy()));
            mark12_classc.g = mark17_classa.readLD(3);
            while (true) {
                byte[] b = mark17_classa.readLD(5);
                if (b != null) {
                    b(b);
                } else {
                    return;
                }
            }
        }
    }

    private void a(byte[] bArr, mark14_classm mark14_classm) {
        if (bArr != null) {
            Protobuff mark17_classa = new Protobuff(bArr);
            b(mark17_classa.readLD(1), mark14_classm);
            byte[] b = mark17_classa.readLD(2);
            if (b != null) {
                Protobuff mark17_classa2 = new Protobuff(b);
                byte[] b2 = mark17_classa2.readLD(1);
                if (b2 == null) {
                    b2 = mark17_classa2.readLD(12);
                }
                if (b2 != null) {
                    mark14_classm.g = new String(a(new Protobuff(b2).readLD(1)));
                }
            }
        }
    }

    private void b(byte[] bArr) {
        Protobuff mark17_classa = new Protobuff(bArr);
        while (true) {
            byte[] b = mark17_classa.readLD(4);
            if (b != null) {
                mark14_classm mark14_classm = new mark14_classm(this);
                Protobuff mark17_classa2 = new Protobuff(b);
                c(mark17_classa2.readLD(1), mark14_classm);
                byte[] b2 = mark17_classa2.readLD(3);
                if (b2 != null) {
                    Protobuff mark17_classa3 = new Protobuff(b2);
                    a(mark17_classa3.readLD(1), mark14_classm);
                    if (mark14_classm.h == 84 || mark14_classm.h == 87 || mark14_classm.h == 34) {
                        ByteReader mark10_classd = new ByteReader(mark17_classa3.readLD(2));
                        mark14_classm.d = HexToolKit.c(mark10_classd.readBytes(4));
                        try {
                            mark10_classd.readByte();
                            mark10_classd.readBytes(4);
                            mark10_classd.readByte();
                            mark14_classm.j = HexToolKit.c(mark10_classd.readBytes(4));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                this.a.add(mark14_classm);
            } else {
                return;
            }
        }
    }

    private void b(byte[] bArr, mark14_classm mark14_classm) {
        if (bArr != null) {
            mark14_classm.f = new String(new Protobuff(bArr).readLD(9));
        }
    }

    private void c(byte[] bArr, mark14_classm mark14_classm) {
        byte[] b;
        Protobuff mark17_classa = new Protobuff(bArr);
        mark14_classm.d = mark17_classa.readVarint(1);
        mark14_classm.e = mark17_classa.readVarint(2);
        mark14_classm.h = (int) mark17_classa.readVarint(3);
        mark14_classm.a = mark17_classa.readVarint(6);
        if (mark14_classm.h == 34 || mark14_classm.h == 84) {
            mark14_classm.c = mark14_classm.d;
            mark14_classm.i = mark17_classa.readVarint(15);
            mark14_classm.k = new String(mark17_classa.readLD(16));
        } else if (mark14_classm.h == 141 && (b = mark17_classa.readLD(8)) != null) {
            Protobuff mark17_classa2 = new Protobuff(b);
            mark14_classm.c = mark17_classa2.readVarint(3);
            mark14_classm.b = mark17_classa2.readVarint(4);
        }
    }
}
