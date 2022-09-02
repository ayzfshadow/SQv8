package saki.client;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import saki.log.DebugLogger;
import saki.qq.datapacket.pack.send.ImgStore_GroupPicUp;
import saki.qq.datapacket.unpack.ReImgStore_GroupPicUp;
import saki.qq.global.ImgStore;
import saki.qq.global.ProtocolInfo;

public class mark8_classe implements mark8_classh {
    mark8_classa a;
    HashMap<ImgStore,mark8_classf> cache= new HashMap<>();
    
    public mark8_classe(mark8_classa mark8_classa) {
        this.a = mark8_classa;
    }

    public ImgStore a(int bArr) {
        return ProtocolInfo.imgcache.remove(bArr);
    }

    public void a(long j, ImgStore mark12_classe, mark8_classf mark8_classf) {
        this.cache.put(mark12_classe,mark8_classf);
        this.a.b(new ImgStore_GroupPicUp(this.a.c(), j, mark12_classe));
    }

    public void a(ImgStore mark12_classe) {
        mark8_classf y = this.cache.remove(mark12_classe);
        if(y ==null){
            return;
        }
        y.a(mark12_classe);
        
        
    }

    public void a(ReImgStore_GroupPicUp mark14_classj) {
        ImgStore a2 = a(mark14_classj.l.seq);
        if(a2 ==null){
           // Log.d("错误", "图片为空");
            return;
        }
        a2.g = mark14_classj.c;
        if (mark14_classj.b == null) {
            //Log.d("信息", "该图片无需上传");
            a(a2);
            return;
        }
       // Log.d("信息", "正在上传...");
        try {
            new mark8_classg(this.a, a2,this).a(mark14_classj.b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
