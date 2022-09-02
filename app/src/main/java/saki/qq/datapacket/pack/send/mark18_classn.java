package saki.qq.datapacket.pack.send;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import saki.qq.global.ProtocolInfo;
import saki.qq.global.mark12_classc;

class mark18_classn extends JceStruct {
    final /* synthetic */ mark18_classm a;

    mark18_classn(mark18_classm mark18_classm) {
        this.a = mark18_classm;
    }

    public void readFrom(JceInputStream mark2_classd) {
    }

    public void writeTo(JceOutputStream mark2_classf) {
        mark2_classf.a(ProtocolInfo.appid, 1);
        mark2_classf.a(String.valueOf(mark12_classc.c), 2);
        mark2_classf.a("", 3);
        mark2_classf.a("", 4);
    }
}
