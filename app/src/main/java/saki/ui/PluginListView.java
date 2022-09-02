package saki.ui;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.ayzf.sqv8.R;
import com.setqq.plugin.mark6_classa;
import saki.client.packagea.mark9_classa;
import saki.qq.global.mark12_classi;
import saki.ui.packagea.PluginListViewAdapter;
import saki.ui.packageb.mark23_classc;

public class PluginListView extends SQListView implements SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener 
{
    public PluginListViewAdapter b;
    public SwipeRefreshLayout c;

    public PluginListView(Context context) {
        super(context, R.layout.layout_view_pluginlistview);
    }

    private void a(String str) {
        if (str != null && !str.equals("")) {
            try {
                Intent intent = new Intent("saki.setqq.plugin.v8.main");
                intent.setPackage(str);
                getContext().startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "此插件没有主界面", 0).show();
            }
        }
    }

    /* access modifiers changed from: protected */
    

    public void onRefresh() {
        mark12_classi.d(this.getContext());
        mark12_classi.c(this.getContext());
        this.c.setRefreshing(false);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"InlinedApi"})
    public ListView b(Context context) {
        ListView listView = findViewById(R.id.id0074);
        this.b = new PluginListViewAdapter(context, this);
        this.c = findViewById(R.id.id0073);
        //this.c.setColorSchemeResources(17170450, 17170454, 17170456, 17170452);
        this.c.setOnRefreshListener(this);
        listView.setAdapter(this.b);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
        mark12_classi.a().a((mark23_classc) this.b);
        return listView;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mark6_classa a = this.b.getItem(i);
		
		
		
		
        if (a.j) {
            a(a.b);
        }
    }

    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        mark6_classa a = this.b.getItem(i);
        if (a.b == null || a.b.equals("")) {
            Toast.makeText(getContext(), "此插件无法卸载", 0).show();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("卸载提示");
            builder.setMessage("确定要卸载[" + a.a + "]吗？");
            builder.setNegativeButton("取消", (DialogInterface.OnClickListener) null);
            builder.setPositiveButton("卸载", new mark21_classk(this, a));
            builder.show();
        }
        return true;
    }
}
