package saki.qq.datapacket.pack.send;

import com.qq.taf.jce.JceOutputStream;
import saki.qq.global.mark12_classc;
import saki.qq.datapacket.pack.packagea.mark16_classg;

class mark18_classc extends mark16_classg {
    final /* synthetic */ friendlist_getFriendGroupList a;

    mark18_classc(friendlist_getFriendGroupList mark18_classb) {
        this.a = mark18_classb;
    }

    public void writeTo(JceOutputStream mark2_classf) {
        mark2_classf.a(3, 0);
        mark2_classf.a(1, 1);
        mark2_classf.a(mark12_classc.c, 2);
        mark2_classf.a(0, 3);
        mark2_classf.a(20, 4);
        mark2_classf.a(0, 5);
        mark2_classf.a(1, 6);
        mark2_classf.a(0, 7);
        mark2_classf.a(0, 8);
        mark2_classf.a(0, 9);
        mark2_classf.a(1, 10);
        mark2_classf.a(9, 11);
    }
}
