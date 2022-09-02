package saki.qq.datapacket.pack.send;

import java.util.Map;
import saki.qq.datapacket.pack.packagea.mark16_classd;

public class StatSvc_register extends T0B01 {
    public StatSvc_register(int i) {
        super("StatSvc.register");
        setSeq(i);
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        return new mark16_classd((short)3, (byte) 0, 0, 0, "PushService", "SvcReqRegister", new mark18_classar((mark18_classar) null).a(), 0, (Map) null, (Map) null).a();
    }
}
