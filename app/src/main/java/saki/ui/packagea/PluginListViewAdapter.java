package saki.ui.packagea;

import android.content.*;
import android.content.pm.*;
import android.text.method.*;
import android.view.*;
import android.widget.*;
import com.ayzf.sqv8.*;
import com.setqq.plugin.*;
import java.util.*;
import saki.ui.*;
import saki.ui.packageb.*;

public class PluginListViewAdapter extends BaseAdapter implements mark23_classc
  {
    public final ArrayList a = new ArrayList ( );
    private final LayoutInflater b;
    private final mark22_classi c = new mark22_classi ( this );
    private final PluginListView d;

    public PluginListViewAdapter ( Context context, PluginListView mark21_classj )
	  {
        this.b = LayoutInflater.from ( context );
        this.d = mark21_classj;
	  }

    /* renamed from: a */
    public mark6_classa getItem ( int i )
	  {
        return (mark6_classa) this.a.get ( i );
	  }

    public void a ( )
	  {
        this.a.clear ( );
        this.c.a ( );
	  }

    public void a ( mark6_classa mark6_classa )
	  {

        this.c.a ( mark6_classa );
	  }

    public void b ( mark6_classa mark6_classa )
	  {
        a ( mark6_classa );
	  }

    public int getCount ( )
	  {
        return this.a.size ( );
	  }

    public long getItemId ( int i )
	  {
        return (long) i;
	  }


	public static HashMap<String,Boolean> state = new HashMap<> ( );


    public View getView ( int i, View view, ViewGroup viewGroup )
	  {
        mark22_classh mark22_classh;
		final mark6_classa a2 = getItem ( i );

        if ( view == null )
		  {
            mark22_classh mark22_classh2 = new mark22_classh ( this );
            view = this.b.inflate ( R.layout.layout_item_plugin, (ViewGroup) null );
            mark22_classh2.a = view.findViewById ( R.id.id002a );
            mark22_classh2.b = view.findViewById ( R.id.id0052 );
            mark22_classh2.c = view.findViewById ( R.id.id0053 );
            mark22_classh2.d = view.findViewById ( R.id.id0056 );

			if ( a2.sinfo != null )
			  {
				mark22_classh2.d.setBackgroundResource ( R.drawable.bg_green_boll );
			  }

            mark22_classh2.e = view.findViewById ( R.id.id0054 );
            mark22_classh2.e.setMovementMethod ( ScrollingMovementMethod.getInstance ( ) );
            mark22_classh2.f = view.findViewById ( R.id.layoutitempluginSwitch1 );
            view.setTag ( mark22_classh2 );
            mark22_classh = mark22_classh2;
		  }
		else
		  {
            mark22_classh = (mark22_classh) view.getTag ( );
		  }

		if ( a2.sinfo == null )//老插件
		  {
			if ( a2.f == null )
			  {
				mark22_classh.a.setImageResource ( R.drawable.drawable0064 );
			  }
			else
			  {
				mark22_classh.a.setImageDrawable ( a2.f );
			  }
		  }
		else//新插件
		  {
			try
			  {
				PackageManager packageManager = view.getContext ( ).getPackageManager ( );  
				ApplicationInfo applicationInfo = packageManager.getApplicationInfo ( a2.sinfo [ 4 ], 0 );
				mark22_classh.a.setImageDrawable ( packageManager.getApplicationIcon ( applicationInfo ) );
			  }
			catch (Exception e)
			  {
				e.printStackTrace ( );
				mark22_classh.a.setImageResource ( R.drawable.qq );
			  }
		  }

		if ( a2.sinfo == null )//老插件
		  {
			mark22_classh.b.setText ( a2.a );//插件名称
			mark22_classh.c.setText ( a2.c );//插件作者
			mark22_classh.d.setText ( a2.d );//插件版本
			mark22_classh.e.setText ( a2.e );//插件简介

			mark22_classh.f.setChecked ( a2.i );
		  }
		else
		  {
			mark22_classh.b.setText ( a2.sinfo [ 0 ] );//插件名称
			mark22_classh.c.setText ( a2.sinfo [ 2 ] );//插件作者
			mark22_classh.d.setText ( a2.sinfo [ 1 ] );//插件版本
			mark22_classh.e.setText ( a2.sinfo [ 3 ] );//插件简介

			mark22_classh.f.setChecked ( a2.i = this.state.getOrDefault ( a2.sinfo [ 4 ], false ) );
		  }

        mark22_classh.f.setOnCheckedChangeListener ( a2 );

        return view;
	  }
  }
