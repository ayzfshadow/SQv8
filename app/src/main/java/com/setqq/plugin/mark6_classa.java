package com.setqq.plugin;

import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.widget.*;
import com.ayzf.sqv8.*;
import com.saki.aidl.*;
import com.setqq.plugin.sdk.*;
import java.io.*;
import saki.log.*;
import saki.qq.global.*;
import saki.ui.packagea.*;
import saki.client.SQApplication;

public class mark6_classa implements CompoundButton.OnCheckedChangeListener
  {
    public String a;//插件名称
    public String b;//插件包名
    public String c;//插件作者
    public String d;//插件版本
    public String e;//插件简介
    public Drawable f;
    public IPlugin g;
    public mark6_classc h;
    public boolean i = false;
    public boolean j = false;
    private Context k;


	public String[] sinfo;

	public mark6_classa ( Context context, String[] info )
	  {
		this.k = context;
		this.b = info [ 4 ];
		this.sinfo = info;

		mark12_classi.a ( ).a ( this );
	  }


    public mark6_classa ( Context context, String str, String str2, String str3, mark6_classc mark6_classc )
	  {
        try
		  {
            this.k = context;
            this.b = str;
            this.a = str2;
            this.d = str3;
            this.h = mark6_classc;
            this.c = mark6_classc.a ( ).author ( );
            this.c = ( this.c == null || this.c.equals ( "" ) ) ? "佚名" : this.c;
            this.e = mark6_classc.a ( ).info ( );
            this.e = ( this.e == null || this.e.equals ( "" ) ) ? "暂无说明" : this.e;
            byte[] icon = mark6_classc.a ( ).icon ( );
            this.f = icon == null ? null : new BitmapDrawable ( context.getResources ( ), BitmapFactory.decodeByteArray ( icon, 0, icon.length ) );
            this.j = mark6_classc.a ( ).jump ( );
            this.i = a ( context ).getBoolean ( str, false );
            mark12_classi.a ( ).a ( this );
            Logger.b ( (Object) "插件" + str2 + "加载完成!" );
		  }
		catch (RemoteException e2)
		  {
            Logger.a ( (Object) "插件" + str2 + "加载失败!" );
		  }
	  }

    public mark6_classa ( Context context, String str, String str2, String str3, String str4, String str5, boolean z, Drawable drawable, IPlugin iPlugin )
	  {
        this.k = context;
        this.b = str;
        this.a = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = drawable;
        this.g = iPlugin;
        this.j = z;
        this.i = a ( context ).getBoolean ( this.b, false );
        mark12_classi.a ( ).a ( this );
        Logger.b ( (Object) "插件" + str2 + "加载完成!" );
	  }

    public static SharedPreferences a ( Context context )
	  {
        return context.getSharedPreferences ( "app_config", 0 );
	  }

    public void onCheckedChanged ( CompoundButton switchButton, boolean z )
	  {
        this.i = z;

		PluginListViewAdapter.state.put ( this.b, z );

        SharedPreferences.Editor edit = a ( this.k ).edit ( );
        edit.putBoolean ( this.b, this.i );
        edit.commit ( );
	  }

    public boolean a ( PluginMsg pluginMsg )
	  {
		if ( this.sinfo != null )
		  {
			if ( SQApplication.getServer ( ) != null )
			  {
				SQApplication.getServer ( ).send ( pluginMsg );
			  }
			
			return true;
		  }

        try
		  {
            if ( this.g != null )
			  {
                try
				  {
                    this.g.onMessageHandler ( pluginMsg );
                    return true;
				  }
				catch (Exception e2)
				  {
                    StringWriter stringWriter = new StringWriter ( );
                    PrintWriter printWriter = new PrintWriter ( stringWriter );
                    e2.printStackTrace ( printWriter );
                    Logger.a ( (Object) stringWriter.toString ( ) );
                    printWriter.close ( );
				  }
			  }
			else
			  {
                if ( this.h != null )
				  {
                    try
					  {
                        this.h.a ( ).onMessageHandler ( pluginMsg );
                        return true;
					  }
					catch (Exception e3)
					  {
                        StringWriter stringWriter2 = new StringWriter ( );
                        PrintWriter printWriter2 = new PrintWriter ( stringWriter2 );
                        e3.printStackTrace ( printWriter2 );
                        Logger.a ( (Object) stringWriter2.toString ( ) );
                        printWriter2.close ( );
                        try
						  {
                            this.k.unbindService ( this.h );
						  }
						catch (Exception e4)
						  {
						  }
                        mark12_classi.a ( this.k, this.b );
					  }
				  }
                return false;
			  }
		  }
		catch (Exception e5)
		  {
            Logger.a ( (Object) String.valueOf ( this.a ) + "发生异常:" + e5.getMessage ( ) );
            return false;
		  }
        return false;
	  }
  }
