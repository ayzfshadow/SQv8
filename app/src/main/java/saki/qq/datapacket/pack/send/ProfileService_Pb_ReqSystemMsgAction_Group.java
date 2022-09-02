package saki.qq.datapacket.pack.send;

import saki.qq.datapacket.pack.ByteWriter;
import saki.qq.datapacket.pack.packageb.Protobuff;

public class ProfileService_Pb_ReqSystemMsgAction_Group extends T0B01 {
    private long a;
    private long b;
    private long c;
    private boolean d;

    public ProfileService_Pb_ReqSystemMsgAction_Group(int i, long j, long j2, long j3, boolean z) {
        super("ProfileService.Pb.ReqSystemMsgAction.Group");
        setSeq(i);
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = z;
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeBytes(Protobuff.writeVarint(1, 2));
        mark15_classa.writeBytes(Protobuff.writeVarint(2, this.c));
        mark15_classa.writeBytes(Protobuff.writeVarint(3, this.b));
        mark15_classa.writeBytes(Protobuff.writeVarint(4, 1));
        mark15_classa.writeBytes(Protobuff.writeVarint(5, 0));
        mark15_classa.writeBytes(Protobuff.writeVarint(6, 0));
        mark15_classa.writeBytes(Protobuff.writeVarint(7, 2));
        ByteWriter mark15_classa2 = new ByteWriter();
        mark15_classa2.writeBytes(Protobuff.writeVarint(1, (long) (this.d ? 11 : 12)));
        mark15_classa2.writeBytes(Protobuff.writeVarint(2, this.a));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(8, mark15_classa2.getDataAndDestroy()));
        mark15_classa.writeBytes(Protobuff.writeVarint(9, 1000));
        return mark15_classa.getDataAndDestroy();
    }
}
