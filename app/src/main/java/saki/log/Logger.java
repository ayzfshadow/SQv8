package saki.log;

import java.util.ArrayList;
import java.util.Iterator;
import saki.ui.mark21_classc;

public class Logger {
    public static ArrayList a = new ArrayList();
    private static ArrayList b = new ArrayList();

    private static void a(int i, Object obj) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < b.size()) {
                ((mark21_classc) b.get(i3)).a(i, obj);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public static void a(Object obj) {
        a.add("<font color=\"red\">[错误]" + obj.toString() + "</font>");
        a(1, obj);
    }

    public static void a(mark21_classc mark21_classc) {
        b.add(mark21_classc);
    }

    public static void b(Object obj) {
        a.add("<font color=\"green\">[信息]" + obj.toString() + "</font>");
        a(0, obj);
    }

    public static void b(mark21_classc mark21_classc) {
        Iterator it = b.iterator();
        while (it.hasNext()) {
            if (it.next() == mark21_classc) {
                it.remove();
                return;
            }
        }
    }

    public static void c(Object obj) {
        a.add("<font color=\"white\">" + obj.toString() + "</font>");
        a(3, obj);
    }

    public static void d(Object obj) {
        a.add("<font color=\"yellow\">[警告]" + obj.toString() + "</font>");
        a(2, obj);
    }
}
