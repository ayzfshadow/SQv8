package saki.qq.datapacket.unpack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import saki.toolkit.ByteReader;
import saki.qq.datapacket.pack.packagea.mark16_classd;
import saki.qq.datapacket.pack.packagea.mark16_classf;

public class Refriendlist_GetTroopListReqV2 extends mark14_classap {
    public mark16_classf a = new mark16_classf();

    public Refriendlist_GetTroopListReqV2(byte[] bArr) {
        super(bArr);
        ByteReader mark10_classd = new ByteReader(bArr);
        if (mark10_classd.readInt() == mark10_classd.restByteCount() + 4) {
            JceInputStream mark2_classd = new JceInputStream(a(mark10_classd.readRestBytesAndDestroy()));
            mark16_classd mark16_classd = new mark16_classd();
            mark16_classd.readFrom(mark2_classd);
            JceInputStream mark2_classd2 = new JceInputStream(mark16_classd.i);
            HashMap hashMap = new HashMap();
            hashMap.put("", new byte[0]);
            HashMap hashMap2 = (HashMap) mark2_classd2.readobj((Object) hashMap, 0, true);
            for (Object str : hashMap2.keySet()) {
                this.a = (mark16_classf) new JceInputStream((byte[]) hashMap2.get((String)str)).readobj((JceStruct) this.a, 0, true);
            }
        }
    }
}
