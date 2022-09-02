package saki.qq.datapacket.pack.send;

import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import saki.qq.datapacket.pack.packagea.mark16_classg;

class mark18_classay extends mark16_classg {
    final /* synthetic */ VisitorSvc_ReqFavorite a;

    private mark18_classay(VisitorSvc_ReqFavorite mark18_classax) {
        this.a = mark18_classax;
    }

    /* synthetic */ mark18_classay(VisitorSvc_ReqFavorite mark18_classax, mark18_classay mark18_classay) {
        this(mark18_classax);
    }

    public void writeTo(JceOutputStream mark2_classf) {
        mark2_classf.a((JceStruct) new mark18_classaz(this.a, (mark18_classaz) null), 0);
        mark2_classf.a(this.a.a, 1);
        mark2_classf.a(0, 2);
        mark2_classf.a(5, 3);
        mark2_classf.a(this.a.b, 4);
    }
}
