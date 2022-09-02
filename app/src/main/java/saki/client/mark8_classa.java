package saki.client;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import saki.log.DebugLogger;
import saki.log.Logger;
import saki.packaged.mark20_classi;
import saki.qq.datapacket.pack.send.GrayUinPro_Check;
import saki.qq.datapacket.pack.send.MessageSvc_PbGetMsg;
import saki.qq.datapacket.pack.send.OidbSvc_0x496;
import saki.qq.datapacket.pack.send.OidbSvc_0x59f;
import saki.qq.datapacket.pack.send.OidbSvc_0x7a2_0;
import saki.qq.datapacket.pack.send.OidbSvc_0x7c4_0;
import saki.qq.datapacket.pack.send.OnlinePush_RespPush;
import saki.qq.datapacket.pack.send.ProfileService_Pb_ReqSystemMsgNew_Group;
import saki.qq.datapacket.pack.send.ProfileService_Pb_ReqSystemMsgRead_Group;
import saki.qq.datapacket.pack.send.SendPack;
import saki.qq.datapacket.pack.send.StatSvc_register;
import saki.qq.datapacket.pack.send.wtlogin_unlockConfirm;
import saki.qq.datapacket.unpack.ReConfigPushSvc_PushDomain;
import saki.qq.datapacket.unpack.ReGrayUinPro_Check;
import saki.qq.datapacket.unpack.ReImgStore_GroupPicUp;
import saki.qq.datapacket.unpack.ReMessageSvc_PbGetMsg;
import saki.qq.datapacket.unpack.ReMessageSvc_PushForceOffline;
import saki.qq.datapacket.unpack.ReMessageSvc_PushNotify;
import saki.qq.datapacket.unpack.ReOidbSvc_0x496;
import saki.qq.datapacket.unpack.ReOidbSvc_0x59f;
import saki.qq.datapacket.unpack.ReOidbSvc_0x7a2_0;
import saki.qq.datapacket.unpack.ReOidbSvc_0x7c4_0;
import saki.qq.datapacket.unpack.ReOnlinePush_PbPushDisMsg;
import saki.qq.datapacket.unpack.ReOnlinePush_PbPushGroupMsg;
import saki.qq.datapacket.unpack.ReOnlinePush_PbPushTransMsg;
import saki.qq.datapacket.unpack.ReOnlinePush_ReqPush;
import saki.qq.datapacket.unpack.RePhSigLcId_Check;
import saki.qq.datapacket.unpack.ReProfileService_Pb_ReqSystemMsgNew_Group;
import saki.qq.datapacket.unpack.ReStatSvc_register;
import saki.qq.datapacket.unpack.Refriendlist_GetTroopListReqV2;
import saki.qq.datapacket.unpack.Refriendlist_getFriendGroupList;
import saki.qq.datapacket.unpack.Refriendlist_getTroopMemberList;
import saki.qq.datapacket.unpack.Rewtlogin_login;
import saki.qq.datapacket.unpack.Rewtlogin_trans_emp;
import saki.qq.datapacket.unpack.mark14_classah;
import saki.qq.datapacket.unpack.mark14_classal;
import saki.qq.datapacket.unpack.mark14_classap;
import saki.qq.datapacket.unpack.mark14_classm;
import saki.qq.global.ProtocolInfo;
import saki.qq.global.mark12_classc;
import saki.qq.global.mark12_classh;
import saki.qq.global.mark12_classk;
import saki.ui.packageb.mark23_classa;
import saki.ui.packageb.mark23_classb;
import saki.ui.packageb.mark23_classd;

public class mark8_classa implements mark8_classq
{
    public mark8_classe a = new mark8_classe(this);
    public mark23_classa b = mark12_classh.a();
    private ClientSocket c ;
    private int d = new Random().nextInt(10000);
    private mark20_classi e = new mark20_classi(ReOnlinePush_PbPushDisMsg.class, 100);
    /* access modifiers changed from: private */
 
