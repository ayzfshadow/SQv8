package saki.qq.datapacket.pack.send;

import com.qq.taf.jce.JceOutputStream;
import java.util.ArrayList;
import saki.qq.datapacket.pack.packagea.mark16_classg;

class mark18_classj extends mark16_classg {
    ArrayList a = new ArrayList();
    final /* synthetic */ friendlist_ModifyGroupCardReq b;
    private long c;
    private String d;

    public mark18_classj(friendlist_ModifyGroupCardReq mark18_classh, long j, String str) {
        this.b = mark18_classh;
        this.c = j;
        this.d = str;
    }

    public void writeTo(JceOutputStream mark2_classf) {
        mark2_classf.a(this.c, 0);
        mark2_classf.a(1, 1);
        mark2_classf.a(this.d, 2);
        mark2_classf.a((byte) -1, 3);
        mark2_classf.a("", 4);
        mark2_classf.a("", 5);
        mark2_classf.a("", 6);
    }
}
