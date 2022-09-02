package saki.ui;

import android.os.Message;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.ayzf.sqv8.R;
import java.util.Iterator;
import saki.log.Logger;

public class LogView extends RelativeLayout implements androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
{

    
    PagerActivity a;
    LogViewAdapter b;
    SwipeRefreshLayout swp;
    mark21_classc c = new mark21_classq(this);
    private ListView d;

    public LogView(PagerActivity pagerActivity) {
        super(pagerActivity);
        this.a = pagerActivity;
        this.b = new LogViewAdapter(this);
        LayoutInflater.from(pagerActivity).inflate(R.layout.layout_view_logview, this);
        this.d = (ListView) findViewById(R.id.id003c);
        this.swp=this.findViewById(R.id.layoutviewlogviewSwipeRefreshLayout1);
        this.swp.setOnRefreshListener(this);
        this.d.setAdapter(this.b);
        this.d.setOnItemLongClickListener(this.b);
        Iterator it = Logger.a.iterator();
        while (it.hasNext()) {
            //this.c.sendMessage(Message.obtain(this.c, 0, (String) it.next()));
        }
        Logger.a(this.c);
    }

    public void a() {
        Logger.b(this.c);
    }
    
    @Override
    public void onRefresh()
    {
        this.b.clean();
        this.swp.setRefreshing(false);
    }
    
}
