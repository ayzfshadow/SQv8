package saki.qq.datapacket.pack.send;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import saki.qq.global.mark12_classc;
import saki.qq.datapacket.pack.ByteWriter;
import saki.qq.datapacket.pack.packageb.Protobuff;
import saki.qq.datapacket.pack.send.packagea.mark19_classd;

public class MessageSvc_PbSendMsg extends T0B01 {
    private static int i = new Random().nextInt(9999);
    public long a = -1;
    public long b = -1;
    public long c = -1;
    public int d = 1;
    public ArrayList e = new ArrayList();

    public MessageSvc_PbSendMsg(int i2, long j, long j2, long j3) {
        super("MessageSvc.PbSendMsg");
        setSeq(i2);
        this.a = j;
        this.c = j2;
        this.b = j3;
        if (j3 != -1) {
            if (j2 != -1) {
                this.d = 3;
            } else {
                this.d = 1;
            }
        } else if (j == -1) {
            this.d = 2;
        } else {
            this.d = 4;
        }
    }

    public static final int b_() {
        int i2 = i;
        i = i2 + 1;
        return i2;
    }

    private byte[] i() {
        if (this.d != 3) {
            return this.d == 1 ? Protobuff.writeLengthDelimit(1, Protobuff.writeLengthDelimit(1, Protobuff.writeVarint(1, this.b))) : this.d == 2 ? Protobuff.writeLengthDelimit(1, Protobuff.writeLengthDelimit(2, Protobuff.writeVarint(1, this.c))) : Protobuff.writeLengthDelimit(1, Protobuff.writeLengthDelimit(4, Protobuff.writeVarint(1, this.a)));
        }
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writePb(1, this.c);
        mark15_classa.writePb(2, this.b);
        return Protobuff.writeLengthDelimit(1, Protobuff.writeLengthDelimit(3, mark15_classa.getDataAndDestroy()));
    }

    private byte[] j() {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writePb(1, (long) (this.d == 1 ? 0 : 1));
        mark15_classa.writePb(2, 0);
        mark15_classa.writePb(3, 0);
        return Protobuff.writeLengthDelimit(2, mark15_classa.getDataAndDestroy());
    }

    public void a(mark19_classd mark19_classd) {
        if (mark19_classd != null) {
            this.e.add(mark19_classd);
        }
    }

    /* access modifiers changed from: protected */
    public byte[] getContent() {
        ByteWriter mark15_classa = new ByteWriter();
        mark15_classa.writeBytes(i());
        mark15_classa.writeBytes(j());
        ByteWriter mark15_classa2 = new ByteWriter();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            mark15_classa2.writeBytes(((mark19_classd) it.next()).a());
        }
        mark15_classa.writeBytes(Protobuff.writeLengthDelimit(3, Protobuff.writeLengthDelimit(1, mark15_classa2.getDataAndDestroy())));
        mark15_classa.writePb(4, (long) b_());
        mark15_classa.writePb(5, (long) Math.abs(new Random().nextInt()));
        if (this.d == 3 || this.d == 1) {
            mark15_classa.writeBytes(Protobuff.writeLengthDelimit(6, mark12_classc.g));
        }
        int i2 = 3 - this.d;
        if (i2 < 0) {
            i2 = 0;
        }
        mark15_classa.writePb(8, (long) i2);
        return mark15_classa.getDataAndDestroy();
    }
}
