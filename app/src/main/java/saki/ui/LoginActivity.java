package saki.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import com.ayzf.sqv8.R;
import com.ayzf_shadow.Activity.AuthorityActivity;
import com.ayzf_shadow.tool.Tea;
import com.ayzf_shadow.tool.notice;
import com.setqq.packagea.mark5_classb;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import saki.client.SQService;
import saki.client.packagea.mark9_classa;
import saki.qq.datapacket.pack.send.wtlogin_login;
import saki.qq.global.DeviceInfo;
import saki.qq.global.ProtocolInfo;
import saki.qq.global.mark12_classh;
import saki.toolkit.Code;
import saki.ui.packageb.mark23_classa;
import saki.ui.packagec.UiTool;
import saki.ui.packagec.mark24_classa;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener
{
    public EditText account;
    public EditText password;
    private notice hit;
    public Button loginbutton;
    private Button author;
    public ProgressBar progres;
    public ImageView header;
    public CheckBox i;

    long j = 0;
    
    public static final String verAYZF = "8";
    
    public static String applMd5 = "";

    private LoginResultHandler m = new LoginResultHandler(this, (LoginResultHandler) null);

    public void requireDeviceUnlockCodeAgain()
    {
        final EditText edit = new EditText(this);
        final AlertDialog.Builder normalDialog = 
            new AlertDialog.Builder(this);
        normalDialog.setView(edit);
        normalDialog.setTitle("需要验证登录保护");

        normalDialog.setMessage("输入密保手机收到的短信验证码");

        normalDialog.setPositiveButton("确定", 
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    if (!edit.getText().toString().isEmpty())
                    {
                        startService(mark9_classa.sendRequireDeviceUnlockCode(LoginActivity.this,edit.getText().toString()));

                        //NewLoginActivity.this.resetInputStatus();
                    }
                    else
                    {
                        a("放弃登陆");
                        dialog.dismiss();
                    }
                }
            });
        normalDialog.setNegativeButton("关闭", 
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    //NewLoginActivity.this.resetInputStatus();
                    a("放弃登陆");
                    ProtocolInfo.unlockRequireSent=false;
                    dialog.dismiss();
                }
            });
        normalDialog.setNeutralButton("重新发送", 
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    //NewLoginActivity.this.resetInputStatus();
                    startService(mark9_classa.sendRequireDeviceUnlock(LoginActivity.this));
                }
            });
        // 显示
        AlertDialog a=normalDialog.create();
        a.setCanceledOnTouchOutside(false);
        a.setCancelable(false);
        // 显示
        a.show();
    }



    public void requireDeviceUnlock(String string)
    {
        final AlertDialog.Builder normalDialog = 
            new AlertDialog.Builder(this);
        normalDialog.setTitle("需要验证登陆保护");
        normalDialog.setMessage("是否发送验证码到手机\n" + string);
        normalDialog.setPositiveButton("确定", 
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    startService(mark9_classa.sendRequireDeviceUnlock(LoginActivity.this));
                }
            });
        normalDialog.setNegativeButton("关闭", 
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    a("放弃登陆");
                    ProtocolInfo.unlockRequireSent=false;
                    dialog.dismiss();
                }
            });
        AlertDialog a=normalDialog.create();
        a.setCanceledOnTouchOutside(false);
        a.setCancelable(false);
        // 显示
        a.show();
    }

    public void requireDeviceUnlockCode()
    {
        final EditText edit = new EditText(this);
        final AlertDialog.Builder normalDialog = 
            new AlertDialog.Builder(this);
        normalDialog.setView(edit);
        normalDialog.setTitle("需要验证登录保护");

        normalDialog.setMessage("输入密保手机收到的短信验证码");

        normalDialog.setPositiveButton("确定", 
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    if (!edit.getText().toString().isEmpty())
                    {
                        startService(mark9_classa.sendRequireDeviceUnlockCode(LoginActivity.this,edit.getText().toString()));

                        //NewLoginActivity.this.resetInputStatus();
                    }
                    else
                    {
                        a("放弃登陆");
                        ProtocolInfo.unlockRequireSent=false;
                        dialog.dismiss();
                    }
                }
            });
        normalDialog.setNegativeButton("关闭", 
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    //NewLoginActivity.this.resetInputStatus();
                    a("放弃登陆");
                    ProtocolInfo.unlockRequireSent=false;
                    dialog.dismiss();
                }
            });
        normalDialog.setNeutralButton("重新发送", 
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    //NewLoginActivity.this.resetInputStatus();
                    startService(mark9_classa.sendRequireDeviceUnlock(LoginActivity.this));
                }
            });
        // 显示
        AlertDialog a=normalDialog.create();
        a.setCanceledOnTouchOutside(false);
        a.setCancelable(false);
        // 显示
        a.show();
	}

	public void toast(String string)
	{
		Toast.makeText(this,string,1).show();
	}

    private void a(String str, String str2)
    {
        SharedPreferences.Editor edit = getSharedPreferences("login", 0).edit();
        edit.putString("account", str);
        edit.putString("passWord", str2);
        edit.commit();
    }

    private void d()
    {
        boolean z = false;
        NetworkInfo[] allNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService("connectivity")).getAllNetworkInfo();
        int i2 = 0;
        while (true)
        {
            if (i2 >= allNetworkInfo.length)
            {
                break;
            }
            else if (allNetworkInfo[i2].getState() == NetworkInfo.State.CONNECTED)
            {
                z = true;
                break;
            }
            else
            {
                i2++;
            }
        }
        if (!z)
        {
            this.m.a(1, (byte[]) null);
        }
        else
        {

            startService(new Intent(this, SQService.class));
        }
        h();
    }


    private String getaccount()
    {
        return getSharedPreferences("login", 0).getString("account", "");
    }

    private String getpassword()
    {
        return getSharedPreferences("login", 0).getString("passWord", "");
    }

    private void h()
    {
        if (isrememberpassword())
        {

            this.i.setChecked(true);
            this.account.setText(getaccount());
            this.password.setText(getpassword());
            this.m.a(this.account.getText().toString(), true);
        }
        this.loginbutton.setOnClickListener(this);
        this.account.setOnFocusChangeListener(this);

        this.password.setTransformationMethod(new mark24_classa());
    }

    private boolean isrememberpassword()
    {
        return getSharedPreferences("login", 0).getBoolean("remember", false);
    }

    public void a()
    {
        this.loginbutton.setText("连接失败");
        this.loginbutton.setEnabled(false);
        this.progres.setVisibility(8);
    }

    public void a(Bitmap bitmap)
    {
        this.header.setImageBitmap(bitmap);
    }

    public void a(String str)
    {
        this.loginbutton.setText("登录");
        this.loginbutton.setEnabled(true);
        this.progres.setVisibility(8);
        if (str != null)
        {
            Toast.makeText(this, str, 1).show();
        }
    }

    public void showChaptcha(byte[] bArr)
    {
        new OtherWindow(this,
						new String(bArr),m);


    }

    public void b()
    {
        this.loginbutton.setText("登录中...");
        this.loginbutton.setEnabled(false);
        this.progres.setVisibility(0);
        a(this.account.getText().toString(), this.password.getText().toString());
    }

    public void c()
    {
        startActivity(new Intent(this, PagerActivity.class));
        finish();
    }

    public void onClick(View view)
    {
        if (view == this.loginbutton)
        {
            if (this.account.getText().toString() == null || this.account.getText().toString().isEmpty() || this.password.getText().toString() == null || this.password.getText().toString().isEmpty())
            {
                Toast.makeText(this, "不可以为空", 0).show();
                return;
            }
            ProtocolInfo.a(ProtocolInfo.a);
            b();
            startService(mark9_classa.a((Context) this, Long.parseLong(this.account.getText().toString()), this.password.getText().toString(), false));
            return;
        }
        SharedPreferences.Editor edit = getSharedPreferences("login", 0).edit();
        if (view == this.i)
        {
            edit.putBoolean("remember", this.i.isChecked());
            edit.commit();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        //Log.d("Fuck", "");
        setContentView(R.layout.layout_activity_loginactivity);
        //CK.initad(this);
        Toolbar toolbar = findViewById(R.id.layoutactivityloginactivityToolbar1);
        this.setSupportActionBar(toolbar);
		UiTool.setTransparent(this);

        this.header = findViewById(R.id.layoutactivityloginactivityImageViewHeader);
        this.account = findViewById(R.id.layoutactivityloginactivityEditTextAccount);
        this.password = findViewById(R.id.layoutactivityloginactivityEditTextPassword);
        this.progres = findViewById(R.id.layoutactivityloginactivityProgressBar1);
        this.loginbutton = findViewById(R.id.layoutactivityloginactivityAppCompatButtonLogin);
        this.author = findViewById(R.id.layoutactivityloginactivityAppCompatButtonAuthor);
        this.i = findViewById(R.id.id0040);

        this.initdeviceInfo();

        this.i.setOnClickListener(this);
        mark12_classh.a().b((mark23_classa) this.m);
        d();
        if (new mark5_classb(this).a())
        {
        }
        if (Build.VERSION.SDK_INT >= 23)
        {
            String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE","android.permission.READ_PHONE_STATE"};
            for (String checkSelfPermission : strArr)
            {
                if (checkSelfPermission(checkSelfPermission) != 0)
                {
                    requestPermissions(strArr, 302);
                }
            }
        }
        this.ffffff();//检验完整性/
        applMd5=wtlogin_login.appMd5(this);
        onlineversion(this);
        author.setOnClickListener(new OnClickListener()
            {
                @Override
                public void onClick(View p1)
                {
                    LoginActivity.this.startActivity(new Intent(LoginActivity.this,AuthorityActivity.class));
                }
            });
    }

    private void ffffff()
    {
        try
        {
            ProtocolInfo.crckey = Code.md5(getCRC1(this).getBytes());
            if (this.getResources().getString(R.string.string0056).equals(getCRC1(this)))
            {

            }
            else
            {
                Class<?> cls1 = Class.forName("java.lang.System");

                Method md1 =cls1.getDeclaredMethod("exit", int.class);


                // md1.invoke(null, 0);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }







    private String getCRC1(Context c)
    {
        try
        {
            Class zip =Class.forName("java.util.zip.ZipFile");
            Constructor<?> construct = zip.getConstructor(Class.forName("java.lang.String"));

            Class Context = Class.forName("android.content.Context");
            Method getPackageCodePath= Context.getDeclaredMethod("getPackageCodePath");
            String path = (String)getPackageCodePath.invoke(c);
            Object zipobj= construct.newInstance(path);

            Method getEntry = zip.getDeclaredMethod("getEntry", Class.forName("java.lang.String"));
            Object zipentryobj = getEntry.invoke(zipobj, "classes.dex");

            Class ZipEntry = Class.forName("java.util.zip.ZipEntry");
            Method getCrc = ZipEntry.getDeclaredMethod("getCrc");
            long crc = (long)getCrc.invoke(zipentryobj);

            //return 1148178540 + "";
            return crc + "";

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }

    public static void onlineversion(final AppCompatActivity a)
    {
        final android.app.ProgressDialog dialog = new android.app.ProgressDialog(a);
        dialog.setMessage("正在检查更新");
        dialog.setCancelable(false);
        dialog.show();
        new Thread
        (new Runnable()//创建子线程对象
            {
                @Override//超类
                public void run()//必要方法
                {
                    final String newversion=Tea.decrypt(AuthorityActivity.teaKey,AuthorityActivity.getUrlContent("http://ayzf.mcsq.cc/SQv8/UpdateV8.php?v=" + Tea.encrypt(AuthorityActivity.teaKey,verAYZF)));
                    a.runOnUiThread
                    (new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                if (newversion == null || newversion.equals(""))
                                {
                                    Toast.makeText(a, "连接服务器失败，无法检查更新", Toast.LENGTH_SHORT).show();
                                    final AlertDialog dialog = new AlertDialog.Builder(a)
                                        .setTitle("禁止使用")
                                        .setMessage("服务器连接失败，软件禁止使用，请选择重连或退出软件")
                                        .setNegativeButton("重连",null)
                                        .setPositiveButton("退出",null).create();
                                    dialog.setCancelable(false);
                                    dialog.show();
                                    dialog.getButton
                                    (AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View p1)
                                            {
                                                final android.app.ProgressDialog dialog2 = new android.app.ProgressDialog(a);
                                                dialog2.setMessage("正在尝试重连，请稍等");
                                                dialog2.setCancelable(true);
                                                dialog2.show();
                                                new Thread
                                                (new Runnable()//创建子线程对象
                                                    {
                                                        @Override//超类
                                                        public void run()//必要方法
                                                        {
                                                            final String status=AuthorityActivity.getUrlContent("http://ayzf.mcsq.cc/ShadowWarRobot/ShadowWarRobot.php?type=0");
                                                            a.runOnUiThread
                                                            (new Runnable()
                                                                {
                                                                    @Override
                                                                    public void run()
                                                                    {
                                                                        if (status == null || status.equals(""))
                                                                        {
                                                                            dialog2.dismiss();
                                                                            Toast.makeText(a, "连接服务器失败", Toast.LENGTH_SHORT).show();
                                                                        }
                                                                        else
                                                                        {
                                                                            dialog.dismiss();
                                                                            dialog2.dismiss();
                                                                            onlineversion(a);
                                                                            Toast.makeText(a, "连接成功", Toast.LENGTH_SHORT).show();
                                                                        }
                                                                    }
                                                                }
                                                            );
                                                            return;
                                                        }
                                                    }
                                                ).start();
                                            }
                                        }
                                    );
                                    dialog.getButton
                                    (AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener()
                                        {
                                            @Override
                                            public void onClick(View p1)
                                            {
                                                System.exit(0);
                                            }
                                        }
                                    );
                                }
                                else if (newversion.equals("6922"))
                                {
                                    Toast.makeText(a, "服务器不存在更新信息，请联系作者处理", Toast.LENGTH_SHORT).show();
                                }
                                else if (newversion.equals("9922"))
                                {
                                    dialog.dismiss();
                                    Toast.makeText(a, "当前版本已是最新版本", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    dialog.dismiss();
                                    Toast.makeText(a, "发现新版本，请立即更新", Toast.LENGTH_SHORT).show();
                                    try
                                    {
                                        JSONObject downloadurl1 = new JSONObject(newversion);
                                        final String downloadurl = downloadurl1.getString("downloadurl");
                                        JSONObject newversion1 = new JSONObject(newversion);
                                        String newversion2 = newversion1.getString("newversion");
                                        JSONObject newversionmessage1 = new JSONObject(newversion);
                                        String newversionmessage = newversionmessage1.getString("newversionmessage");
                                        JSONObject straightChain1 = new JSONObject(newversion);
                                        final String straightChain = straightChain1.getString("straightChain");
                                        final AlertDialog dialog2 = new AlertDialog.Builder(a)
                                            .setTitle("更新")
                                            .setMessage("发现新版：" + newversion2 + "\n更新内容如下：\n" + newversionmessage + "\n\n请立即更新，否则无法使用")
                                            .setNeutralButton("软件内更新",null)
                                            .setPositiveButton("浏览器更新",null).create();
                                        dialog2.setCancelable(false);
                                        dialog2.show();//显示对话框
                                        dialog2.getButton
                                        (AlertDialog.BUTTON_NEUTRAL).setOnClickListener(new View.OnClickListener()
                                            {
                                                @Override
                                                public void onClick(View p1)
                                                {
                                                    dialog2.getButton(AlertDialog.BUTTON_NEUTRAL).setText("准备下载……");
                                                    dialog2.getButton(AlertDialog.BUTTON_NEUTRAL).setEnabled(false);
                                                    dialog2.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
                                                    new Thread(){
                                                        public long size = 0;//已经下载字节数量
                                                        public int length;
                                                        public byte[] buffer = new byte[1024 * 1024];
                                                        public void run()
                                                        {
                                                            final File file = new File("/storage/emulated/0/Android/data/com.ayzf.sqv8/update.apk");
                                                            if (file.exists())
                                                            {
                                                                file.delete();
                                                            }
                                                            try
                                                            {
                                                                file.getParentFile().mkdirs();
                                                                file.createNewFile();
                                                                final InputStream is = new URL(straightChain).openStream();
                                                                final FileOutputStream fos = new FileOutputStream(file);
                                                                while ((length = is.read(buffer)) > 0)
                                                                {
                                                                    size+=length;
                                                                    a.runOnUiThread
                                                                    (new Runnable()
                                                                        {
                                                                            @Override
                                                                            public void run()
                                                                            {
                                                                                double length=(Math.round(size * 100 / 1024 / 1024) / 100.0);
                                                                                dialog2.getButton(AlertDialog.BUTTON_NEUTRAL).setText("正在下载(" + length + "MB)");
                                                                            }
                                                                        }
                                                                    );
                                                                    fos.write(buffer,0,length);
                                                                }
                                                                is.close();
                                                                fos.flush();
                                                                fos.close();
                                                                a.runOnUiThread
                                                                (new Runnable()
                                                                    {
                                                                        @Override
                                                                        public void run()
                                                                        {
                                                                            dialog2.getButton(AlertDialog.BUTTON_NEUTRAL).setText("开始安装");
                                                                            installApk(a,new File("/storage/emulated/0/Android/data/com.ayzf.sqv8/update.apk"));
                                                                        }
                                                                    }
                                                                );
                                                            }
                                                            catch (Exception e)
                                                            {}
                                                        }
                                                    }.start();
                                                }
                                            }
                                        );
                                        dialog2.getButton
                                        (AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener()
                                            {
                                                @Override
                                                public void onClick(View p1)
                                                {
                                                    Intent intent =new Intent();
                                                    intent.setAction("android.intent.action.VIEW");
                                                    Uri content_url =Uri.parse(downloadurl);
                                                    intent.setData(content_url);
                                                    a.startActivity(intent);
                                                }
                                            }
                                        );
                                    }
                                    catch (JSONException e)
                                    {}
                                }
                            }
                        }
                    );
                    return;
                }
            }
        ).start();
    }

    public static void installApk(Context context,File apk)//安装文件方法
    {
        if (context == null || !apk.isFile())
        {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT > 23)
        {
            Uri uri = FileProvider.getUriForFile(context,context.getPackageName(),apk);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(uri,"application/vnd.android.package-archive");
        }
        else
        {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.fromFile(apk),"application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }

    private void initdeviceInfo()
    {

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();
        //  Toast.makeText(this,sp.getString("appsettings_appid","null"),Toast.LENGTH_LONG).show();
        String kkk= sp.getString("devicesetting_devicename", null);
        if (kkk == null || kkk.isEmpty())
        {
            editor.putString("devicesetting_devicename", DeviceInfo.deviceName).commit();
        }
        kkk = sp.getString("devicesetting_devicecompany", null);
        if (kkk == null || kkk.isEmpty())
        {
            editor.putString("devicesetting_devicecompany", DeviceInfo.deviceCompany).commit();
        }
        kkk = sp.getString("devicesetting_imei", null);
        if (kkk == null || kkk.isEmpty())
        {
            editor.putString("devicesetting_imei", DeviceInfo.imei).commit();
        }
        kkk = sp.getString("devicesetting_wifi", null);
        if (kkk == null || kkk.isEmpty())
        {
            editor.putString("devicesetting_wifi", DeviceInfo.wifi).commit();
        }
        kkk = sp.getString("devicesetting_androidversion", null);
        if (kkk == null || kkk.isEmpty())
        {
            editor.putString("devicesetting_androidversion", DeviceInfo.androidVersion).commit();
        }
        DeviceInfo.androidVersion = sp.getString("devicesetting_androidversion", null);
        DeviceInfo.wifi = sp.getString("devicesetting_wifi", null);
        DeviceInfo.imei = sp.getString("devicesetting_imei", null);
        DeviceInfo.deviceCompany = sp.getString("devicesetting_devicecompany", null);
        DeviceInfo.deviceName = sp.getString("devicesetting_devicename", null);
        if (sp.getString("appsettings_appid", null) != null)
        {
            ProtocolInfo.appid = Long.parseLong(sp.getString("appsettings_appid", null));
        }

        ProtocolInfo.enabledismessagereply = sp.getBoolean("appsettings_replydiscussmessage", false);
        ProtocolInfo.enableprivatemessagereply = sp.getBoolean("appsettings_replyprivatemessage", false);
        ProtocolInfo.enablemultithread = sp.getBoolean("appsettings_multithreadrun", false);
        //Toast.makeText(this,ProtocolInfo.enablemultithread+"",Toast.LENGTH_SHORT).show();
    }

    /* access modifiers changed from: protected */
    public void onDestroy()
    {
        mark12_classh.a().a((mark23_classa) this.m);
        super.onDestroy();
    }

    public void onFocusChange(View view, boolean z)
    {
        if (view == this.account && !z && this.account.getText().toString().length() > 4)
        {
            this.m.a(this.account.getText().toString(), false);
        }
    }
	
    public boolean onKeyDown(int i2, KeyEvent keyEvent)
    {
        if (i2 != 4)
        {
            return super.onKeyDown(i2, keyEvent);
        }
        if (System.currentTimeMillis() - this.j > 2000)
        {
            Toast makeText = Toast.makeText(this, "再按一次，退出程序", 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
            this.j = System.currentTimeMillis();
        }
        else
        {
            stopService(new Intent(this, SQService.class));
            finish();
            System.exit(0);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause()
    {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onStop()
    {
        super.onStop();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        if (hasFocus && hit == null)
        {
            hit = new notice(LoginActivity.this,getWindow().getDecorView());
        }
        super.onWindowFocusChanged(hasFocus);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        /**
         * 创建活动菜单
         * 第一个参数：指定我们通过哪一个资源文件来创建菜单，R.menu.main
         * 第二个参数：指定我们的菜单项将添加到哪一个menu对象中，这里直接使用onCreateOptionsMenu()传入menu参数
         * 返回值：true，表示允许创建的菜单显示出来，false则不显示出来
         */
        getMenuInflater().inflate(R.menu.menu_activity_loginactivity, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menuactivityloginactivitysettings:
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, SettingsPreferenceActivity.class));
                break;
            default:
                break;
        }
        return true;
    }
}
