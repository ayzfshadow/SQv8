package saki.qq.datapacket.pack.packagea;

import com.qq.taf.jce.JceInputStream;

public class mark16_classa extends mark16_classc {
    public long a;
    public String b;
    public String c;
    public String d;

    public void readFrom(JceInputStream mark2_classd) {
        this.a = mark2_classd.read(Long.MAX_VALUE, 0, true);
        this.b = mark2_classd.read("", 4, true);
        this.c = mark2_classd.read("", 8, true);
        this.d = mark2_classd.read("", 23, true);
    }
}
