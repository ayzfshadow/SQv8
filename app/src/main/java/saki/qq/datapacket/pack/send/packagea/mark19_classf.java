package saki.qq.datapacket.pack.send.packagea;

import saki.qq.datapacket.pack.packageb.Protobuff;

public class mark19_classf extends mark19_classd {
    private byte[] a;

    public mark19_classf(String str) {
        this.a = Protobuff.writeLengthDelimit(1, str.getBytes());
        this.a = Protobuff.writeLengthDelimit(1, this.a);
        this.a = Protobuff.writeLengthDelimit(2, this.a);
    }

    public byte[] a() {
        return this.a;
    }
}
