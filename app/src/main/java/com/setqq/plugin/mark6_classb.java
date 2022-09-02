package com.setqq.plugin;

import android.content.Context;
import com.saki.aidl.PluginMsg;
import com.setqq.plugin.sdk.API;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import saki.client.packagea.mark9_classa;
import saki.log.Logger;
import saki.qq.global.mark12_classc;
import saki.qq.global.mark12_classk;
import saki.qq.datapacket.pack.packagea.mark16_classa;
import saki.qq.datapacket.pack.packagea.mark16_classe;

public class mark6_classb implements API {
    private Context a;

    public mark6_classb(Context context) {
        this.a = context;
    }

    public PluginMsg send(PluginMsg pluginMsg) {
        boolean z = true;
        if (!(pluginMsg.type == 0 || pluginMsg.getData().get("img") == null)) {
            ((ArrayList) pluginMsg.getData().get("img")).clear();
        }
        switch (pluginMsg.type) {
            case 0:
                this.a.startService(mark9_classa.a(this.a, pluginMsg.groupid, -1, pluginMsg.getData()));
                break;
            case 1:
                this.a.startService(mark9_classa.a(this.a, -1, pluginMsg.uin, pluginMsg.getData()));
                break;
            case 2:
                this.a.startService(mark9_classa.a(this.a, pluginMsg.groupid, pluginMsg.getData()));
                break;
            case 4:
                if (pluginMsg.uin >= 9999 && pluginMsg.code >= 9999) {
                    this.a.startService(mark9_classa.a(this.a, pluginMsg.code, pluginMsg.uin, pluginMsg.getData()));
                    break;
                } else {
                    return null;
                }
            case 5:
                ArrayList b = mark12_classk.a().b();
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                Iterator it = b.iterator();
                while (it.hasNext()) {
                    arrayList.add(new StringBuilder(String.valueOf(((mark16_classe) it.next()).b)).toString());
                }
                hashMap.put("troop", arrayList);
                pluginMsg.setData(hashMap);
                return pluginMsg;
            case 7:
                ArrayList c = mark12_classk.a().c(pluginMsg.groupid);
                HashMap hashMap2 = new HashMap();
                ArrayList arrayList2 = new ArrayList();
                Iterator it2 = c.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new StringBuilder(String.valueOf(((mark16_classa) it2.next()).a)).toString());
                }
                hashMap2.put("member", arrayList2);
                pluginMsg.setData(hashMap2);
                return pluginMsg;
            case 8:
                this.a.startService(mark9_classa.a(this.a, pluginMsg.uin, pluginMsg.value));
                break;
            case 9:
                this.a.startService(mark9_classa.a(this.a, pluginMsg.groupid, pluginMsg.uin, pluginMsg.title));
                break;
            case 10:
                this.a.startService(mark9_classa.a(this.a, pluginMsg.groupid, pluginMsg.uin, pluginMsg.value));
                break;
            case 11:
                this.a.startService(mark9_classa.a(this.a, pluginMsg.groupid, pluginMsg.value == 0));
                break;
            case 12:
                this.a.startService(mark9_classa.a(this.a, pluginMsg.groupid, pluginMsg.uin));
                break;
            case 13:
                Context context = this.a;
                Context context2 = this.a;
                long j = pluginMsg.groupid;
                long j2 = pluginMsg.code;
                long j3 = pluginMsg.uin;
                if (pluginMsg.value != 0) {
                    z = false;
                }
                context.startService(mark9_classa.a(context2, j, j2, j3, z));
                break;
            case 15:
                pluginMsg.uin = mark12_classc.c;
                return pluginMsg;
            default:
                Logger.c(pluginMsg.getTextMsg());
                break;
        }
        return null;
    }
}
