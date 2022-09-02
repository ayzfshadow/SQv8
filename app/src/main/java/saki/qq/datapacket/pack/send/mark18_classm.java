package saki.qq.datapacket.pack.send;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

class mark18_classm extends JceStruct {
    private mark18_classm() {
    }

    /* synthetic */ mark18_classm(mark18_classm mark18_classm) {
        this();
    }

    public void readFrom(JceInputStream mark2_classd) {
    }

    public void writeTo(JceOutputStream mark2_classf) {
        HashMap hashMap = new HashMap();
        JceOutputStream mark2_classf2 = new JceOutputStream();
        mark2_classf2.a((JceStruct) new mark18_classn(this), 0);
        hashMap.put("req", mark2_classf2.a());
        mark2_classf.a((Map) hashMap, 0);
    }
}
