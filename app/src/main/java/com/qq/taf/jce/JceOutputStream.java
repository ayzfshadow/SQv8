package com.qq.taf.jce;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class JceOutputStream {
    protected String a;
    private ByteBuffer b;
    private mark2_classh c;

    public JceOutputStream() {
        this(128);
    }

    public JceOutputStream(int i) {
        this.a = "GBK";
        this.b = ByteBuffer.allocate(i);
    }

    private void a(Object[] objArr, int i) {
        a(8);
        b((byte) 9, i);
        a(objArr.length, 0);
        for (Object a2 : objArr) {
            a(a2, 0);
        }
    }

    public void a(byte b2, int i) {
        a(3);
        if (b2 == 0) {
            b((byte) 12, i);
            return;
        }
        b((byte) 0, i);
        this.b.put(b2);
    }

    public void a(double d, int i) {
        a(10);
        b((byte) 5, i);
        this.b.putDouble(d);
    }

    public void a(float f, int i) {
        a(6);
        b((byte) 4, i);
        this.b.putFloat(f);
    }

    public void a(int i) {
        if (this.b.remaining() < i) {
            int capacity = (this.b.capacity() + i) * 2;
            try {
                ByteBuffer allocate = ByteBuffer.allocate(capacity);
                allocate.put(this.b.array(), 0, this.b.position());
                this.b = allocate;
            } catch (IllegalArgumentException e) {
                if (this.c != null) {
                    this.c.a(e, this.b, i, capacity);
                }
                throw e;
            }
        }
    }

    public void a(int i, int i2) {
        a(6);
        if (i < -32768 || i > 32767) {
            b((byte) 2, i2);
            this.b.putInt(i);
            return;
        }
        a((short) i, i2);
    }

    public void a(long j, int i) {
        a(10);
        if (j < -2147483648L || j > 2147483647L) {
            b((byte) 3, i);
            this.b.putLong(j);
            return;
        }
        a((int) j, i);
    }

    public void a(JceStruct mark2_classg, int i) {
        a(2);
        b((byte) 10, i);
        mark2_classg.writeTo(this);
        a(2);
        b((byte) 11, 0);
    }

    public void a(Object obj, int i) {
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i);
        } else if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue(), i);
        } else if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i);
        } else if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i);
        } else if (obj instanceof Long) {
            a(((Long) obj).longValue(), i);
        } else if (obj instanceof Float) {
            a(((Float) obj).floatValue(), i);
        } else if (obj instanceof Double) {
            a(((Double) obj).doubleValue(), i);
        } else if (obj instanceof String) {
            a((String) obj, i);
        } else if (obj instanceof Map) {
            a((Map) obj, i);
        } else if (obj instanceof List) {
            a((Collection) (List) obj, i);
        } else if (obj instanceof JceStruct) {
            a((JceStruct) obj, i);
        } else if (obj instanceof byte[]) {
            a((byte[]) obj, i);
        } else if (obj instanceof boolean[]) {
            a((boolean[]) obj, i);
        } else if (obj instanceof short[]) {
            a((short[]) obj, i);
        } else if (obj instanceof int[]) {
            a((int[]) obj, i);
        } else if (obj instanceof long[]) {
            a((long[]) obj, i);
        } else if (obj instanceof float[]) {
            a((float[]) obj, i);
        } else if (obj instanceof double[]) {
            a((double[]) obj, i);
        } else if (obj.getClass().isArray()) {
            a((Object[]) obj, i);
        } else if (obj instanceof Collection) {
            a((Collection) obj, i);
        } else {
            throw new mark2_classc("write object error: unsupport type. " + obj.getClass());
        }
    }

    public void a(String str, int i) {
        try {
            byte[] bytes = str.getBytes(this.a);
            a(bytes.length + 10);
            if (bytes.length > 255) {
                b((byte) 7, i);
                this.b.putInt(bytes.length);
                this.b.put(bytes);
            }
        } catch (UnsupportedEncodingException e) {
        }
        byte[] bytes2 = str.getBytes();
        b((byte) 6, i);
        this.b.put((byte) bytes2.length);
        this.b.put(bytes2);
    }

    public void a(Collection collection, int i) {
        if (collection != null) {
            a(8);
            b((byte) 9, i);
            a(collection.size(), 0);
            for (Object a2 : collection) {
                a(a2, 0);
            }
        }
    }

    public void a(Map map, int i) {
        if (map != null) {
            a(8);
            b((byte) 8, i);
            a(map.size(), 0);
            for (Object entry : map.entrySet()) {
				Map.Entry entry1=(Map.Entry) entry;
                a(entry1.getKey(), 0);
                a(entry1.getValue(), 1);
            }
        }
    }

    public void a(short s, int i) {
        a(4);
        if (s < -128 || s > 127) {
            b((byte) 1, i);
            this.b.putShort(s);
            return;
        }
        a((byte) s, i);
    }

    public void a(boolean z, int i) {
        a((byte) (z ? 0 : 1), i);
    }

    public void a(byte[] bArr, int i) {
        a(bArr.length + 8);
        b((byte) 13, i);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.b.put(bArr);
    }

    public void a(double[] dArr, int i) {
        a(8);
        b((byte) 9, i);
        a(dArr.length, 0);
        for (double a2 : dArr) {
            a(a2, 0);
        }
    }

    public void a(float[] fArr, int i) {
        a(8);
        b((byte) 9, i);
        a(fArr.length, 0);
        for (float a2 : fArr) {
            a(a2, 0);
        }
    }

    public void a(int[] iArr, int i) {
        a(8);
        b((byte) 9, i);
        a(iArr.length, 0);
        for (int a2 : iArr) {
            a(a2, 0);
        }
    }

    public void a(long[] jArr, int i) {
        a(8);
        b((byte) 9, i);
        a(jArr.length, 0);
        for (long a2 : jArr) {
            a(a2, 0);
        }
    }

    public void a(short[] sArr, int i) {
        a(8);
        b((byte) 9, i);
        a(sArr.length, 0);
        for (short a2 : sArr) {
            a(a2, 0);
        }
    }

    public void a(boolean[] zArr, int i) {
        a(8);
        b((byte) 9, i);
        a(zArr.length, 0);
        for (boolean a2 : zArr) {
            a(a2, 0);
        }
    }

    public byte[] a() {
        byte[] bArr = new byte[this.b.position()];
        System.arraycopy(this.b.array(), 0, bArr, 0, this.b.position());
        return bArr;
    }

    public void b(byte b2, int i) {
        if (i < 15) {
            this.b.put((byte) ((i << 4) | b2));
        } else if (i < 256) {
            this.b.put((byte) (b2 | 240));
            this.b.put((byte) i);
        } else {
            throw new mark2_classc("tag is too large: " + i);
        }
    }
}
