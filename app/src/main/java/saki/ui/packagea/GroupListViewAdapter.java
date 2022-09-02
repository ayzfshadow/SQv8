package saki.ui.packagea;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.ayzf.sqv8.R;
import java.util.ArrayList;
import java.util.Iterator;
import saki.qq.datapacket.pack.packagea.mark16_classe;
import saki.packaged.mark20_classc;

public class GroupListViewAdapter extends BaseAdapter {
    private final LayoutInflater a;
    private final mark22_classz b = new mark22_classz(this);
    private final ArrayList c = new ArrayList();

    public GroupListViewAdapter(Context context) {
        this.a = LayoutInflater.from(context);
    }

    private mark16_classe b(long j) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            mark16_classe mark16_classe = (mark16_classe) it.next();
            if (mark16_classe.b == j) {
                return mark16_classe;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void b(mark16_classe mark16_classe) {
        if (!this.c.contains(mark16_classe)) {
            this.c.add(mark16_classe);
            notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public boolean b(long j, Bitmap bitmap) {
        mark16_classe b2 = b(j);
        if (b2 == null) {
            return false;
        }
        b2.h = bitmap;
        notifyDataSetChanged();
        return true;
    }

    /* access modifiers changed from: private */
    public boolean c(long j) {
        mark16_classe b2 = b(j);
        if (b2 == null) {
            return false;
        }
        b2.g++;
        notifyDataSetChanged();
        return true;
    }

    /* renamed from: a */
    public mark16_classe getItem(int i) {
        return (mark16_classe) this.c.get(i);
    }

    public void a() {
        this.c.clear();
    }

    public void a(long j) {
        this.b.a(j);
    }

    public void a(long j, Bitmap bitmap) {
        this.b.a(j, bitmap);
    }

    public void a(mark16_classe mark16_classe) {
        this.b.a(mark16_classe);
    }

    public int getCount() {
        return this.c.size();
    }

    public long getItemId(int i) {
        mark16_classe a2 = getItem(i);
        if (a2 == null) {
            return 0;
        }
        return a2.b;
    }

    public int getItemViewType(int i) {
        return getItem(i).f;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        mark22_classy mark22_classy;
        if (view == null) {
            mark22_classy mark22_classy2 = new mark22_classy(this);
            view = this.a.inflate(R.layout.layout_item_group, (ViewGroup) null);
            mark22_classy2.a = (ImageView) view.findViewById(R.id.id002a);
            mark22_classy2.d = (TextView) view.findViewById(R.id.id0057);
            mark22_classy2.c = (TextView) view.findViewById(R.id.id0058);
            mark22_classy2.b = (TextView) view.findViewById(R.id.id002b);
            mark22_classy2.e = (Switch) view.findViewById(R.id.layoutitemgroupSwitch1);
			
            view.setTag(mark22_classy2);
            mark22_classy = mark22_classy2;
        } else {    
            mark22_classy = (mark22_classy) view.getTag();
        }
        mark16_classe a2 = getItem(i);
        if (a2 != null) {
            mark22_classy.d.setText(String.valueOf(a2.g));
            if (a2.h != null) {
                mark22_classy.a.setImageBitmap(a2.h);
            } else {
                mark22_classy.a.setImageResource(R.drawable.drawable0061);
                if (!a2.i) {
                    a2.i = true;
                    mark20_classc.a(new StringBuilder(String.valueOf(a2.b)).toString(), getItemViewType(i), new mark22_classx(this, a2));
                }
            }
            mark22_classy.c.setText(String.valueOf(a2.b));
            mark22_classy.b.setText(a2.c);
			mark22_classy.e.setOnCheckedChangeListener(a2);
            mark22_classy.e.setChecked(a2.j);
            
        }
        return view;
    }

    public int getViewTypeCount() {
        return 2;
    }
}
