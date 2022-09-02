package saki.qq.datapacket.pack.send;

import saki.qq.datapacket.pack.ByteWriter;
import saki.qq.datapacket.pack.packageb.Protobuff;
import saki.qq.global.DeviceInfo;
import saki.qq.global.mark12_classc;
import saki.toolkit.HexToolKit;

public class MessageSvc_PbGetMsg extends T0B01 {
    public static byte[] a = new byte[0];

    public MessageSvc_PbGetMsg(int i) {
        super("MessageSvc.PbGetMsg");
        setSeq(i);
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeBytes(Protobuff.writeVarint(1, 0));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(2, (DeviceInfo.deviceName+";os:29;version:v2man:Genymotionsys:vbox86p-userdebug 4.1.1 JRO03S eng.buildbot.20151117.133415 test-keys").getBytes()));
        mark15_classa.writeBytes(Protobuff.writeVarint(3, System.currentTimeMillis()));
        mark15_classa.writeBytes(Protobuff.writeVarint(4, System.currentTimeMillis()));
        mark15_classa.writeBytes(Protobuff.writeVarint(5, System.currentTimeMillis()));
        mark15_classa.writeBytes(Protobuff.writeVarint(6, System.currentTimeMillis()));
        mark15_classa.rewriteBytes(HexToolKit.Int2Bytes(mark15_classa.length() + 4));
        mark15_classa.rewriteBytes(this.msgCookie);
        mark15_classa.rewriteBytes(HexToolKit.Int2Bytes(8));
        mark15_classa.rewriteBytes(this.command.getBytes());
        mark15_classa.rewriteBytes(HexToolKit.Int2Bytes(this.command.length() + 4));
        return mark15_classa.getDataAndDestroy();
    }

    /* access modifiers changed from: protected */
    public void packInfo() {
        packContent();
    }

    public byte[] toByteArray() {
        packInfo();
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeBytes(Protobuff.writeVarint(1, 0));
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(2, mark12_classc.g));
        mark15_classa.writeBytes(Protobuff.writeVarint(3, 0));
        mark15_classa.writeBytes(Protobuff.writeVarint(4, 20));
        mark15_classa.writeBytes(Protobuff.writeVarint(5, 3));
        mark15_classa.writeBytes(Protobuff.writeVarint(6, 1));
        mark15_classa.writeBytes(Protobuff.writeVarint(7, 1));
        mark15_classa.writeBytes(Protobuff.writeVarint(9, 0));
        mark15_classa.rewriteSelfIntLength( 4);
        this.pack.writeBytes(mark15_classa.getDataAndDestroy());
        packHead();
        return this.pack.getDataAndDestroy();
    }
}
