package saki.qq.datapacket.pack.send;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import saki.qq.global.DeviceInfo;
import saki.qq.global.mark12_classb;
import saki.qq.global.mark12_classc;

class mark18_classas extends JceStruct {
    final /* synthetic */ mark18_classar a;

    mark18_classas(mark18_classar mark18_classar) {
        this.a = mark18_classar;
    }

    public void readFrom(JceInputStream mark2_classd) {
    }

    public void writeTo(JceOutputStream mark2_classf) {
        mark2_classf.a(mark12_classc.c, 0);
        mark2_classf.a(7, 1);
        mark2_classf.a(0, 2);
        mark2_classf.a("", 3);
        mark2_classf.a(11, 4);
        mark2_classf.a(0, 5);
        mark2_classf.a(0, 6);
        mark2_classf.a(0, 7);
        mark2_classf.a(0, 8);
        mark2_classf.a(0, 9);
        mark2_classf.a(0, 10);
        mark2_classf.a(16, 11);
        mark2_classf.a(1, 12);
        mark2_classf.a("", 13);
        mark2_classf.a(0, 14);
        mark2_classf.a(mark12_classb.a, 16);
        mark2_classf.a(2052, 17);
        mark2_classf.a(0, 18);
        mark2_classf.a(DeviceInfo.deviceName, 19);
        mark2_classf.a(DeviceInfo.deviceName, 20);
        mark2_classf.a(DeviceInfo.androidVersion, 21);
        mark2_classf.a(1, 22);
        mark2_classf.a(149, 23);
        mark2_classf.a(0, 24);
        mark2_classf.a(0, 26);
        mark2_classf.a(0, 27);
    }
}
