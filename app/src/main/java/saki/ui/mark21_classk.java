package saki.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.setqq.plugin.mark6_classa;

class mark21_classk implements DialogInterface.OnClickListener {
    final /* synthetic */ PluginListView a;
    private final /* synthetic */ mark6_classa b;

    mark21_classk(PluginListView mark21_classj, mark6_classa mark6_classa) {
        this.a = mark21_classj;
        this.b = mark6_classa;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.intent.action.DELETE");
        intent.setData(Uri.parse("package:" + this.b.b));
        this.a.getContext().startActivity(intent);
    }
}
