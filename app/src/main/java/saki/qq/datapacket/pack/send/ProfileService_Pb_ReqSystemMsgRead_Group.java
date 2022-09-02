package saki.qq.datapacket.pack.send;

import saki.qq.datapacket.pack.ByteWriter;
import saki.qq.datapacket.pack.packageb.Protobuff;

public class ProfileService_Pb_ReqSystemMsgRead_Group extends T0B01 {
    private long a;

    public ProfileService_Pb_ReqSystemMsgRead_Group(int i, long j) {
        super("ProfileService.Pb.ReqSystemMsgRead.Group");
        setSeq(i);
        this.a = j;
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeBytes(Protobuff.writeVarint(1, this.a));
        mark15_classa.writeBytes(Protobuff.writeVarint(2, 3));
        return mark15_classa.getDataAndDestroy();
    }
}
