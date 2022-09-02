package saki.qq.datapacket.pack.packagea;

import com.qq.taf.jce.mark2_classa;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;
import saki.toolkit.HexToolKit;

public final class mark16_classd extends JceStruct {
    static Map a;
    static byte[] b;
    public byte c = 0;
    public Map d;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public short h = 0;
    public byte[] i;
    public String j = null;
    public String k = null;
    public Map l;

    public mark16_classd() {
    }

    public mark16_classd(short s, byte b2, int i2, int i3, String str, String str2, byte[] bArr, int i4, Map map, Map map2) {
        this.h = s;
        this.c = b2;
        this.e = i2;
        this.f = i3;
        this.k = str;
        this.j = str2;
        this.i = bArr;
        this.g = i4;
        this.d = map == null ? new HashMap() : map;
        this.l = map2 == null ? new HashMap() : map2;
    }

    public void readFrom(JceInputStream mark2_classd) {
        try {
            this.h = mark2_classd.read(this.h, 1, true);
            this.c = mark2_classd.read(this.c, 2, true);
            this.e = mark2_classd.read(this.e, 3, true);
            this.f = mark2_classd.read(this.f, 4, true);
            this.k = mark2_classd.readString(5, true);
            this.j = mark2_classd.readString(6, true);
            if (b == null) {
                b = new byte[1];
            }
            this.i = mark2_classd.read(b, 7, true);
            this.g = mark2_classd.read(this.g, 8, true);
            if (a == null) {
                a = new HashMap();
                a.put("", "");
            }
            this.d = (Map) mark2_classd.readobj((Object) a, 9, true);
            if (a == null) {
                a = new HashMap();
                a.put("", "");
            }
            this.l = (Map) mark2_classd.readobj((Object) a, 10, true);
        } catch (Exception e2) {
            e2.printStackTrace();
            System.out.println("RequestPacket decode error " + mark2_classa.a(this.i));
            throw new RuntimeException(e2);
        }
    }

    public void writeTo(JceOutputStream mark2_classf) {
        mark2_classf.a(this.h, 1);
        mark2_classf.a(this.c, 2);
        mark2_classf.a(this.e, 3);
        mark2_classf.a(this.f, 4);
        mark2_classf.a(this.k, 5);
        mark2_classf.a(this.j, 6);
        mark2_classf.a(this.i, 7);
        mark2_classf.a(this.g, 8);
        mark2_classf.a(this.d, 9);
        mark2_classf.a(this.l, 10);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("sFuncName:" + this.j + "\r\n");
        sb.append("sServantName:" + this.k + "\r\n");
        sb.append("cPacketType:" + this.c + "\r\n");
        sb.append("iMessageType:" + this.e + "\r\n");
        sb.append("iRequestId:" + this.f + "\r\n");
        sb.append("iTimeout:" + this.g + "\r\n");
        sb.append("iVersion:" + this.h + "\r\n");
        sb.append("cPacketType:" + this.c + "\r\n");
        sb.append("sBuffer:" + HexToolKit.bytesToHexString(this.i) + "\r\n");
        return sb.toString();
    }
}
