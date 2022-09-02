package saki.qq.datapacket.pack.send;

import saki.qq.global.DeviceInfo;
import saki.qq.global.ProtocolInfo;
import saki.qq.global.mark12_classj;
import saki.toolkit.HexToolKit;

public class OidbSvc_0x59f extends SendPack {
    public OidbSvc_0x59f(int i) {
        super("OidbSvc.0x59f");
        setSeq(i);
        setRequestId(i);
        setToken44(mark12_classj.c);
        setToken4c(mark12_classj.a);
        setAppsub(ProtocolInfo.appid);
        setImei(DeviceInfo.imei);
        setVersion("|310260000000000|A6.5.0.215311");
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        return HexToolKit.a("08 9F 0B 10 01 18 00 22 00 32 0D 61 6E 64 72 6F 69 64 20 36 2E 35 2E 30");
    }

    /* access modifiers changed from: protected */
    public byte[] encryptKey() {
        return ProtocolInfo.g;
    }
}
