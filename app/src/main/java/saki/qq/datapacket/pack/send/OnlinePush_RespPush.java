package saki.qq.datapacket.pack.send;

import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import saki.qq.datapacket.pack.packagea.mark16_classd;
import saki.qq.datapacket.unpack.mark14_classaa;

public class OnlinePush_RespPush extends T0B01 {
    ArrayList a = new ArrayList();
    private long b;

    public OnlinePush_RespPush(int i, long j, ArrayList arrayList) {
        super("OnlinePush.RespPush");
        setSeq(i);
        this.b = j;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                mark14_classaa mark14_classaa = (mark14_classaa) it.next();
                this.a.add(new mark18_classaf(this, mark14_classaa.a, mark14_classaa.b, mark14_classaa.c));
            }
        }
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        JceOutputStream mark2_classf = new JceOutputStream();
        mark2_classf.a((JceStruct) new mark18_classae(this), 0);
        HashMap hashMap = new HashMap();
        hashMap.put("resp", mark2_classf.a());
        JceOutputStream mark2_classf2 = new JceOutputStream();
        mark2_classf2.a((Map) hashMap, 0);
        return new mark16_classd((short)3, (byte) 0, 0, (int) this.b, "OnlinePush", "SvcRespPushMsg", mark2_classf2.a(), 0, (Map) null, (Map) null).a();
    }
}
