package saki.qq.datapacket.unpack;

import java.util.ArrayList;
import saki.toolkit.ByteReader;
import saki.qq.datapacket.pack.packageb.Protobuff;

public class ReProfileService_Pb_ReqSystemMsgNew_Group extends mark14_classap {
    public long a;
    public ArrayList b = new ArrayList();

    public ReProfileService_Pb_ReqSystemMsgNew_Group(byte[] bArr) {
        super(bArr);
        ByteReader mark10_classd = new ByteReader(bArr);
        if (mark10_classd.readInt() == mark10_classd.restByteCount() + 4) {
            Protobuff mark17_classa = new Protobuff(mark10_classd.readRestBytesAndDestroy());
            this.a = mark17_classa.readVarint(5);
            while (true) {
                byte[] b2 = mark17_classa.readLD(10);
                if (b2 != null) {
                    Protobuff mark17_classa2 = new Protobuff(b2);
                    mark14_classah mark14_classah = new mark14_classah(this);
                    mark14_classah.a = mark17_classa2.readVarint(3);
                    mark14_classah.i = mark17_classa2.readVarint(4);
                    mark14_classah.c = mark17_classa2.readVarint(5);
                    byte[] b3 = mark17_classa2.readLD(50);
                    if (b3 != null) {
                        Protobuff mark17_classa3 = new Protobuff(b3);
                        mark14_classah.j = (int) mark17_classa3.readVarint(1);
                        mark14_classah.e = new String(mark17_classa3.readLD(2));
                        mark14_classah.b = mark17_classa3.readVarint(10);
                        mark14_classah.d = mark17_classa3.readVarint(11);
                        byte[] b4 = mark17_classa3.readLD(51);
                        if (b4 != null) {
                            mark14_classah.f = new String(b4);
                        }
                        byte[] b5 = mark17_classa3.readLD(52);
                        if (b5 != null) {
                            mark14_classah.g = new String(b5);
                        }
                        byte[] b6 = mark17_classa3.readLD(53);
                        if (b6 != null) {
                            mark14_classah.h = new String(b6);
                        }
                    }
                    this.b.add(mark14_classah);
                } else {
                    return;
                }
            }
        }
    }
}
