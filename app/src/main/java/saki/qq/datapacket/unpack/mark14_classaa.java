package saki.qq.datapacket.unpack;

import com.qq.taf.jce.JceInputStream;
import saki.qq.datapacket.pack.packagea.mark16_classc;

public class mark14_classaa extends mark16_classc {
    public long a;
    public int b;
    public byte[] c;

    public void readFrom(JceInputStream mark2_classd) {
        this.a = mark2_classd.read(Long.MAX_VALUE, 0, true);
        this.b = mark2_classd.read(Short.MAX_VALUE, 3, true);
        this.c = mark2_classd.read(new byte[0], 8, true);
    }
}
