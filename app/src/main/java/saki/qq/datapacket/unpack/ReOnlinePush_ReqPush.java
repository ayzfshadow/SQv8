package saki.qq.datapacket.unpack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import saki.toolkit.ByteReader;
import saki.qq.datapacket.pack.packagea.mark16_classd;

public class ReOnlinePush_ReqPush extends mark14_classap {
    public mark14_classz a;
    public long b;

    public ReOnlinePush_ReqPush(byte[] bArr) {
        super(bArr);
        ByteReader mark10_classd = new ByteReader(bArr);
        if (mark10_classd.readInt() == mark10_classd.restByteCount() + 4) {
            mark16_classd mark16_classd = new mark16_classd();
            mark16_classd.readFrom(new JceInputStream(mark10_classd.readRestBytesAndDestroy()));
            this.b = (long) mark16_classd.f;
            JceInputStream mark2_classd = new JceInputStream(mark16_classd.i);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            hashMap2.put("", new byte[0]);
            hashMap.put("", hashMap2);
            HashMap hashMap3 =  mark2_classd.readMap(hashMap, 0, true);
            for (Object str : hashMap3.keySet()) {
                HashMap hashMap4 = (HashMap) hashMap3.get((String)str);
                for (Object str2 : hashMap4.keySet()) {
                    this.a = (mark14_classz) new JceInputStream((byte[]) hashMap4.get((String)str2)).read((JceStruct) new mark14_classz(), 0, true);
                }
            }
        }
    }
}