    private Thread g;
    private mark8_classp h;
    private mark23_classb i = mark12_classh.a();
    private mark23_classd j = mark12_classk.a();
  

    public boolean islogined;

    public mark8_classa()
    {
        this.c=new ClientSocket(this);
        
    }

    public void a(long j2)
    {
        this.h = new mark8_classp(j2, this);
        this.h.start();
    }

    public void a(SendPack mark18_classao)
    {
        this.g = new mark8_classc(this, mark18_classao, 2);
        this.g.start();
    }

    public void a(mark14_classap mark14_classap)
    {
       // Log.d("Fuck","");
        if (this.g != null)
        {
            this.g.interrupt();
            this.g = null;
        }
        if (mark14_classap instanceof mark14_classal)
        {
            
            DebugLogger.a(this, "read unHandler");
            return;
        }
        if (this.h != null)
        {
            this.h.interrupt();
            this.h = null;
        }
        if (mark14_classap instanceof ReImgStore_GroupPicUp)
        {
            this.a.a((ReImgStore_GroupPicUp) mark14_classap);
        }
        else if (mark14_classap instanceof ReMessageSvc_PushForceOffline)
        {
            d();
            this.b.a(7, (byte[]) null);
        }
        else if (mark14_classap instanceof ReMessageSvc_PbGetMsg)
        {
            Iterator it = ((ReMessageSvc_PbGetMsg) mark14_classap).a.iterator();
            while (it.hasNext())
            {
                mark14_classm mark14_classm = (mark14_classm) it.next();
                if (mark14_classm.h == 34 || mark14_classm.h == 87)
                {
                    b(new ProfileService_Pb_ReqSystemMsgNew_Group(c()));
                }
            }
            this.i.a((ReMessageSvc_PbGetMsg) mark14_classap);
        }
        else if (mark14_classap instanceof ReProfileService_Pb_ReqSystemMsgNew_Group)
        {
            ReProfileService_Pb_ReqSystemMsgNew_Group mark14_classag = (ReProfileService_Pb_ReqSystemMsgNew_Group) mark14_classap;
            b(new ProfileService_Pb_ReqSystemMsgRead_Group(c(), mark14_classag.a));
            Iterator it2 = mark14_classag.b.iterator();
            while (it2.hasNext())
            {
                mark14_classah mark14_classah = (mark14_classah) it2.next();
                if (mark14_classah.j == 1)
                {
                    this.i.a(mark14_classah);
                }
            }
        }
        else if (mark14_classap instanceof ReMessageSvc_PushNotify)
        {
            b(new MessageSvc_PbGetMsg(c()));
        }
        else if (mark14_classap instanceof ReConfigPushSvc_PushDomain)
        {

            //更改
        }
        else if (mark14_classap instanceof ReOnlinePush_PbPushTransMsg)
        {
            this.i.a((ReOnlinePush_PbPushTransMsg) mark14_classap);
        }
        else if (mark14_classap instanceof ReOnlinePush_ReqPush)
        {
            ReOnlinePush_ReqPush mark14_classy = (ReOnlinePush_ReqPush) mark14_classap;
            b(new OnlinePush_RespPush(c(), mark14_classy.b, mark14_classy.a.a));
        }
        else if (mark14_classap instanceof ReOnlinePush_PbPushDisMsg)
        {
            if (mark12_classc.h != 0)
            {
                b(new OnlinePush_RespPush(c(), (long) mark14_classap.l.seq, (ArrayList) null));
            }
            else if (!this.e.b((ReOnlinePush_PbPushDisMsg) mark14_classap))
            {
                return;
            }
            this.i.a((ReOnlinePush_PbPushDisMsg) mark14_classap);
        }
        else if (mark14_classap instanceof ReOnlinePush_PbPushGroupMsg)
        {
            this.i.a((ReOnlinePush_PbPushGroupMsg) mark14_classap);
        }
        else if (mark14_classap instanceof Refriendlist_GetTroopListReqV2)
        {
            this.j.a(((Refriendlist_GetTroopListReqV2) mark14_classap).a.c);
        }
        else if (mark14_classap instanceof Refriendlist_getFriendGroupList)
        {
        }
        else
        {
            if (mark14_classap instanceof Refriendlist_getTroopMemberList)
            {
                Refriendlist_getTroopMemberList mark14_classg = (Refriendlist_getTroopMemberList) mark14_classap;
                this.j.a(mark14_classg.a.a, mark14_classg.a.c);
            }
            else if (mark14_classap instanceof ReGrayUinPro_Check)
            {
                ReGrayUinPro_Check mark14_classh = (ReGrayUinPro_Check) mark14_classap;
                if (mark14_classh.a.j.equals("b") || mark14_classh.a.k.equals("a"))
                {
                    this.b.a(5, (byte[]) null);
                    return;
                }
                ProtocolInfo.a(ProtocolInfo.g);
                b(new OidbSvc_0x59f(c()));
                islogined=true;
               
                    
                this.c.ctx.executor().scheduleAtFixedRate(new HeartBeatThread(this),0, 100, TimeUnit.SECONDS);
                this.b.a(0, (byte[]) null);
            }
            else if(mark14_classap instanceof ReStatSvc_register){
                Logger.c("上线成功");
            }
            else if (mark14_classap instanceof ReOidbSvc_0x59f)
            {
                b(new OidbSvc_0x496(c()));
            }
            else if (mark14_classap instanceof ReOidbSvc_0x496)
            {
                b(new OidbSvc_0x7c4_0(c()));
            }
            else if (mark14_classap instanceof ReOidbSvc_0x7c4_0)
            {
                b(new OidbSvc_0x7a2_0(c()));
            }
            else if (mark14_classap instanceof ReOidbSvc_0x7a2_0)
            {
                b(new StatSvc_register(c()));
            }
            else if (mark14_classap instanceof RePhSigLcId_Check)
            {
                a((SendPack) new GrayUinPro_Check(c()));
            }
            else if (mark14_classap instanceof Rewtlogin_trans_emp)
            {
                b(new GrayUinPro_Check(c()));
            }
            else if (mark14_classap instanceof Rewtlogin_login)
            {
                Rewtlogin_login mark14_classan = (Rewtlogin_login) mark14_classap;
				Log.d("loginresult",mark14_classan.result+"");
                switch (mark14_classan.result)
                {
                    case 0:
                        b(new GrayUinPro_Check(c()));
                        return;
                    case 2:
                        this.b.a(2, mark14_classan.b);
                        return;
					case -96:
						if(!ProtocolInfo.unlockRequireSent){
						    this.b.a(-2, ProtocolInfo.phone.getBytes());
						}else{
							this.b.a(-3, mark14_classan.b);
						}
						return;
					case -93:
						this.b.a(-4, mark14_classan.b);
					return;
					case -52:
						b(new wtlogin_unlockConfirm(c()));
						break;
                    case 160:
                        this.b.a(3, "为了保证您的账户安全，当前操作需要验证(请关闭当前号码的QQ设备锁)".getBytes());
                        return;
					case -95:
						this.b.a(3, mark14_classan.d.getBytes());
						ProtocolInfo.unlockRequireSent=false;
						return;
                    default:
                        this.b.a(3, mark14_classan.d.getBytes());
                        return;
                }
            }
        }
    }

    public boolean a()
    {
        return this.c.isconnected();
    }

    public void b(SendPack mark18_classao)
    {
		try{
            this.c.send(mark18_classao.toByteArray());
		}catch(Exception e){
			e.printStackTrace();
		}
    }


    public int c()
    {
        int i2 = this.d;
        this.d = i2 + 1;
        return i2;
    }

    public void d()
    {
        
        this.c.stop();
    }

    public void e()
    {
        this.b.a(3, "登录超时请检查网络设置".getBytes());
    }
}
