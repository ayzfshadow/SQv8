package saki.qq.datapacket.pack.send.packagea;

import saki.qq.datapacket.pack.ByteWriter;
import saki.qq.datapacket.pack.packageb.Protobuff;
import saki.packaged.mark20_classk;

public class mark19_classc extends mark19_classd {
    private byte[] a;

    public mark19_classc(String str) {
        this.a = mark20_classk.a(str.getBytes());
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeByte(1);
        mark15_classa.writeBytes(this.a);
        this.a = Protobuff.writeLengthDelimit(1, mark15_classa.getDataAndDestroy());
        this.a = Protobuff.writeLengthDelimit(51, this.a);
        this.a = Protobuff.writeLengthDelimit(2, this.a);
    }

    public byte[] a() {
        return this.a;
    }
}
