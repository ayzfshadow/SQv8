package saki.qq.datapacket.pack.packagea;

import com.qq.taf.jce.JceInputStream;
import java.util.ArrayList;

public class mark16_classb extends mark16_classc {
    public long a;
    public long b;
    public ArrayList c = new ArrayList();

    public void readFrom(JceInputStream mark2_classd) {
        this.a = mark2_classd.read(Long.MAX_VALUE, 1, true);
        this.b = mark2_classd.read(Long.MAX_VALUE, 2, true);
        this.c.add(new mark16_classa());
        this.c = (ArrayList) mark2_classd.readobj((Object) this.c, 3, true);
    }
}
