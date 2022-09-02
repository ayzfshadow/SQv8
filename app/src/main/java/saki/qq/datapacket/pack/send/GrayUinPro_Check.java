package saki.qq.datapacket.pack.send;

import java.util.Map;
import saki.qq.datapacket.pack.packagea.mark16_classd;
import saki.qq.global.DeviceInfo;
import saki.qq.global.ProtocolInfo;
import saki.qq.global.mark12_classj;

public class GrayUinPro_Check extends mark18_classau {
    public GrayUinPro_Check(int var1) {
        super("GrayUinPro.Check");
        this.setRequestId(var1);
        this.setAppsub(ProtocolInfo.appid);
        this.setImei(DeviceInfo.imei);
        this.setVersion("|310260000000000|A6.5.0.215311");
        this.setToken4c(mark12_classj.a);
    }

    protected byte[] getContent() {
        return (new mark16_classd((short)3, (byte)0, 0, MessageSvc_PbSendMsg.b_(), "KQQ.ConfigService.ConfigServantObj", "ClientReq", (new mark18_classm((mark18_classm)null)).a(), 0, (Map)null, (Map)null)).a();
    }
}


