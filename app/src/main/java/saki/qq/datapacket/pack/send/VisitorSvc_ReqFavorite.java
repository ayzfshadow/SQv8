package saki.qq.datapacket.pack.send;

import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;
import saki.qq.datapacket.pack.packagea.mark16_classd;

public class VisitorSvc_ReqFavorite extends T0B01 {
    /* access modifiers changed from: private */
    public long a;
    /* access modifiers changed from: private */
    public int b;
    /* access modifiers changed from: private */
    public int c;

    public VisitorSvc_ReqFavorite(int i, long j, int i2) {
        super("VisitorSvc.ReqFavorite");
        setSeq(i);
        this.a = j;
        this.b = i2 > 10 ? 10 : i2;
        this.c = MessageSvc_PbSendMsg.b_();
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        HashMap hashMap = new HashMap();
        JceOutputStream mark2_classf = new JceOutputStream();
        mark2_classf.a((JceStruct) new mark18_classay(this, (mark18_classay) null), 0);
        hashMap.put("ReqFavorite", mark2_classf.a());
        JceOutputStream mark2_classf2 = new JceOutputStream();
        mark2_classf2.a((Map) hashMap, 0);
        return new mark16_classd((short)3, (byte) 0, 0, this.c, "VisitorSvc", "ReqFavorite", mark2_classf2.a(), 0, (Map) null, (Map) null).a();
    }
}
