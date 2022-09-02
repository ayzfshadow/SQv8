package saki.qq.datapacket.pack.packagea;

import android.graphics.Bitmap;
import android.widget.CompoundButton;
import com.qq.taf.jce.JceInputStream;
import java.util.ArrayList;
import saki.client.packagea.mark9_classa;

public class mark16_classe extends mark16_classc implements CompoundButton.OnCheckedChangeListener 
{
    public long a;
    public long b;
    public String c = "";
    public String d = "";
    public int e;
    public int f;
    public int g;
    public Bitmap h;
    public boolean i;
    public boolean j;
    public ArrayList k;

    public void readFrom(JceInputStream mark2_classd) {
        this.a = mark2_classd.read(this.a, 0, true);
        this.b = mark2_classd.read(this.b, 1, true);
        this.c = mark2_classd.read(this.c, 4, true);
        this.d = mark2_classd.read(this.d, 5, true);
        this.e = mark2_classd.read(this.e, 19, true);
    }


    @Override
    public void onCheckedChanged(CompoundButton p1, boolean p2)
    {
        this.j = p2;
        p1.getContext().startService(mark9_classa.a(p1.getContext(), this.b));
    }

    public boolean equals(Object obj) {
        return (obj instanceof mark16_classe) && ((mark16_classe) obj).b == this.b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Code:" + this.a + "\r\n");
        sb.append("Id:" + this.b + "\r\n");
        sb.append("Name:" + this.c + "\r\n");
        sb.append("Info:" + this.d + "\r\n");
        sb.append("MemberCnt::" + this.e);
        return sb.toString();
    }
}
