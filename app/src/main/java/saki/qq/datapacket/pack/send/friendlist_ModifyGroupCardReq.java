package saki.qq.datapacket.pack.send;

import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;
import saki.qq.datapacket.pack.packagea.mark16_classd;

public class friendlist_ModifyGroupCardReq extends T0B01 {
    private mark18_classi a;

    public friendlist_ModifyGroupCardReq(int i, long j, long j2, String str) {
        super("friendlist.ModifyGroupCardReq");
        this.a = new mark18_classi(this, j, j2, str);
        setSeq(i);
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        JceOutputStream mark2_classf = new JceOutputStream();
        mark2_classf.a((JceStruct) this.a, 0);
        HashMap hashMap = new HashMap();
        hashMap.put("MGCREQ", mark2_classf.a());
        JceOutputStream mark2_classf2 = new JceOutputStream();
        mark2_classf2.a((Map) hashMap, 0);
        return new mark16_classd((short)3, (byte) 0, 0, MessageSvc_PbSendMsg.b_(), "mqq.IMService.FriendListServiceServantObj", "ModifyGroupCardReq", mark2_classf2.a(), 0, (Map) null, (Map) null).a();
    }
}
