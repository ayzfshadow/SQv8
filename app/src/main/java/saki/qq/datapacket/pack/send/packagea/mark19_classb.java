package saki.qq.datapacket.pack.send.packagea;

import saki.qq.global.ImgStore;
import saki.qq.datapacket.pack.ByteWriter;
import saki.qq.datapacket.pack.packageb.Protobuff;

public class mark19_classb extends mark19_classd {
    private byte[] a;

    public mark19_classb(ImgStore mark12_classe) {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(2, mark12_classe.toString().getBytes()));
        mark15_classa.writeBytes(Protobuff.writeVarint(7, mark12_classe.g));
        mark15_classa.writeBytes(Protobuff.writeVarint(8, 3082863821L));
        mark15_classa.writeBytes(Protobuff.writeVarint(9, 8080));
        mark15_classa.writeBytes(Protobuff.writeVarint(10, 66));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(11, "eXyEdhfrFa5KfBK7".getBytes()));
        mark15_classa.writeBytes(Protobuff.writeVarint(12, 1));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(13, mark12_classe.c));
        mark15_classa.writeBytes(Protobuff.writeVarint(17, 3));
        mark15_classa.writeBytes(Protobuff.writeVarint(20, 1000));
        mark15_classa.writeBytes(Protobuff.writeVarint(22, (long) mark12_classe.d));
        mark15_classa.writeBytes(Protobuff.writeVarint(23, (long) mark12_classe.e));
        mark15_classa.writeBytes(Protobuff.writeVarint(24, 101));
        mark15_classa.writeBytes(Protobuff.writeVarint(25, (long) mark12_classe.b));
        mark15_classa.writeBytes(Protobuff.writeVarint(26, 0));
        mark15_classa.writeBytes(Protobuff.writeVarint(29, 0));
        mark15_classa.writeBytes(Protobuff.writeVarint(30, 0));
        this.a = Protobuff.writeLengthDelimit(2, Protobuff.writeLengthDelimit(8, mark15_classa.getDataAndDestroy()));
    }

    public byte[] a() {
        return this.a;
    }
}
