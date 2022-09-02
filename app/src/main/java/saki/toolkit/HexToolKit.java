package saki.toolkit;

import java.io.ByteArrayOutputStream;

public class HexToolKit {
    private static long a = 4294967295L;
    private static long b = 255;
    private static long c = 65280;
    private static long d = 16711680;
    private static long e = 4278190080L;

    public static long a(long j) {
        return a & j;
    }

    
    

    public static String bytesToHexString(byte[] bArray)
    {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) 
        {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
	}
    

    public static byte[] Int2Bytes(int i) {
        return new byte[]{(byte) (i >> 24), (byte) (i >> 16), (byte) (i >> 8), (byte) (i >> 0)};
    }

    public static byte[] UsignedInt2Bytes(long j, int i) {
        byte b2 = (byte) ((int) ((e & j) >> 24));
        byte b3 = (byte) ((int) ((d & j) >> 16));
        byte b4 = (byte) ((int) ((c & j) >> 8));
        byte b5 = (byte) ((int) (b & j));
        if (i == 4) {
            return new byte[]{b2, b3, b4, b5};
        }
        return new byte[]{(byte) ((int) (j >> 56)), (byte) ((int) ((j >> 48) & b)), (byte) ((int) ((j >> 40) & b)), (byte) ((int) ((j >> 32) & b)), b2, b3, b4, b5};
    }

    public static byte[] a(String str) {
        String replaceAll = str.replaceAll(" ", "");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(replaceAll.length() >> 1);
        for (int i = 0; i <= replaceAll.length() - 2; i += 2) {
            byteArrayOutputStream.write(Integer.parseInt(replaceAll.substring(i, i + 2), 16) & 255);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] Short2Bytes(short s) {
        return new byte[]{(byte) (s >> 8), (byte) (s >> 0)};
    }

    public static int b(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
    }

    public static long c(byte[] bArr) {
        if (bArr.length != 4) {
            return 0;
        }
        return (((long) (bArr[0] << 24)) & e) + (((long) (bArr[1] << 16)) & d) + (((long) (bArr[2] << 8)) & c) + (((long) bArr[3]) & b);
    }
}
