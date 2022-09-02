package saki.qq.global;

import java.util.ArrayList;
import java.util.Iterator;
import saki.qq.datapacket.pack.packagea.mark16_classe;
import saki.ui.packageb.mark23_classd;

public class mark12_classk implements mark23_classd {
    private static mark12_classk b = new mark12_classk();
    private static ArrayList c = new ArrayList();
    public ArrayList a = new ArrayList();

    public static mark12_classk a() {
        return b;
    }

    public void a(long j, ArrayList arrayList) {
        Iterator it = b().iterator();
        while (it.hasNext()) {
            mark16_classe mark16_classe = (mark16_classe) it.next();
            if (mark16_classe.b == j) {
                mark16_classe.k = arrayList;
            }
        }
    }

    public void a(ArrayList arrayList) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            mark16_classe mark16_classe = (mark16_classe) it.next();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                mark16_classe mark16_classe2 = (mark16_classe) it2.next();
                if (mark16_classe.equals(mark16_classe2)) {
                    mark16_classe2.j = mark16_classe.j;
                    mark16_classe2.g = mark16_classe.g;
                }
            }
        }
        this.a = arrayList;
        Iterator it3 = c.iterator();
        while (it3.hasNext()) {
            ((mark23_classd) it3.next()).a(this.a);
        }
    }

    public void a(mark23_classd mark23_classd) {
        if (!c.contains(mark23_classd)) {
            c.add(mark23_classd);
        }
    }

    public boolean a(long j) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            mark16_classe mark16_classe = (mark16_classe) it.next();
            if (mark16_classe.b == j) {
                return mark16_classe.j;
            }
        }
        return false;
    }

    public long b(long j) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            mark16_classe mark16_classe = (mark16_classe) it.next();
            if (mark16_classe.b == j) {
                return mark16_classe.a;
            }
        }
        return j;
    }

    public ArrayList b() {
        return this.a;
    }

    public void b(mark23_classd mark23_classd) {
        c.remove(mark23_classd);
    }

    public ArrayList c(long j) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            mark16_classe mark16_classe = (mark16_classe) it.next();
            if (mark16_classe.b == j) {
                return mark16_classe.k;
            }
        }
        return null;
    }
}
