package com.qq.taf.jce;

import java.io.Serializable;

public abstract class JceStruct implements Serializable {
    public abstract void readFrom(JceInputStream mark2_classd);

    public abstract void writeTo(JceOutputStream mark2_classf);

    public void a(StringBuilder sb, int i) {
    }

    public byte[] a() {
        JceOutputStream mark2_classf = new JceOutputStream();
        writeTo(mark2_classf);
        return mark2_classf.a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        a(sb, 0);
        return sb.toString();
    }
    
    public JceStruct newInit()
  {
    return null;
  }
}
