package saki.qq.datapacket.pack.packagea;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public class mark16_classf extends JceStruct {
    long a;
    int b;
    public ArrayList c = new ArrayList();

    public void readFrom(JceInputStream mark2_classd) {
        this.a = mark2_classd.read(this.a, 0, true);
        this.b = mark2_classd.read(this.b, 1, true);
        this.c.add(new mark16_classe());
        this.c = (ArrayList) mark2_classd.readobj((Object) this.c, 5, true);
    }

    public void writeTo(JceOutputStream mark2_classf) {
    }
}
