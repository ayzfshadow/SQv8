package saki.ui.packagea;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import saki.packaged.mark20_classc;
import com.ayzf.sqv8.R;

public class mark22_classb extends BaseAdapter {
    private static final int[] a = {R.layout.layout0020, R.layout.layout001e};
    private final ArrayList b = new ArrayList();
    private final SimpleDateFormat c = new SimpleDateFormat("dd-HH:mm:ss");
    private final LayoutInflater d;
    private final ListView e;
    /* access modifiers changed from: private */
    public final mark22_classe f = new mark22_classe(this);
    private final HashMap g = new HashMap();

    public mark22_classb(Context context, ListView listView) {
        this.d = LayoutInflater.from(context);
        this.e = listView;
    }

    /* access modifiers changed from: private */
    public void a(int i, Bitmap bitmap) {
        if (bitmap != null && i < this.b.size()) {
            mark22_classd mark22_classd = (mark22_classd) this.b.get(i);
            mark22_classd.a = bitmap;
            this.g.put(Long.valueOf(mark22_classd.d), bitmap);
            notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public void a(mark22_classd mark22_classd) {
        this.b.add(mark22_classd);
        notifyDataSetChanged();
        this.e.setSelection(this.e.getCount() - 1);
    }

    /* renamed from: a */
    public mark22_classd getItem(int i) {
        return (mark22_classd) this.b.get(i);
    }

    public void a(Bitmap bitmap, String str, long j, long j2, String str2, boolean z) {
        mark22_classd mark22_classd = new mark22_classd(this);
        mark22_classd.a = bitmap == null ? (Bitmap) this.g.get(Long.valueOf(j)) : bitmap;
        mark22_classd.d = j;
        mark22_classd.e = str;
        mark22_classd.c = this.c.format(new Date(j2));
        mark22_classd.b = str2;
        mark22_classd.f = z;
        this.f.a(mark22_classd);
    }

    public int getCount() {
        return this.b.size();
    }

    public long getItemId(int i) {
        return ((mark22_classd) this.b.get(i)).d;
    }

    public int getItemViewType(int i) {
        return getItem(i).f ? 0 : 1;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        mark22_classf mark22_classf;
        if (view == null) {
            mark22_classf mark22_classf2 = new mark22_classf(this);
            view = this.d.inflate(a[getItemViewType(i)], (ViewGroup) null);
            mark22_classf2.b = (TextView) view.findViewById(R.id.id0046);
            mark22_classf2.a = (ImageView) view.findViewById(R.id.id002a);
            mark22_classf2.c = (TextView) view.findViewById(R.id.id0051);
            mark22_classf2.d = (TextView) view.findViewById(R.id.id0045);
            view.setTag(mark22_classf2);
            mark22_classf = mark22_classf2;
        } else {
            mark22_classf = (mark22_classf) view.getTag();
        }
        mark22_classd a2 = getItem(i);
        if (a2 != null) {
            if (a2.a != null) {
                mark22_classf.a.setImageBitmap(a2.a);
            } else {
                mark22_classf.a.setImageResource(R.drawable.drawable0060);
                if (!a2.g) {
                    a2.g = true;
                    mark20_classc.a(new StringBuilder(String.valueOf(a2.d)).toString(), 1, new mark22_classc(this, i));
                }
            }
            mark22_classf.b.setText(a2.b);
            mark22_classf.c.setText(a2.c);
            mark22_classf.d.setText(a2.e);
        }
        return view;
    }

    public int getViewTypeCount() {
        return a.length;
    }
}
