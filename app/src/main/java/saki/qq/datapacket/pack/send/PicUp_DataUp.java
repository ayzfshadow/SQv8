package saki.qq.datapacket.pack.send;

import saki.toolkit.Code;
import saki.qq.global.mark12_classc;
import saki.qq.datapacket.pack.ByteWriter;
import saki.qq.datapacket.pack.packageb.Protobuff;

public class PicUp_DataUp {
    byte[] a;
    byte[] b;
    byte[] c;
    int d;

    public PicUp_DataUp(byte[] bArr, byte[] bArr2) {
        this.a = bArr;
        this.d = bArr.length;
        this.b = Code.md5(bArr);
        this.c = bArr2;
    }

    public byte[] a() {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeBytes(Protobuff.writeVarint(1, 1));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(2, String.valueOf(mark12_classc.c).getBytes()));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(3, "PicUp.DataUp".getBytes()));
        mark15_classa.writeBytes(Protobuff.writeVarint(4, (long) MessageSvc_PbSendMsg.b_()));
        mark15_classa.writeBytes(Protobuff.writeVarint(5, 0));
        mark15_classa.writeBytes(Protobuff.writeVarint(6, 4660));
        mark15_classa.writeBytes(Protobuff.writeVarint(7, 4096));
        mark15_classa.writeBytes(Protobuff.writeVarint(8, 2));
        ByteWriter mark15_classa2 = new ByteWriter();
        mark15_classa2.writeBytes(Protobuff.writeLengthDelimit(1, mark15_classa.getDataAndDestroy()));
        mark15_classa.recreate();
        mark15_classa.writeBytes(Protobuff.writeVarint(2, (long) this.d));
        mark15_classa.writeBytes(Protobuff.writeVarint(3, 0));
        mark15_classa.writeBytes(Protobuff.writeVarint(4, (long) this.d));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(6, this.c));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(8, this.b));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(9, this.b));
        mark15_classa2.writeBytes(Protobuff.writeLengthDelimit(2, mark15_classa.getDataAndDestroy()));
        mark15_classa.recreate();
        mark15_classa.writeByte(40);
        mark15_classa.writeInt(mark15_classa2.length());
        mark15_classa.writeInt(this.d);
        mark15_classa.writeBytes(mark15_classa2.getDataAndDestroy());
        mark15_classa.writeBytes(this.a);
        mark15_classa.writeByte(41);
        return mark15_classa.getDataAndDestroy();
    }
}
