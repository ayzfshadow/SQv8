package saki.qq.datapacket.pack.send;

import saki.toolkit.HexToolKit;
import saki.qq.datapacket.pack.ByteWriter;

public class mark18_classbc extends wtlogin_login {
    
    private String k;

    public mark18_classbc(int i2, String str) {
        super(i2);
        this.k = str;
    }

    private byte[] C() {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeBytes((byte)1,(byte) 4);
        mark15_classa.writeShort(super.i.length);
        mark15_classa.writeBytes(i);
        return mark15_classa.getDataAndDestroy();
    }

    private byte[] D() {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeBytes((byte)1,(byte)0x93);
        mark15_classa.writeShort(k.getBytes().length);
        mark15_classa.writeBytes(k.getBytes());
        return mark15_classa.getDataAndDestroy();
    }

    public byte[] a(long j2, int i2, long j3) {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeShort(2);
        mark15_classa.writeShort(4);
        mark15_classa.writeBytes(D());
        mark15_classa.writeBytes(t0008());
        mark15_classa.writeBytes(C());
        mark15_classa.writeBytes(t0116());
        return mark15_classa.getDataAndDestroy();
    }
}
