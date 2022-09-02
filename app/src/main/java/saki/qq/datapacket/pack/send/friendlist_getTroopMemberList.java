package saki.qq.datapacket.pack.send;

import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;
import saki.qq.datapacket.pack.packagea.mark16_classd;

public class friendlist_getTroopMemberList extends T0B01 {
    /* access modifiers changed from: private */
    public long a;

    public friendlist_getTroopMemberList(int i) {
        super("friendlist.getTroopMemberList");
        setSeq(i);
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        HashMap hashMap = new HashMap();
        JceOutputStream mark2_classf = new JceOutputStream();
        mark2_classf.a((JceStruct) new mark18_classg(this, (mark18_classg) null), 0);
        hashMap.put("GTML", mark2_classf.a());
        JceOutputStream mark2_classf2 = new JceOutputStream();
        mark2_classf2.a((Map) hashMap, 0);
        return new mark16_classd((short)3, (byte) 0, 0, MessageSvc_PbSendMsg.b_(), "mqq.IMService.FriendListServiceServantObj", "GetTroopMemberListReq", mark2_classf2.a(), 0, (Map) null, (Map) null).a();
    }
}
