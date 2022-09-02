package saki.client.packagea;

import android.content.Context;
import android.content.Intent;
import java.util.HashMap;
import saki.client.SQService;

public class mark9_classa
{

	public static Intent sendRequireDeviceUnlockCode(Context context,String toString)
	{
		Intent intent = new Intent(context, SQService.class);
		intent.putExtra("verify",toString);
        intent.putExtra("cmd", 102);
        return intent;
	}
    public static Intent a(Context context) {
        Intent intent = new Intent(context, SQService.class);
        intent.putExtra("cmd", 10);
        return intent;
    }

    public static Intent a(Context context, long j) {
        Intent intent = new Intent(context, SQService.class);
        intent.putExtra("cmd", 12);
        intent.putExtra("group", j);
        return intent;
    }

    public static Intent a(Context context, long j, int i) {
        Intent intent = new Intent(context, SQService.class);
        intent.putExtra("cmd", 7);
        intent.putExtra("uin", j);
        intent.putExtra("count", i);
        return intent;
    }

    public static Intent a(Context context, long j, long j2) {
        Intent intent = new Intent(context, SQService.class);
        intent.putExtra("cmd", 6);
        intent.putExtra("group", j);
        intent.putExtra("uin", j2);
        return intent;
    }

    public static Intent a(Context context, long j, long j2, int i) {
        Intent intent = new Intent(context, SQService.class);
        intent.putExtra("cmd", 8);
        intent.putExtra("group", j);
        intent.putExtra("uin", j2);
        intent.putExtra("time", i);
        return intent;
    }

    public static Intent a(Context context, long j, long j2, long j3, boolean z) {
        Intent intent = new Intent(context, SQService.class);
        intent.putExtra("cmd", 11);
        intent.putExtra("group", j);
        intent.putExtra("reqid", j2);
        intent.putExtra("uin", j3);
        intent.putExtra("agree", z);
        return intent;
    }

    public static Intent a(Context context, long j, long j2, String str) {
        Intent intent = new Intent(context, SQService.class);
        intent.putExtra("cmd", 5);
        intent.putExtra("group", j);
        intent.putExtra("uin", j2);
        intent.putExtra("card", str);
        return intent;
    }

    public static Intent a(Context context, long j, long j2, HashMap hashMap) {
        Intent intent = new Intent(context, SQService.class);
        intent.putExtra("cmd", 4);
        intent.putExtra("group", j);
        intent.putExtra("uin", j2);
        intent.putExtra("data", hashMap);
        return intent;
    }

    public static Intent a(Context context, long j, String str, boolean z) {
        Intent intent = new Intent(context, SQService.class);
        intent.putExtra("cmd", 0);
        intent.putExtra("qq", j);
        intent.putExtra("password", str);
        intent.putExtra("login", z);
        return intent;
    }

    public static Intent a(Context context, long j, HashMap hashMap) {
        Intent intent = new Intent(context, SQService.class);
        intent.putExtra("cmd", 4);
        intent.putExtra("id", j);
        intent.putExtra("data", hashMap);
        return intent;
    }

    public static Intent a(Context context, long j, boolean z) {
        Intent intent = new Intent(context, SQService.class);
        intent.putExtra("cmd", 9);
        intent.putExtra("group", j);
        intent.putExtra("open", z);
        return intent;
    }

    public static Intent a(Context context, String str) {
        Intent intent = new Intent(context, SQService.class);
        intent.putExtra("cmd", 1);
        intent.putExtra("verify", str);
        return intent;
    }
	
	public static Intent sendRequireDeviceUnlock(Context context) {
        Intent intent = new Intent(context, SQService.class);
        intent.putExtra("cmd", 101);
        return intent;
    }
    public static Intent b(Context context) {
        Intent intent = new Intent(context, SQService.class);
        intent.putExtra("cmd", 2);
        return intent;
    }
}
