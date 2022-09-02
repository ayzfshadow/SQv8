package saki.ui.packagec;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

public class UiTool
{
    public static Bitmap big(Bitmap bitmap,float h) { 
        Matrix matrix = new Matrix(); 
        matrix.postScale(h,h); //长和宽放大缩小的比例 
        Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true); 
        return resizeBmp; 
    }
    public static void setTransparent(Activity activity) {
        Activity activity2 = activity;
        if (Build.VERSION.SDK_INT >= 19) {
            transparentStatusBar(activity2);
            setRootView(activity2);
        }
    }

    @TargetApi(19)
    private static void transparentStatusBar(Activity activity) {
        Activity activity2 = activity;
        if (Build.VERSION.SDK_INT >= 21) {
            activity2.getWindow().addFlags(Integer.MIN_VALUE);
            activity2.getWindow().clearFlags(0x04000000);
            activity2.getWindow().addFlags(0x08000000);
            activity2.getWindow().setStatusBarColor(0);
            return;
        }
        activity2.getWindow().addFlags(0x04000000);
    }

    private static void setRootView(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(0x01020002);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(true);
                ((ViewGroup) childAt).setClipToPadding(true);
            }
        }
    }

    
}
