package com.setqq.plugin;

import com.saki.aidl.AppServiceInterface;
import com.saki.aidl.PluginMsg;

class mark6_classd extends AppServiceInterface.Stub {
    mark6_classb a;
    final /* synthetic */ PluginService b;

    mark6_classd(PluginService pluginService) {
        this.b = pluginService;
        this.a = new mark6_classb(pluginService);
    }

    public PluginMsg handlerMessage(PluginMsg pluginMsg) {
        return this.a.send(pluginMsg);
    }
}
