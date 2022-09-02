package saki.ui;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.*;
import androidx.appcompat.widget.*;
import androidx.viewpager.widget.*;
import com.ayzf.sqv8.*;
import com.google.android.material.tabs.*;
import com.mcsqnxa.common.*;
import com.saki.aidl.*;
import java.util.*;
import saki.client.*;
import saki.client.packagea.*;
import saki.qq.global.*;
import saki.ui.packageb.*;
import saki.ui.packagec.*;

import androidx.appcompat.widget.Toolbar;
import com.setqq.plugin.*;

public class PagerActivity extends AppCompatActivity implements mark23_classa,LocalServer.IReceive
  {
    public GroupListView groupListView;
    public PluginListView pluginListView;

    public LogView c;
    Handler e = new mark21_classh ( this );
    /* access modifiers changed from: private */
    public final LinkedList<View> viewlist = new LinkedList<> ( ); /* access modifiers changed from: private */
    public final String[] titles = {"群列表", "插件列表", "运行日志"};
    private long h;

    private ViewPager viewPager;

    public void a ( int i, byte[] bArr )
	  {
        if ( i == 7 )
		  {
            this.e.sendEmptyMessage ( 0 );
		  }
	  }

    /* access modifiers changed from: protected */
    public void onCreate ( Bundle bundle )
	  {
        super.onCreate ( bundle );
        this.groupListView = new GroupListView ( this );
        mark12_classh.a ( ).a ( (mark23_classb) this.groupListView );
        this.pluginListView = new PluginListView ( this );
        this.c = new LogView ( this );

        this.viewlist.add ( this.groupListView );
        this.viewlist.add ( this.pluginListView );
        this.viewlist.add ( this.c );
        setContentView ( R.layout.layout_activity_pageractivity );
        UiTool.setTransparent ( this );
        Toolbar y = this.findViewById ( R.id.layoutactivitypageractivityToolbar1 );
        this.setSupportActionBar ( y );
        this.viewPager = findViewById ( R.id.layoutactivitypageractivityViewPager1 );
        this.viewPager.setAdapter ( new PagerActivityAdapter ( this ) );
        TabLayout tablayout = ( (Activity)this ).findViewById ( R.id.layoutactivitypageractivityTabLayout1 );
		tablayout.setupWithViewPager ( this.viewPager );
        mark12_classh.a ( ).b ( (mark23_classa) this );
        startService ( mark9_classa.a ( this ) );

		if ( SQApplication.getServer ( ) == null )
		  {
			new Thread ( new Runnable ( ){
				  @Override
				  public void run ( )
					{
					  try
						{
						  SQApplication.setServer ( LocalServer.bind ( 29933 ) );
						  SQApplication.getServer ( ).startListener ( PagerActivity.this );

						  System.out.println ( "服务端初始化ok" );
						}
					  catch (Exception e)
						{
						  e.printStackTrace ( );
						}
					}
				} ).start ( );
		  }
	  }

	@Override
	public void onReceive ( LocalServer server, final Object data )
	  {
		try
		  {
			if ( data instanceof Integer )
			  {
				if ( (int)data == 0x00 )//插件与主程序握手
				  {
					server.send ( 0x01 );return;//获取插件信息
				  }
				else if ( (int)data == 0xFFFF )//心跳包,不需要处理
				  {
				    server.send(0x0000);
					return;
				  }
			  }
			else if ( data instanceof String[] )//插件推送插件信息到主程序
			  {
				new mark6_classa ( PagerActivity.this, (String[])data );return;
			  }
			else if ( data instanceof PluginMsg )
			  {
				new mark6_classb ( this ).send ( (PluginMsg)data );
				//new PluginApi ( ).send ( (Msg)data );
			  }

			new Handler ( Looper.getMainLooper ( ) ).post ( new Runnable ( ){
				  @Override
				  public void run ( )
					{
					  Toast.makeText ( PagerActivity.this, data.toString ( ), 0 ).show ( );
					}
				} );
		  }
		catch (Exception e)
		  {
			ShowToast.show ( this, e.toString ( ) );
			e.printStackTrace ( );
		  }
	  }















    /* access modifiers changed from: protected */
    public void onDestroy ( )
	  {
        this.groupListView.b ( );
        this.pluginListView.b ( );
        this.c.a ( );
        mark12_classh.a ( ).a ( (mark23_classa) this );
        super.onDestroy ( );
	  }

    public boolean onKeyDown ( int i, KeyEvent keyEvent )
	  {
        if ( i != 4 )
		  {
            return super.onKeyDown ( i, keyEvent );
		  }
        if ( System.currentTimeMillis ( ) - this.h > 2000 )
		  {
            Toast makeText = Toast.makeText ( this, "再按一次，退出程序", 0 );
            makeText.setGravity ( 17, 0, 0 );
            makeText.show ( );
            this.h = System.currentTimeMillis ( );
		  }
        else
		  {
            stopService ( new Intent ( this, SQService.class ) );
            finish ( );
            System.exit ( 0 );
		  }
        return true;
	  }
  }
