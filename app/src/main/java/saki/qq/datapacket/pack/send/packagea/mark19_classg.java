package saki.qq.datapacket.pack.send.packagea;

import saki.qq.datapacket.pack.ByteWriter;
import saki.qq.datapacket.pack.packageb.Protobuff;
import saki.packaged.mark20_classk;

public class mark19_classg extends mark19_classd {
    private byte[] a;

    public mark19_classg(String str) {
        String replaceAll = str.replaceAll("(?s)(?i).*serviceid=['|\"]([0-9]+).*?", "$1");
        int parseInt = replaceAll.matches("[0-9]+") ? Integer.parseInt(replaceAll) : 0;
        this.a = mark20_classk.a(str.getBytes());
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeByte(1);
        mark15_classa.writeBytes(this.a);
        this.a = mark15_classa.getDataAndDestroy();
        mark15_classa.recreate();
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(1, this.a));
        mark15_classa.writeBytes(Protobuff.writeVarint(2, (long) parseInt));
        this.a = Protobuff.writeLengthDelimit(12, mark15_classa.getDataAndDestroy());
        this.a = Protobuff.writeLengthDelimit(2, this.a);
    }

    public byte[] a() {
        return this.a;
    }
}
