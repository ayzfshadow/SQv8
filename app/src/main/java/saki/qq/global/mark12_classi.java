package saki.qq.global;

import android.annotation.*;
import android.content.*;
import android.content.pm.*;
import android.graphics.drawable.*;
import android.os.*;
import com.ayzf.sqv8.*;
import com.saki.aidl.*;
import com.setqq.plugin.*;
import com.setqq.plugin.sdk.*;
import dalvik.system.*;
import java.util.*;
import saki.log.*;
import saki.qq.datapacket.unpack.*;
import saki.ui.packageb.*;
import saki.client.SQApplication;

@SuppressLint({"NewApi"})
public class mark12_classi implements mark23_classb
  {
    private static final mark12_classi c = new mark12_classi ( );


    private ArrayList e = new ArrayList ( );
    private mark23_classc f;

    public static IPlugin a ( Context context, String str, String str2 )
	  {
        try
		  {
            return (IPlugin) new PathClassLoader ( str, context.getClassLoader ( ) ).loadClass ( str2 ).newInstance ( );
		  }
        catch (Throwable th)
		  {
            Logger.a ( (Object) "无法加载类:" + str2 + " " + th.getMessage ( ) );
            return null;
		  }
	  }

    public static mark12_classi a ( )
	  {
        return c;
	  }

    public static void a ( Context context, String str )
	  {
        PackageManager packageManager = context.getPackageManager ( );
        String str2 = null;
        try
		  {
            PackageInfo packageInfo = packageManager.getPackageInfo ( str, 0 );
            String str3 = (String) packageInfo.applicationInfo.loadLabel ( packageManager );
            try
			  {
                mark6_classc mark6_classc = new mark6_classc ( context, str3, str, packageInfo.versionName );
                Intent intent = new Intent ( "saki.setqq.v8.plugin" );
                intent.setPackage ( str );
                context.bindService ( intent, mark6_classc, 1 );
			  }
            catch (Exception e2)
			  {
                Exception exc = e2;
                str2 = str3;

			  }
		  }
        catch (Exception e)
		  {

            Logger.d ( "插件" + str2 + "启动失败!" + e.toString ( ) );
		  }
	  }

    public static void c ( Context context )
	  {
        for ( ResolveInfo resolveInfo : context.getPackageManager ( ).queryIntentServices ( new Intent ( "saki.setqq.v8.plugin" ), 0 ) )
		  {
            a ( context, resolveInfo.serviceInfo.packageName );
		  }
	  }

    public static void d ( final Context context )
	  {
        String string;
        a ( ).b ( context );
        if ( a ( ).f != null )
		  {
            a ( ).f.a ( );
		  }
        a ( ).a ( context );
        PackageManager packageManager = context.getPackageManager ( );
        for ( PackageInfo next : packageManager.getInstalledPackages ( 8320 ) )
		  {
            Bundle bundle = next.applicationInfo.metaData;
            if ( !( bundle == null || ( string = bundle.getString ( "class" ) ) == null ) )
			  {
                String string2 = bundle.getString ( "author", "佚名" );
                String str = next.versionName;
                String string3 = bundle.getString ( "info", "暂无说明" );
                Drawable loadIcon = next.applicationInfo.loadIcon ( packageManager );
                String str2 = (String) next.applicationInfo.loadLabel ( packageManager );
                boolean z = bundle.getBoolean ( "jump", false );
                try
				  {
                    final IPlugin a2 = a ( context, next.applicationInfo.sourceDir, string );
                    if ( a2 != null )
					  {
                        new Handler ( Looper.getMainLooper ( ) ).post ( new Runnable ( ){
							  @Override
							  public void run ( )
                                {
								  a2.onLoad ( context, new mark6_classb ( context ) );
                                }
                            } );
                        new mark6_classa ( context, next.packageName, str2, string2, str, string3, z, loadIcon, a2 );
					  }
				  }
                catch (Exception e2)
				  {
                    Logger.a ( (Object) "插件" + str2 + "加载失败!" + e2 );
				  }
			  }
		  }


		if ( SQApplication.getServer ( ) != null )//让插件推送插件信息
		  {
			SQApplication.getServer ( ).send ( 0x01 );
		  }
	  }

//    public static void d(Context context) {
//        String string;
//        a().b(context);
//        if (a().f != null) {
//            a().f.a();
//        }
//        a().a(context);
//        PackageManager packageManager = context.getPackageManager();
//        for (PackageInfo next : packageManager.getInstalledPackages(8320)) {
//            Bundle bundle = next.applicationInfo.metaData;
//            if (!(bundle == null || (string = bundle.getString("class")) == null)) {
//                String string2 = bundle.getString("author", "佚名");
//                String str = next.versionName;
//                String string3 = bundle.getString("info", "暂无说明");
//                Drawable loadIcon = next.applicationInfo.loadIcon(packageManager);
//                String str2 = (String) next.applicationInfo.loadLabel(packageManager);
//                boolean z = bundle.getBoolean("jump", false);
//                try {
//                    IPlugin a2 = a(context, next.applicationInfo.sourceDir, string);
//                    if (a2 != null) {
//                        a2.onLoad(context, new mark6_classb(context));
//                        new mark6_classa(context, next.packageName, str2, string2, str, string3, z, loadIcon, a2);
//                    }
//                } catch (Exception e2) {
//                    Logger.a((Object) "插件" + str2 + "加载失败!" + e2);
//                }
//            }
//        }
//    }


    public void a ( Context context )
	  {

	  }

    public void a ( mark6_classa mark6_classa )
	  {
        if ( this.f != null )
		  {
            this.f.b ( mark6_classa );
		  }
        this.e.add ( mark6_classa );
	  }

    public void a ( mark14_classah mark14_classah )
	  {
        DebugLogger.a ( this, "系统消息:" + mark14_classah.b + ":" + mark14_classah.e );
        Iterator it = this.e.iterator ( );
        while ( it.hasNext ( ) )
		  {
            mark6_classa mark6_classa = (mark6_classa) it.next ( );
            if ( mark6_classa.i )
			  {
                PluginMsg pluginMsg = new PluginMsg ( );
                pluginMsg.type = 3;
                pluginMsg.groupid = mark14_classah.b;
                pluginMsg.uin = mark14_classah.c;
                pluginMsg.groupName = mark14_classah.g;
                pluginMsg.time = mark14_classah.i;
                pluginMsg.uinName = mark14_classah.f;
                pluginMsg.code = mark14_classah.a;
                pluginMsg.addMsg ( "msg", mark14_classah.e );
                if ( !( mark14_classah.d == 0 || mark14_classah.h == null ) )
				  {
                    pluginMsg.addMsg ( "inviter", String.valueOf ( mark14_classah.d ) + "@" + mark14_classah.h );
				  }
                mark6_classa.a ( pluginMsg );
			  }
		  }
	  }

    public void a ( ReMessageSvc_PbGetMsg mark14_classl )
	  {
        Iterator it = mark14_classl.a.iterator ( );
        while ( it.hasNext ( ) )
		  {
            mark14_classm mark14_classm = (mark14_classm) it.next ( );
            if ( mark14_classm.h == 166 || mark14_classm.h == 141 )
			  {
                DebugLogger.a ( this, mark14_classm.toString ( ) );
                if ( ProtocolInfo.enableprivatemessagereply )
				  {
                    Iterator it2 = this.e.iterator ( );
                    while ( it2.hasNext ( ) )
					  {
                        mark6_classa mark6_classa = (mark6_classa) it2.next ( );
                        if ( mark6_classa.i && mark14_classm.d != mark12_classc.c )
						  {
                            PluginMsg pluginMsg = new PluginMsg ( );
                            if ( mark14_classm.h == 166 || mark14_classm.c == 0 )
							  {
                                pluginMsg.type = 1;
							  }
                            else
							  {
                                pluginMsg.type = 4;
							  }
                            pluginMsg.groupid = mark14_classm.b;
                            pluginMsg.uin = mark14_classm.d;
                            pluginMsg.code = mark14_classm.c;
                            pluginMsg.uinName = mark14_classm.k;
                            pluginMsg.addMsg ( "msg", mark14_classm.g );
                            pluginMsg.time = mark14_classm.a;
                            mark6_classa.a ( pluginMsg );
						  }
					  }
				  }
			  }
		  }
	  }

    public void a ( ReOnlinePush_PbPushDisMsg mark14_classv )
	  {
        if ( ProtocolInfo.enabledismessagereply && mark14_classv.a != 1000000 )
		  {
            Iterator it = this.e.iterator ( );
            while ( it.hasNext ( ) )
			  {
                mark6_classa mark6_classa = (mark6_classa) it.next ( );
                if ( mark6_classa.i && mark14_classv.a != mark12_classc.c )
				  {
                    PluginMsg pluginMsg = new PluginMsg ( );
                    pluginMsg.type = 2;
                    pluginMsg.groupid = mark14_classv.c;
                    pluginMsg.groupName = mark14_classv.d;
                    pluginMsg.uin = mark14_classv.a;
                    pluginMsg.uinName = mark14_classv.e;
                    pluginMsg.setData ( mark14_classv.j );
                    pluginMsg.time = mark14_classv.i;
                    pluginMsg.title = mark14_classv.g;
                    mark6_classa.a ( pluginMsg );
				  }
			  }
		  }
	  }

    public void a ( ReOnlinePush_PbPushGroupMsg mark14_classw )
	  {
        if ( mark14_classw.a != 1000000 )
		  {
            long b2 = mark12_classk.a ( ).b ( mark14_classw.c );
            Iterator it = this.e.iterator ( );
            while ( it.hasNext ( ) )
			  {
                mark6_classa mark6_classa = (mark6_classa) it.next ( );
                if ( mark6_classa.i && mark12_classk.a ( ).a ( mark14_classw.c ) && mark14_classw.a != mark12_classc.c )
				  {
                    PluginMsg pluginMsg = new PluginMsg ( );
                    pluginMsg.type = 0;
                    pluginMsg.code = b2;
                    pluginMsg.groupid = mark14_classw.c;
                    pluginMsg.groupName = mark14_classw.d;
                    pluginMsg.uin = mark14_classw.a;
                    pluginMsg.uinName = mark14_classw.e;
                    pluginMsg.setData ( mark14_classw.j );
                    pluginMsg.time = mark14_classw.i;
                    pluginMsg.title = mark14_classw.g;
                    mark6_classa.a ( pluginMsg );
				  }
			  }
		  }
	  }

    public void a ( ReOnlinePush_PbPushTransMsg mark14_classx )
	  {
	  }

    public void a ( mark23_classc mark23_classc )
	  {
        this.f = mark23_classc;
	  }





    public void b ( Context context )
	  {
        Iterator it = this.e.iterator ( );
        while ( it.hasNext ( ) )
		  {
            mark6_classa mark6_classa = (mark6_classa) it.next ( );
            if ( mark6_classa.h != null )
			  {
                context.unbindService ( mark6_classa.h );
			  }
		  }
        this.e.clear ( );
	  }


  }
