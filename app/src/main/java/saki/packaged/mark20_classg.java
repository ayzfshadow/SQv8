package saki.packaged;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.io.File;

public class mark20_classg {
    public static void a(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }
}
