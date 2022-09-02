package saki.qq.global;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import java.io.File;
import saki.toolkit.HexToolKit;
import saki.toolkit.Code;
import saki.toolkit.ByteReader;
import saki.packaged.mark20_classe;
import saki.packaged.mark20_classf;

@SuppressLint({"NewApi"})
public class ImgStore {
    static LruCache h = new mark12_classf(4194304);
    public byte[] a;
    public int b;
    public byte[] c;
    public int d;
    public int e;
    public String f;
    public long g;

    public ImgStore(byte[] bArr, int i, int i2, String str) {
        this.a = bArr;
        this.d = i;
        this.e = i2;
        this.f = str;
        this.b = bArr.length;
        this.c = Code.md5(bArr);
    }

    public static final ImgStore a(String str) {
        ImgStore mark12_classe = (ImgStore) h.get(str);
        if (mark12_classe == null && (mark12_classe = a(mark20_classe.a(new File(str)))) != null) {
            h.put(str, mark12_classe);
        }
        return mark12_classe;
    }

    private static final ImgStore a(byte[] bArr) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (decodeByteArray == null) {
            return null;
        }
        String str = options.outMimeType == null ? "image/jpg" : options.outMimeType;
        return new ImgStore(bArr, decodeByteArray.getWidth(), decodeByteArray.getHeight(), str.substring(str.indexOf("/") + 1));
    }

    public static final ImgStore b(String str) {
        ImgStore mark12_classe = (ImgStore) h.get(str);
        if (mark12_classe == null && (mark12_classe = a(mark20_classf.a(str))) != null) {
            h.put(str, mark12_classe);
        }
        return mark12_classe;
    }

    public boolean equals(Object obj) {
        return obj instanceof byte[] ? ByteReader.bytesEqulsBytes((byte[]) obj, this.c) : super.equals(obj);
    }

    public String toString() {
        return String.valueOf(HexToolKit.bytesToHexString(this.c)) + "." + this.f;
    }
}
