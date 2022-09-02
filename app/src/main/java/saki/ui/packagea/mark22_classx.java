package saki.ui.packagea;

import android.graphics.Bitmap;
import saki.qq.datapacket.pack.packagea.mark16_classe;
import saki.packaged.mark20_classb;

class mark22_classx implements mark20_classb {
    final /* synthetic */ GroupListViewAdapter a;
    private final /* synthetic */ mark16_classe b;

    mark22_classx(GroupListViewAdapter mark22_classw, mark16_classe mark16_classe) {
        this.a = mark22_classw;
        this.b = mark16_classe;
    }

    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            this.a.a(this.b.b, bitmap);
        }
    }
}
