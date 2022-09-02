package saki.qq.datapacket.pack.send.packagea;

import saki.client.mark8_classa;
import saki.qq.global.ImgStore;
import saki.qq.datapacket.pack.send.MessageSvc_PbSendMsg;

public abstract class mark19_classd implements Comparable {
    private int a;

    private static mark19_classd a(mark8_classa mark8_classa, int i, int i2, MessageSvc_PbSendMsg mark18_classt, String str, String str2) {
        switch (str.hashCode()) {
            case 3123:
                if (str.equals("at")) {
                    String[] split = str2.split("@");
                    if (split.length == 2) {
                        return new mark19_classa("@" + split[1], Long.parseLong(split[0])).a(i2);
                    }
                }
                break;
            case 104387:
                if (str.equals("img")) {
                    ImgStore b = str2.indexOf("http") == 0 ? ImgStore.b(str2) : ImgStore.a(str2);
                    if (b != null) {
                        new mark19_classe(mark8_classa, i, i2, mark18_classt, b).a();
                        break;
                    }
                }
                break;
            case 108417:
                if (str.equals("msg")) {
                    return new mark19_classf(str2).a(i2);
                }
                break;
            case 118807:
                if (str.equals("xml")) {
                    return new mark19_classg(str2).a(i2);
                }
                break;
            case 3271912:
                if (str.equals("json")) {
                    return new mark19_classc(str2).a(i2);
                }
                break;
        }
        return null;
    }

    public static void a(mark8_classa mark8_classa, MessageSvc_PbSendMsg mark18_classt, int i, int i2, String str, String str2) {
        mark18_classt.a(a(mark8_classa, i, i2, mark18_classt, str, str2));
        if (mark18_classt.e.size() == i) {
            mark8_classa.b(mark18_classt);
        }
    }

    /* renamed from: a */
    @Override  public int compareTo(Object mark19_classd) {
        return this.a - ((mark19_classd)mark19_classd).a;
    }

    public mark19_classd a(int i) {
        this.a = i;
        return this;
    }

    public abstract byte[] a();
}
