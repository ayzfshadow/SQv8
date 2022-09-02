package saki.qq.datapacket.pack.send;

import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;
import saki.qq.datapacket.pack.packagea.mark16_classd;

public class friendlist_GetTroopListReqV2 extends T0B01 {
    public friendlist_GetTroopListReqV2(int i) {
        super("friendlist.GetTroopListReqV2");
        setSeq(i);
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        HashMap hashMap = new HashMap();
        JceOutputStream mark2_classf = new JceOutputStream();
        mark2_classf.a((JceStruct) new mark18_classe(this), 0);
        hashMap.put("GetTroopListReqV2", mark2_classf.a());
        JceOutputStream mark2_classf2 = new JceOutputStream();
        mark2_classf2.a((Map) hashMap, 0);
        return new mark16_classd((short)3, (byte) 0, 0, MessageSvc_PbSendMsg.b_(), "mqq.IMService.FriendListServiceServantObj", "GetTroopListReqV2", mark2_classf2.a(), 0, (Map) null, (Map) null).a();
    }
}
