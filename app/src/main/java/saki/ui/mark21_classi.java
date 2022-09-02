package saki.ui;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;

class PagerActivityAdapter extends PagerAdapter
{

   
    
    final /* synthetic */ PagerActivity a;

    PagerActivityAdapter(PagerActivity pagerActivity) {
        this.a = pagerActivity;
    }

    @Override public int getCount() {
        return this.a.viewlist.size();
    }

    @Override public CharSequence getPageTitle(int i) {
        return this.a.titles[i];
    }

   @Override public Object instantiateItem(ViewGroup viewGroup, int i) {
       View view = (View) this.a.viewlist.get(i);
        viewGroup.addView(view);
        return view;
    }

   @Override public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
       viewGroup.removeView((View) this.a.viewlist.get(i));
    }

   @Override public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
