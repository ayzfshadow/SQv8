package saki.toolkit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Code {
    public static final byte[] a = new byte[16];

    public static byte[] md5(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] a2;
        int length = bArr.length;
        int i = length % 8;
        if (i != 0) {
            byte[] bArr3 = new byte[((length + 8) - i)];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            length = bArr3.length;
            bArr = bArr3;
        }
        if (length % 8 != 0 || length < 16) {
            return new byte[0];
        }
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[8];
        byte[] bArr6 = new byte[8];
        int i2 = 0;
        byte[] bArr7 = null;
        while (i2 < length) {
            System.arraycopy(bArr, i2, bArr5, 0, 8);
            if (bArr7 == null) {
                a2 = mark10_classc.a(bArr5, bArr2);
                System.arraycopy(a2, 0, bArr6, 0, 8);
            } else {
                for (int i3 = 0; i3 < 8; i3++) {
                    bArr6[i3] = (byte) (bArr5[i3] ^ bArr7[i3]);
                }
                a2 = mark10_classc.a(bArr6, bArr2);
                for (int i4 = 0; i4 < 8; i4++) {
                    bArr6[i4] = (byte) (a2[i4] ^ bArr[(i2 - 8) + i4]);
                }
            }
            System.arraycopy(bArr6, 0, bArr4, i2, 8);
            i2 += 8;
            bArr7 = a2;
        }
        byte b = (byte) (bArr4[0] & 7);
        byte[] bArr8 = new byte[(((bArr4.length - b) - 10) - (i == 0 ? i : 8 - i))];
        System.arraycopy(bArr4, b + 3, bArr8, 0, bArr8.length);
        return bArr8;
    }

    public static byte[] QQTEAencrypt(byte[] bArr, byte[] bArr2) {
        int length = (bArr.length + 10) % 8;
        if (length != 0) {
            length = 8 - length;
        }
        byte[] bArr3 = new byte[(bArr.length + 10 + length)];
        bArr3[0] = (byte) (length | 168);
        for (int i = 1; i <= length + 2; i++) {
            bArr3[i] = -83;
        }
        System.arraycopy(bArr, 0, bArr3, length + 3, bArr.length);
        byte[] bArr4 = new byte[8];
        byte[] bArr5 = null;
        byte[] bArr6 = new byte[8];
        byte[] bArr7 = new byte[8];
        byte[] bArr8 = new byte[bArr3.length];
        for (int i2 = 0; i2 < bArr3.length; i2 += 8) {
            System.arraycopy(bArr3, i2, bArr4, 0, 8);
            if (bArr5 == null) {
                bArr5 = mark10_classc.b(bArr4, bArr2);
                System.arraycopy(bArr3, 0, bArr6, 0, 8);
            } else {
                for (int i3 = 0; i3 < 8; i3++) {
                    bArr7[i3] = (byte) (bArr4[i3] ^ bArr5[i3]);
                }
                bArr5 = mark10_classc.b(bArr7, bArr2);
                for (int i4 = 0; i4 < 8; i4++) {
                    bArr5[i4] = (byte) (bArr5[i4] ^ bArr6[i4]);
                }
                System.arraycopy(bArr7, 0, bArr6, 0, 8);
            }
            System.arraycopy(bArr5, 0, bArr8, i2, 8);
        }
        return bArr8;
    }
}
