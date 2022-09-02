package saki.qq.global;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import saki.log.DebugLogger;
import saki.qq.datapacket.unpack.mark14_classah;
import saki.qq.datapacket.unpack.ReMessageSvc_PbGetMsg;
import saki.qq.datapacket.unpack.mark14_classm;
import saki.qq.datapacket.unpack.ReOnlinePush_PbPushDisMsg;
import saki.qq.datapacket.unpack.ReOnlinePush_PbPushGroupMsg;
import saki.qq.datapacket.unpack.ReOnlinePush_PbPushTransMsg;
import saki.ui.packageb.mark23_classa;
import saki.ui.packageb.mark23_classb;

public class mark12_classh implements mark23_classa, mark23_classb {
    private static final mark12_classh a = new mark12_classh();
    private List<mark23_classb> b = new CopyOnWriteArrayList<mark23_classb>();
    private List<mark23_classa> c = new CopyOnWriteArrayList<mark23_classa>();

    public mark12_classh() {
        a((mark23_classb) mark12_classi.a());
    }

    public static mark12_classh a() {
        return a;
    }

    public void a(int i, byte[] bArr) {
        for (mark23_classa a2 : this.c) {
            a2.a(i, bArr);
        }
    }

    public void a(mark14_classah mark14_classah) {
        for (mark23_classb a2 : this.b) {
            a2.a(mark14_classah);
        }
    }

    public void a(ReMessageSvc_PbGetMsg mark14_classl) {
        long j = 0;
        Iterator it = mark14_classl.a.iterator();
        mark14_classm mark14_classm = null;
        while (it.hasNext()) {
            mark14_classm mark14_classm2 = (mark14_classm) it.next();
            if (mark14_classm2.h == 166 || (mark14_classm2.h == 141 && mark14_classm2.a > j)) {
                j = mark14_classm2.a;
                mark14_classm = mark14_classm2;
            }
        }
        if (mark14_classm != null) {
            mark14_classl.a.clear();
            mark14_classl.a.add(mark14_classm);
        }
        for (mark23_classb a2 : this.b) {
            a2.a(mark14_classl);
        }
    }

    public void a(ReOnlinePush_PbPushDisMsg mark14_classv) {
        for (mark23_classb a2 : this.b) {
            a2.a(mark14_classv);
        }
        DebugLogger.a(this, "来自讨论组:[" + mark14_classv.d + "](" + mark14_classv.c + ")[" + "【" + mark14_classv.g + "】" + mark14_classv.e + "](" + mark14_classv.a + "):" + mark14_classv.j);
    }

    public void a(ReOnlinePush_PbPushGroupMsg mark14_classw) {
        for (mark23_classb a2 : this.b) {
            a2.a(mark14_classw);
        }
        DebugLogger.a(this, "来自群:[" + mark14_classw.d + "](" + mark14_classw.c + ")[" + "【" + mark14_classw.g + "】" + mark14_classw.e + "](" + mark14_classw.a + "):" + mark14_classw.j);
    }

    public void a(ReOnlinePush_PbPushTransMsg mark14_classx) {
        for (mark23_classb a2 : this.b) {
            a2.a(mark14_classx);
        }
    }

    public void a(mark23_classa mark23_classa) {
        this.c.remove(mark23_classa);
    }

    public void a(mark23_classb mark23_classb) {
        if (!this.b.contains(mark23_classb)) {
            this.b.add(mark23_classb);
        }
    }

    public void b(mark23_classa mark23_classa) {
        this.c.add(mark23_classa);
    }

    public void b(mark23_classb mark23_classb) {
        this.b.remove(mark23_classb);
    }
}
