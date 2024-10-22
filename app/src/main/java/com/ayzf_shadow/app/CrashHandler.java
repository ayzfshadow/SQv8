package com.ayzf_shadow.app;

import android.content.*;
import android.content.pm.*;
import android.os.*;
import android.util.*;
import android.widget.*;
import saki.client.*;
import java.io.*;
import java.lang.reflect.*;
import java.text.*;
import java.util.*;

/**
 * @Author 暗影之风
 *
 * @Class UncaughtException处理类，当程序发生Uncaught异常的时候，由该类来接管程序，并记录发送错误报告
 *
 * @CreateTime 2021-02-11 12:00 周四
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler
{
    public static final String TAG = "ShadowCrash";
    //系统默认的UncaughtException处理类
    private Thread.UncaughtExceptionHandler mDefaultHandler;
    //CrashHandler实例
    private static CrashHandler INSTANCE = new CrashHandler();
    //程序的Context对象
    private Context mContext;
    //用来存储设备信息和异常信息
    private Map<String, String> infos = new HashMap<String, String>();
    //用于格式化日期,作为日志文件名的一部分
    private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    /*保证只有一个CrashHandler实例*/
    private CrashHandler()
    {}
    /*获取CrashHandler实例 ,单例模式*/
    public static CrashHandler getInstance()
    {
        return INSTANCE;
    }

    /**
     * 初始化
     *
     * @param context
     */
    public void init(Context context)
    {
        mContext=context;
        //获取系统默认的UncaughtException处理器
        mDefaultHandler=Thread.getDefaultUncaughtExceptionHandler();
        //设置该CrashHandler为程序的默认处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /**
     * 当UncaughtException发生时会转入该函数来处理
     */
    @Override
    public void uncaughtException(Thread thread,Throwable ex)
    {
        if (!handleException(ex)&&mDefaultHandler!=null)
        {
            //如果用户没有处理则让系统默认的异常处理器来处理
            mDefaultHandler.uncaughtException(thread,ex);
        }
        else
        {
            try
            {
                Thread.sleep(3000);
            }
            catch (InterruptedException e)
            {
                Log.e(TAG,"error : ",e);
            }
            //退出程序
            //android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        }
    }

    /**
     * 自定义错误处理，收集错误信息 发送错误报告等操作均在此完成
     *
     * @param ex
     *
     * @return true:如果处理了该异常信息;否则返回false
     */
    private boolean handleException(Throwable ex)
    {
        if (ex==null)
        {
            return false;
        }
        //收集设备参数信息
        collectDeviceInfo(mContext);
        //保存日志文件
        final String path = saveCrashInfo2File(ex);
        //使用Toast来显示异常信息
        new Thread()
        {
            @Override
            public void run()
            {
                Looper.prepare();
                Toast.makeText(mContext,"程序出现异常，3秒后跳转错误详情",Toast.LENGTH_SHORT).show();
                final Intent intent = new Intent();
                intent.setClass(mContext,SQErrorActivity.class);
                intent.putExtra("log",new File(path).toString());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
                mContext.startActivity(intent);
                Looper.loop();
            }
        }.start();
        return true;
    }

    /**
     * 收集设备参数信息
     *
     * @param ctx
     */
    private void collectDeviceInfo(Context ctx)
    {
        try
        {
            PackageManager pm = ctx.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(ctx.getPackageName(),PackageManager.GET_ACTIVITIES);
            if (pi!=null)
            {
                String versionName = pi.versionName==null? "null" :pi.versionName;
                String versionCode = pi.versionCode+"";
                infos.put("versionName",versionName);
                infos.put("versionCode",versionCode);
            }
        }
        catch (PackageManager.NameNotFoundException e)
        {
            Log.e(TAG,"an error occured when collect package info",e);
        }
        Field[] fields = Build.class.getDeclaredFields();
        for (Field field : fields)
        {
            try
            {
                field.setAccessible(true);
                infos.put(field.getName(),field.get(null).toString());
                Log.d(TAG,field.getName()+" : "+field.get(null));
            }
            catch (Exception e)
            {
                Log.e(TAG,"an error occured when collect crash info",e);
            }
        }
    }

    /**
     * 保存错误信息到文件中
     *
     * @param ex
     *
     * @return 返回文件全路径，便于将文件传送到服务器
     */
    private String saveCrashInfo2File(Throwable ex)
    {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : infos.entrySet())
        {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key+"="+value+"\n");
        }
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        Throwable cause = ex.getCause();
        while (cause!=null)
        {
            cause.printStackTrace(printWriter);
            cause=cause.getCause();
        }
        printWriter.close();
        String result = writer.toString();
        sb.append(result);
        try
        {
            long timestamp = System.currentTimeMillis();
            String time = formatter.format(new Date());
            String fileName = "crash-"+time+"-"+timestamp+".log";
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
            {
                File dir = new File(SQApplication.crashPath);
                if (!dir.exists())
                {
                    dir.mkdirs();
                }
                FileOutputStream fos = new FileOutputStream(SQApplication.crashPath+fileName);
                fos.write(sb.toString().getBytes());
                fos.close();
            }
            return SQApplication.crashPath+fileName;
        }
        catch (Exception e)
        {
            Log.e(TAG,"an error occured while writing file...",e);
        }
        return null;
    }
}
