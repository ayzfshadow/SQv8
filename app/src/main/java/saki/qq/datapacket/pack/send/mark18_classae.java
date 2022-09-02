package saki.qq.datapacket.pack.send;

import com.qq.taf.jce.JceOutputStream;
import java.util.Collection;
import saki.qq.global.mark12_classc;
import saki.qq.datapacket.pack.packagea.mark16_classg;

class mark18_classae extends mark16_classg {
    final /* synthetic */ OnlinePush_RespPush a;

    mark18_classae(OnlinePush_RespPush mark18_classad) {
        this.a = mark18_classad;
    }

    public void writeTo(JceOutputStream mark2_classf) {
        mark2_classf.a(mark12_classc.c, 0);
        mark2_classf.a((Collection) this.a.a, 1);
        mark2_classf.a((int) mark12_classc.h, 2);
    }
}
