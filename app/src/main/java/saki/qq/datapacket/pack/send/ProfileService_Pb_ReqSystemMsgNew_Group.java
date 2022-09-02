package saki.qq.datapacket.pack.send;

import saki.toolkit.HexToolKit;
import saki.qq.datapacket.pack.ByteWriter;
import saki.qq.datapacket.pack.packageb.Protobuff;

public class ProfileService_Pb_ReqSystemMsgNew_Group extends T0B01 {
    public ProfileService_Pb_ReqSystemMsgNew_Group(int i) {
        super("ProfileService.Pb.ReqSystemMsgNew.Group");
        setSeq(i);
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeBytes(Protobuff.writeVarint(1, 20));
        mark15_classa.writeBytes(Protobuff.writeVarint(2, 0));
        mark15_classa.writeBytes(Protobuff.writeVarint(3, 0));
        mark15_classa.writeBytes(Protobuff.writeVarint(4, 1000));
        mark15_classa.writeBytes(Protobuff.writeVarint(5, 3));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(6, HexToolKit.a("08 01 10 01 18 01 28 01 30 01 38 01")));
        mark15_classa.writeBytes(Protobuff.writeVarint(8, 0));
        mark15_classa.writeBytes(Protobuff.writeVarint(9, 0));
        mark15_classa.writeBytes(Protobuff.writeVarint(10, 1));
        return mark15_classa.getDataAndDestroy();
    }
}
