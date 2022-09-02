package saki.qq.global;

import java.util.ArrayList;
import java.util.HashMap;
import saki.toolkit.Code;
import saki.toolkit.HexToolKit;

public class ProtocolInfo {
    public static final byte[] a = new byte[16];
    public static final byte[] b = HexToolKit.a("63 50 70 73 47 36 70 6D 45 28 56 76 41 62 50 5E");
    public static byte[] sharekey = new byte[]{(byte)0xDB, (byte)0xC3, 0x63, (byte)0x8A, 0x1A, 0x24, 0x64, (byte)0x9E, (byte)0xC8, 0x19, (byte)0xA9, 0x2B, 0x3B, (byte)0xEF, (byte)0x8A, (byte)0x9C};
    public static byte[] d = a;
    public static byte[] e = a;
    public static byte[] f = {-38, 49, -66, -100, -25, -45, 92, 108, -91, 40, -1, 54, 29, -114, -93, 71};
    public static byte[] g = a;
    public static byte[] h = {-31, 92, -44, 19, 37, -110, -19, 34, 120, 121, -18, 53, -62, -69, 110, -47};
    public static byte[] pubkey = new byte[]{0x02, 0x57, (byte)0x81, 0x11, 0x65, (byte)0xC5, (byte)0xF2, 0x72, 0x07, 0x70, (byte)0xB8, 0x69, (byte)0xCB, (byte)0xE0, (byte)0xDF, 0x2C, (byte)0xA5, (byte)0x93, (byte)0xCA, (byte)0x9B, 0x1F, 0x6F, (byte)0x9C, 0x7C, (byte)0xA1};
    private static byte[] j = a;
    public static HashMap<Integer,ImgStore> imgcache = new HashMap<>();
    
    public static long appid=537047268L;

    public static boolean enabledismessagereply =false;

    public static boolean enableprivatemessagereply =false;

    public static boolean enablemultithread;

    public static byte[] crckey;

	public static String phone;

	public static boolean unlockRequireSent;

    

    public static final void a(long j2, String str) {
        mark12_classc.c = j2;
        mark12_classc.d = str;
        byte[] a2 = Code.md5(str.getBytes());
        mark12_classc.e = a2;
        byte[] bArr = new byte[(a2.length + 8)];
        System.arraycopy(a2, 0, bArr, 0, a2.length);
        System.arraycopy(HexToolKit.UsignedInt2Bytes(j2, 8), 0, bArr, a2.length, 8);
        d = Code.md5(bArr);
    }

    public static void a(byte[] bArr) {
        j = bArr;
    }

    public static byte[] a() {
        return j;
    }
}
