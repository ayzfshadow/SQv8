package com.saki.packagea;

import java.util.HashMap;
import java.util.Iterator;

public class mark3_classa {
    private HashMap a = new HashMap();

    public boolean a(String str) {
        if (!str.contains("=")) {
            return false;
        }
        int indexOf = str.indexOf("=");
        String replaceAll = str.substring(0, indexOf).replaceAll(" ", "");
        String substring = str.substring(indexOf + 1, str.indexOf(";"));
        if (substring.equals("")) {
            return false;
        }
        this.a.put(replaceAll, substring);
        return true;
    }

    public String toString() {
        String str = "";
        Iterator it = this.a.keySet().iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            String str3 = (String) it.next();
            str = String.valueOf(str2) + str3 + "=" + ((String) this.a.get(str3)) + ";";
        }
    }
}
