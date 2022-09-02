package saki.packaged;

import java.lang.reflect.Array;

public class mark20_classi {
    Object[] a;
    int b;

    public mark20_classi(Class cls, int i) {
        this.a = (Object[]) Array.newInstance(cls, i);
    }

    public void a(Object obj) {
        Object[] objArr = this.a;
        int i = this.b;
        this.b = i + 1;
        objArr[i] = obj;
        if (this.b == this.a.length) {
            this.b = 0;
        }
    }

    public boolean b(Object obj) {
        int i = 0;
        while (i < this.a.length) {
            if (this.a[i] == null || !this.a[i].equals(obj)) {
                i++;
            } else {
                this.a[i] = null;
                return false;
            }
        }
        a(obj);
        return true;
    }
}
