package saki.qq.datapacket.pack.send;

import com.qq.taf.jce.JceOutputStream;
import saki.qq.global.mark12_classc;
import saki.qq.datapacket.pack.packagea.mark16_classg;

class mark18_classg extends mark16_classg {
    final /* synthetic */ friendlist_getTroopMemberList a;

    private mark18_classg(friendlist_getTroopMemberList mark18_classf) {
        this.a = mark18_classf;
    }

    /* synthetic */ mark18_classg(friendlist_getTroopMemberList mark18_classf, mark18_classg mark18_classg) {
        this(mark18_classf);
    }

    public void writeTo(JceOutputStream mark2_classf) {
        mark2_classf.a(mark12_classc.c, 0);
        mark2_classf.a(this.a.a, 1);
        mark2_classf.a(0, 2);
        mark2_classf.a(this.a.a, 3);
        mark2_classf.a(2, 4);
    }
}
