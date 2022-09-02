package saki.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

class LogViewAdapter extends BaseAdapter implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ LogView a;
    private ArrayList b = new ArrayList();

    LogViewAdapter(LogView mark21_classp) {
        this.a = mark21_classp;
    }

    /* renamed from: a */
    public mark21_classr getItem(int i) {
        return (mark21_classr) this.b.get(i);
    }

    public void a(mark21_classr mark21_classr) {
        this.b.add(mark21_classr);
        notifyDataSetChanged();
    }

    public Spanned b(mark21_classr mark21_classr) {
        String str = "white";
        String str2 = "";
        switch (mark21_classr.a) {
            case 0:
                str = "white";
                str2 = "[信息]";
                break;
            case 1:
                str = "white";
                str2 = "[错误]";
                break;
            case 2:
                str = "white";
                str2 = "[警告]";
                break;
        }
        return Html.fromHtml("<font color=\"" + str + "\">" + str2 + mark21_classr.b + "</font>");
    }

    public int getCount() {
        return this.b.size();
    }
    
    public void clean(){
        this.b=new ArrayList();
        super.notifyDataSetChanged();
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        mark21_classt mark21_classt;
        RelativeLayout relativeLayout;
        if (view == null) {
            relativeLayout = new RelativeLayout(viewGroup.getContext());
            mark21_classt mark21_classt2 = new mark21_classt(this);
            mark21_classt2.a = new TextView(relativeLayout.getContext());
            relativeLayout.addView(mark21_classt2.a);
            relativeLayout.setTag(mark21_classt2);
            mark21_classt = mark21_classt2;
        } else {
            mark21_classt = (mark21_classt) view.getTag();
            relativeLayout = (RelativeLayout) view;
        }
        mark21_classt.a.setText(b(getItem(i)));
        return relativeLayout;
    }

    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        ((ClipboardManager) this.a.a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("msg", getItem(i).b));
        Toast.makeText(this.a.a, "复制完成", 0).show();
        return false;
    }
}
