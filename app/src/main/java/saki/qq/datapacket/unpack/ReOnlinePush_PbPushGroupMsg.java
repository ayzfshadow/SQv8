package saki.qq.datapacket.unpack;

import java.util.ArrayList;
import java.util.HashMap;
import saki.toolkit.HexToolKit;
import saki.toolkit.ByteReader;
import saki.qq.datapacket.pack.packageb.Protobuff;

public class ReOnlinePush_PbPushGroupMsg extends mark14_classap {
    public long a;
    public long b;
    public long c;
    public String d;
    public String e;
    public String f;
    public String g;
    public long h;
    public long i;
    public HashMap j = new HashMap();

    public ReOnlinePush_PbPushGroupMsg(byte[] bArr) {
        super(bArr);
        ByteReader mark10_classd = new ByteReader(bArr);
        if (mark10_classd.readInt() == mark10_classd.restByteCount() + 4) {
            Protobuff mark17_classa =new Protobuff(mark10_classd.readRestBytesAndDestroy());
            mark17_classa.update(mark17_classa.readLD(1));
            f(mark17_classa.readLD(1));
            h(mark17_classa.readLD(2));
            b(mark17_classa.readLD(3));
            mark17_classa.destroy();
        }
    }

    private void a(String str, String str2) {
        ArrayList arrayList = (ArrayList) this.j.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.j.put(str, arrayList);
        }
        arrayList.add(str2);
    }

    private void b(byte[] bArr) {
        Protobuff mark17_classa = new Protobuff(bArr);
        mark17_classa.update(mark17_classa.readLD(1));
        e(mark17_classa.readLD(1));
        while (true) {
            byte[] b2 = mark17_classa.readLD(2);
            if (b2 != null) {
                d(b2);
                c(b2);
            } else {
                mark17_classa.destroy();
                return;
            }
        }
        
    }

    private void c(byte[] bArr) {
        Protobuff g = new Protobuff(bArr);
        byte[] b2;
        byte[] b3 = g.readLD(16);
        if (b3 != null && (b2 = g.update(b3).readLD(7)) != null) {
            this.g = new String(b2);
        }
    }

    private void d(byte[] bArr) {
        Protobuff h = new Protobuff(bArr);
        byte[] b2 = h.readLD(1);
        if (b2 != null) {
            String str = "";
            byte[] b3 = h.update(b2).readLD(1);
            if (b3 != null) {
                str = new String(b3);
                a("msg", str);
            }
            byte[] b4 = h.update(b2).readLD(3);
            if (b4 != null) {
                ByteReader mark10_classd = new ByteReader(b4);
                mark10_classd.readShort();
                mark10_classd.readInt();
                mark10_classd.readByte();
                a("at", String.valueOf(HexToolKit.c(mark10_classd.readBytes(4))) + str);
            }
        }
        byte[] b5 = h.update(bArr).readLD(8);
        if (b5 != null) {
            a("img", new String(h.update(b5).readLD(2)));
        }
        byte[] b6 = h.update(bArr).readLD(12);
        if (b6 != null) {
            a("xml", new String(a(h.update(b6).readLD(1))));
        }
        byte[] b7 = h.update(bArr).readLD(51);
        if (b7 != null) {
            a("json", new String(a(h.update(b7).readLD(1))));
        }
        h.destroy();
    }

    private void e(byte[] bArr) {
        Protobuff mark17_classa = new Protobuff(bArr);
        this.i = mark17_classa.readVarint(2);
        this.h = mark17_classa.readVarint(3);
        this.f = new String(mark17_classa.readLD(9));
        mark17_classa.destroy();
    }

    private void f(byte[] bArr) {
        Protobuff mark17_classa = new Protobuff(bArr);
        this.a = mark17_classa.readVarint(1);
        this.b = mark17_classa.readVarint(2);
        g(mark17_classa.readLD(a()));
        mark17_classa.destroy();
    }

    private void g(byte[] bArr) {
        Protobuff mark17_classa = new Protobuff(bArr);
        this.c = mark17_classa.readVarint(1);
        this.e = mark17_classa.readString(4);
        this.d = mark17_classa.readString(b());
        mark17_classa.destroy();
    }

    private void h(byte[] bArr) {
    }

    /* access modifiers changed from: protected */
    public int a() {
        return 9;
    }

    /* access modifiers changed from: protected */
    public int b() {
        return 8;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ReOnlinePush_PbPushGroupMsg)) {
            return false;
        }
        ReOnlinePush_PbPushGroupMsg mark14_classw = (ReOnlinePush_PbPushGroupMsg) obj;
        return this.a == mark14_classw.a && this.b == mark14_classw.b && this.c == mark14_classw.c && this.i == mark14_classw.i && this.h == mark14_classw.h;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("sendUin:" + this.a + "\r\n");
        sb.append("toUin:" + this.b + "\r\n");
        sb.append("groupId:" + this.c + "\r\n");
        sb.append("groupName:" + this.d + "\r\n");
        sb.append("sendName:" + this.e + "\r\n");
        sb.append("fontName:" + this.f + "\r\n");
        sb.append("sendTitle:" + this.g + "\r\n");
        sb.append("requstId:" + this.h + "\r\n");
        sb.append("sendTime:" + this.i + "\r\n");
        sb.append("msg:" + this.j);
        return sb.toString();
    }
}
