package saki.ui.packagea;

import android.os.Handler;
import android.os.Message;
import com.setqq.plugin.mark6_classa;
import java.util.Iterator;

class mark22_classi extends Handler {
    final /* synthetic */ PluginListViewAdapter a;

    mark22_classi(PluginListViewAdapter mark22_classg) {
        this.a = mark22_classg;
    }

    private void b(mark6_classa mark6_classa) {
        Iterator it = this.a.a.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((mark6_classa) it.next()).b.equals(mark6_classa.b)) {
                    it.remove();
                    break;
                }
            } else {
                break;
            }
        }
        this.a.a.add(mark6_classa);
    }

    public void a() {
        Message obtain = Message.obtain();
        obtain.what = 1;
        sendMessage(obtain);
    }

    public void a(mark6_classa mark6_classa) {
        Message obtain = Message.obtain();
        obtain.obj = mark6_classa;
        obtain.what = 0;
        sendMessage(obtain);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 0) {
            b((mark6_classa) message.obj);
            this.a.notifyDataSetChanged();
        } else if (message.what == 1) {
            this.a.notifyDataSetChanged();
        } else {
            mark6_classa mark6_classa = (mark6_classa) message.obj;
            Iterator it = this.a.a.iterator();
            while (it.hasNext()) {
                if (((mark6_classa) it.next()).equals(mark6_classa)) {
                    it.remove();
                    this.a.notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}
