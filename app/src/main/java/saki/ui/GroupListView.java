package saki.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.ayzf.sqv8.R;
import java.util.ArrayList;
import java.util.Iterator;
import saki.client.packagea.mark9_classa;
import saki.qq.global.mark12_classi;
import saki.qq.global.mark12_classk;
import saki.qq.datapacket.pack.packagea.mark16_classe;
import saki.qq.datapacket.unpack.mark14_classah;
import saki.qq.datapacket.unpack.ReMessageSvc_PbGetMsg;
import saki.qq.datapacket.unpack.ReOnlinePush_PbPushDisMsg;
import saki.qq.datapacket.unpack.ReOnlinePush_PbPushGroupMsg;
import saki.qq.datapacket.unpack.ReOnlinePush_PbPushTransMsg;
import saki.ui.packagea.GroupListViewAdapter;
import saki.ui.packageb.mark23_classb;
import saki.ui.packageb.mark23_classd;

public class GroupListView extends SQListView implements SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener, mark23_classb, mark23_classd 
{
    public GroupListViewAdapter groupListViewAdapter;
    public SwipeRefreshLayout swipeRefreshLayout;
    
    public GroupListView(Context context) {
        super(context, R.layout.layout_view_grouplistview);
        
    }

    /* access modifiers changed from: protected */
    

    @Override public void onRefresh() {
        getContext().startService(mark9_classa.b(getContext()));
        new Handler().postDelayed(new mark21_classaa(this), 15000);
    }

    public void a(long j) {
        this.groupListViewAdapter.a(j);
    }

    public void a(long j, ArrayList arrayList) {
    }

    public void a(ArrayList arrayList) {
        this.swipeRefreshLayout.setRefreshing(false);
        this.groupListViewAdapter.a();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.groupListViewAdapter.a((mark16_classe) it.next());
        }
    }

    public void a(mark14_classah mark14_classah) {
    }

    public void a(ReMessageSvc_PbGetMsg mark14_classl) {
    }

    public void a(ReOnlinePush_PbPushDisMsg mark14_classv) {
    }

    public void a(ReOnlinePush_PbPushGroupMsg mark14_classw) {
        a(mark14_classw.c);
    }

    public void a(ReOnlinePush_PbPushTransMsg mark14_classx) {
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"InlinedApi"})
    public ListView b(Context context) {
        ListView listView = findViewById(R.id.layoutviewgrouplistviewListView1);
        this.groupListViewAdapter = new GroupListViewAdapter(context);
        this.swipeRefreshLayout = findViewById(R.id.layoutviewgrouplistviewSwipeRefreshLayout1);
        //this.c.setColorSchemeResources(17170450, 17170454, 17170456, 17170452);
        this.swipeRefreshLayout.setOnRefreshListener(this);
        listView.setAdapter(this.groupListViewAdapter);
        listView.setOnItemClickListener(this);
        mark12_classk.a().a((mark23_classd) this);
        context.startService(mark9_classa.b(context));
        return listView;
    }

    
    
    
    public void onDestroy() {
        if (this.groupListViewAdapter != null) {
            mark12_classk.a().b((mark23_classd) this);
        }
        super.b();
    }

    

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        Intent intent = new Intent(getContext(), MessageActivity.class);
        intent.putExtra("id", j);
        getContext().startActivity(intent);
    }
}
