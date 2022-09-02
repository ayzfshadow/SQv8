package saki.qq.datapacket.pack.send;

import saki.qq.datapacket.pack.ByteWriter;
import saki.qq.datapacket.pack.packageb.Protobuff;
import saki.qq.global.ProtocolInfo;
import saki.qq.global.mark12_classc;
import saki.qq.global.ImgStore;

public class ImgStore_GroupPicUp extends T0B01 {
    private long a;
    private ImgStore b;

    public ImgStore_GroupPicUp(int i, long j, ImgStore mark12_classe) {
        super("ImgStore.GroupPicUp");
        setSeq(i);
        this.a = j;
        this.b = mark12_classe;
        ProtocolInfo.imgcache.put(i,mark12_classe);
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeBytes(Protobuff.writeVarint(1, 3));
        mark15_classa.writeBytes(Protobuff.writeVarint(2, 1));
        ByteWriter mark15_classa2 = new ByteWriter();
        mark15_classa2.writeBytes(Protobuff.writeVarint(1, this.a));
        mark15_classa2.writeBytes(Protobuff.writeVarint(2, mark12_classc.c));
        mark15_classa2.writeBytes(Protobuff.writeVarint(3, 0));
        mark15_classa2.writeBytes(Protobuff.writeLengthDelimit(4, this.b.c));
        mark15_classa2.writeBytes(Protobuff.writeVarint(5, (long) this.b.a.length));
        mark15_classa2.writeBytes(Protobuff.writeLengthDelimit(6, this.b.toString().getBytes()));
        mark15_classa2.writeBytes(Protobuff.writeVarint(7, 5));
        mark15_classa2.writeBytes(Protobuff.writeVarint(8, 9));
        mark15_classa2.writeBytes(Protobuff.writeVarint(9, 1));
        mark15_classa2.writeBytes(Protobuff.writeVarint(10, (long) this.b.d));
        mark15_classa2.writeBytes(Protobuff.writeVarint(11, (long) this.b.e));
        mark15_classa2.writeBytes(Protobuff.writeVarint(12, 1000));
        mark15_classa2.writeBytes(Protobuff.writeLengthDelimit(13, "6.5.0.390".getBytes()));
        mark15_classa2.writeBytes(Protobuff.writeVarint(14, 1007));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(3, mark15_classa2.getDataAndDestroy()));
        return mark15_classa.getDataAndDestroy();
    }
}
