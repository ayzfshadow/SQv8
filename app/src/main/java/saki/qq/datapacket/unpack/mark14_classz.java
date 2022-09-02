package saki.qq.datapacket.unpack;

import com.qq.taf.jce.JceInputStream;
import java.util.ArrayList;
import saki.qq.global.mark12_classc;
import saki.qq.datapacket.pack.packagea.mark16_classc;

public class mark14_classz extends mark16_classc {
    public ArrayList a = new ArrayList();

    public void readFrom(JceInputStream mark2_classd) {
        this.a.add(new mark14_classaa());
        this.a = (ArrayList) mark2_classd.readobj((Object) this.a, 2, true);
        mark12_classc.h = mark2_classd.read(Long.MAX_VALUE, 3, true);
    }
}
