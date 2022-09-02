package saki.client;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.setqq.packagea.mark5_classa;
import java.util.ArrayList;
import java.util.HashMap;
import saki.log.DebugLogger;
import saki.packaged.mark20_classh;
import saki.qq.datapacket.pack.send.GrayUinPro_Check;
import saki.qq.datapacket.pack.send.MessageSvc_PbSendMsg;
import saki.qq.datapacket.pack.send.OidbSvc_0x570_8;
import saki.qq.datapacket.pack.send.OidbSvc_0x8a0_0;
import saki.qq.datapacket.pack.send.OidbSvc_Ox89a_0;
import saki.qq.datapacket.pack.send.ProfileService_Pb_ReqSystemMsgAction_Group;
import saki.qq.datapacket.pack.send.VisitorSvc_ReqFavorite;
import saki.qq.datapacket.pack.send.friendlist_GetTroopListReqV2;
import saki.qq.datapacket.pack.send.friendlist_ModifyGroupCardReq;
import saki.qq.datapacket.pack.send.friendlist_getFriendGroupList;
import saki.qq.datapacket.pack.send.friendlist_getTroopMemberList;
import saki.qq.datapacket.pack.send.mark18_classbc;
import saki.qq.datapacket.pack.send.packagea.mark19_classd;
import saki.qq.datapacket.pack.send.wtlogin_login;
import saki.qq.datapacket.pack.send.wtlogin_requireunlock;
import saki.qq.datapacket.pack.send.wtlogin_requireunlockcode;
import saki.qq.global.ProtocolInfo;
import saki.qq.global.mark12_classc;
import saki.qq.global.mark12_classh;
import saki.qq.global.mark12_classi;

public class SQService extends Service {
    mark8_classa a;
  
    private long c = 0;
    
    private SQNotification notification;
    
    /* access modifiers changed from: private */
    public void a(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("cmd", -1);
            if (intExtra != 0 && this.c != 0 && this.c < System.currentTimeMillis()) {
                mark12_classh.a().a(4, String.valueOf(this.c).getBytes());
            } else {
                
                if (intExtra != 0 || intent.getBooleanExtra("login", false) || !a(intent.getLongExtra("qq", -1), intent.getStringExtra("password"))) {
                    switch (intExtra) {
                        case 0:
                            long longExtra = intent.getLongExtra("qq", 0);
                            long a2 = mark5_classa.a(this, longExtra);
                            this.c = a2;
                            if (a2 <= 0 || !mark5_classa.a(longExtra)) {
                                mark12_classh.a().a(4, String.valueOf(this.c).getBytes());
                                return;
                            }
                            mark12_classh.a().a(4, String.valueOf(this.c).getBytes());
                            this.a.a(20000);
                            this.a.b(new wtlogin_login(longExtra, intent.getStringExtra("password"), this.a.c()));
                            return;
                        case 1:
                            this.a.b(new mark18_classbc(this.a.c(), intent.getStringExtra("verify")));
                            return;
                        case 2:
                            this.a.b(new friendlist_GetTroopListReqV2(this.a.c()));
                            return;
                        case 3:
                            this.a.b(new friendlist_getFriendGroupList(this.a.c()));
                            return;
                        case 4:
                            long longExtra2 = intent.getLongExtra("id", -1);
                            long longExtra3 = intent.getLongExtra("group", -1);
                            long longExtra4 = intent.getLongExtra("uin", -1);
                            HashMap hashMap = (HashMap) intent.getSerializableExtra("data");
                            if (hashMap != null) {
                                MessageSvc_PbSendMsg mark18_classt = new MessageSvc_PbSendMsg(this.a.c(), longExtra2, longExtra3, longExtra4);
                                ArrayList arrayList = (ArrayList) hashMap.get("index");
                                if (arrayList != null) {
                                    for (int i = 0; i < arrayList.size(); i++) {
                                        String str = (String) arrayList.get(i);
                                        ArrayList arrayList2 = (ArrayList) hashMap.get(str);
                                        if (arrayList2 != null && arrayList2.size() > 0) {
                                            mark19_classd.a(this.a, mark18_classt, arrayList.size(), i, str, (String) arrayList2.remove(0));
                                        }
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        case 5:
                            this.a.b(new friendlist_ModifyGroupCardReq(this.a.c(), intent.getLongExtra("group", -1), intent.getLongExtra("uin", -1), intent.getStringExtra("card")));
                            return;
                        case 6:
                            this.a.b(new OidbSvc_0x8a0_0(this.a.c(), intent.getLongExtra("group", -1), intent.getLongExtra("uin", -1)));
                            return;
                        case 7:
                            this.a.b(new VisitorSvc_ReqFavorite(this.a.c(), intent.getLongExtra("uin", -1), intent.getIntExtra("count", 10)));
                            return;
                        case 8:
                            this.a.b(new OidbSvc_0x570_8(this.a.c(), intent.getLongExtra("group", -1), intent.getLongExtra("uin", -1), intent.getIntExtra("time", 600)));
                            return;
                        case 9:
                            this.a.b(new OidbSvc_Ox89a_0(this.a.c(), intent.getLongExtra("group", -1), intent.getBooleanExtra("open", true)));
                            return;
                        case 10:
                            a();
                            return;
                        case 11:
                            this.a.b(new ProfileService_Pb_ReqSystemMsgAction_Group(this.a.c(), intent.getLongExtra("group", -1), intent.getLongExtra("uin", -1), intent.getLongExtra("reqid", -1), intent.getBooleanExtra("agree", false)));
                            return;
                        case 12:
                            this.a.b(new friendlist_getTroopMemberList(this.a.c()));
                            return;
						case 101:
							this.a.b(new wtlogin_requireunlock(this.a.c()));
							ProtocolInfo.unlockRequireSent=true;
                            return;
						case 102:
							this.a.b(new wtlogin_requireunlockcode(this.a.c(),intent.getStringExtra("verify")));
							return;
                        default:
                            return;
                    }
                }
            } 
        }
    }

    private boolean a(long j, String str) {
        if (!mark20_classh.b() || ((j != -1 && mark12_classc.c != j) || (str != null && !str.equals(mark12_classc.d)))) {
            return false;
        }
        long a2 = mark5_classa.a(this, mark12_classc.c);
        this.c = a2;
        if (a2 <= 0 || !mark5_classa.a(mark12_classc.c)) {
            mark12_classh.a().a(4, String.valueOf(this.c).getBytes());
        } else {
            mark12_classh.a().a(4, String.valueOf(this.c).getBytes());
            this.a.a(20000);
            this.a.b(new GrayUinPro_Check(this.a.c()));
        }
        return true;
    }

    

    

    public void a() {
        this.notification = new SQNotification(this);
        this.notification.start();
        mark12_classi.d(this);
        mark12_classi.c(this);
        
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        DebugLogger.a(this, "onCreate");
       
        
        this.a = new mark8_classa();
        super.onCreate();
    }

    public void onDestroy() {
        try {
            DebugLogger.a(this, "onDestroy");
            this.notification.stop();
           
            mark12_classi.a().b((Context) this);
            mark20_classh.a();
            this.a.d();
        } catch (Exception e2) {
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        new mark8_classl(this, intent).start();
        return super.onStartCommand(intent, i, i2);
    }
}
