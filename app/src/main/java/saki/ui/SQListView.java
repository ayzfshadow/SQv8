package saki.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.RelativeLayout;

public abstract class SQListView extends RelativeLayout {
    protected LayoutInflater a;
    
    private ListView c;

    public SQListView(Context context, int i) {
        super(context);
        this.a = LayoutInflater.from(context);
        this.a.inflate(i, this);
      
        this.c = b(context);
    }

    /* access modifiers changed from: protected */
    
    /* access modifiers changed from: protected */
    public abstract ListView b(Context context);

    public void b() {
        this.c = null;
        
        this.a = null;
    }

    public ListView getListView() {
        return this.c;
    }

    
}
