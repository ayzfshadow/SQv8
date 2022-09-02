package saki.qq.datapacket.pack.send;

import com.qq.taf.jce.JceOutputStream;
import saki.toolkit.HexToolKit;
import saki.qq.global.mark12_classc;
import saki.qq.datapacket.pack.packagea.mark16_classg;

class mark18_classaz extends mark16_classg {
    final /* synthetic */ VisitorSvc_ReqFavorite a;

    private mark18_classaz(VisitorSvc_ReqFavorite mark18_classax) {
        this.a = mark18_classax;
    }

    /* synthetic */ mark18_classaz(VisitorSvc_ReqFavorite mark18_classax, mark18_classaz mark18_classaz) {
        this(mark18_classax);
    }

    public void writeTo(JceOutputStream mark2_classf) {
        mark2_classf.a(mark12_classc.c, 0);
        mark2_classf.a(1, 1);
        mark2_classf.a(this.a.c, 2);
        mark2_classf.a(1, 3);
        mark2_classf.a(0, 4);
        mark2_classf.a(HexToolKit.a("0C 18 00 01 06 01 31 16 01 35 "), 5);
    }
}
