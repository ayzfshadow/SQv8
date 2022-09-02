//
// Decompiled by Jadx - 1012ms
//
package com.setqq.plugin.sdk;

import android.content.Context;
import com.saki.aidl.PluginMsg;

public interface IPlugin
{
    void onLoad(Context context, API api);

    void onMessageHandler(PluginMsg pluginMsg);
}