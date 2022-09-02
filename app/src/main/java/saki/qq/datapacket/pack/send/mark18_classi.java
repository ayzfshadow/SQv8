package saki.qq.datapacket.pack.send;

import com.qq.taf.jce.JceOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import saki.qq.datapacket.pack.packagea.mark16_classg;

class mark18_classi extends mark16_classg {
    final /* synthetic */ friendlist_ModifyGroupCardReq a;
    private ArrayList b = new ArrayList();
    private long c;

    public mark18_classi(friendlist_ModifyGroupCardReq mark18_classh, long j, long j2, String str) {
        this.a = mark18_classh;
        this.c = j;
        this.b.add(new mark18_classj(mark18_classh, j2, str));
    }

    public void writeTo(JceOutputStream mark2_classf) {
        mark2_classf.a(0, 0);
        mark2_classf.a(this.c, 1);
        mark2_classf.a(0, 2);
        mark2_classf.a((Collection) this.b, 3);
    }
}
