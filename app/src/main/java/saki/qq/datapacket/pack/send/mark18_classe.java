package saki.qq.datapacket.pack.send;

import com.qq.taf.jce.JceOutputStream;
import saki.qq.global.mark12_classc;
import saki.qq.datapacket.pack.packagea.mark16_classg;

class mark18_classe extends mark16_classg {
    final /* synthetic */ friendlist_GetTroopListReqV2 a;

    mark18_classe(friendlist_GetTroopListReqV2 mark18_classd) {
        this.a = mark18_classd;
    }

    public void writeTo(JceOutputStream mark2_classf) {
        mark2_classf.a(mark12_classc.c, 0);
        mark2_classf.a(0, 1);
        mark2_classf.a(1, 4);
        mark2_classf.a(5, 5);
    }
}
