package saki.qq.datapacket.pack.send.packagea;

import saki.toolkit.HexToolKit;
import saki.qq.datapacket.pack.ByteWriter;
import saki.qq.datapacket.pack.packageb.Protobuff;

public class mark19_classa extends mark19_classd {
    private byte[] a;

    public mark19_classa(String str, long j) {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(1, str.getBytes()));
        ByteWriter mark15_classa2 = new ByteWriter();
        mark15_classa2.writeShort(1);
        mark15_classa2.writeInt(str.length());
        mark15_classa2.writeByte(0);
        mark15_classa2.writeInt(j);
        mark15_classa2.writeShort(0);
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(3, mark15_classa2.getDataAndDestroy()));
        this.a = Protobuff.writeLengthDelimit(2, Protobuff.writeLengthDelimit(1, mark15_classa.getDataAndDestroy()));
    }

    public byte[] a() {
        return this.a;
    }
}
