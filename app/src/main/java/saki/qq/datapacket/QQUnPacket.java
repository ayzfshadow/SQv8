package saki.qq.datapacket;

import android.util.Log;
import saki.qq.datapacket.unpack.ReConfigPushSvc_PushDomain;
import saki.qq.datapacket.unpack.ReConfigPushSvc_PushReq;
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
import saki.qq.datapacket.unpack.ReStatSvc_SimpleGet;
import saki.qq.datapacket.unpack.ReStatSvc_register;
import saki.qq.datapacket.unpack.Refriendlist_GetTroopListReqV2;
import saki.qq.datapacket.unpack.Refriendlist_getFriendGroupList;
import saki.qq.datapacket.unpack.Refriendlist_getTroopMemberList;
import saki.qq.datapacket.unpack.Rewtlogin_login;
import saki.qq.datapacket.unpack.Rewtlogin_trans_emp;
import saki.qq.datapacket.unpack.mark14_classal;
import saki.qq.datapacket.unpack.mark14_classap;
import saki.qq.global.ProtocolInfo;
import saki.toolkit.ByteReader;
import saki.toolkit.TeaCryptor;

public class QQUnPacket {
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static saki.qq.datapacket.Info getInfo(saki.toolkit.ByteReader reader, byte[] key) {
        reader.readBytes(8);
        int type = reader.readBytes(1)[0];
//      int index = buf.readerIndex();
//      buf.readerIndex(0);
//      byte[] g = new byte[buf.readableBytes()];
//      buf.readBytes(g);
//      System.out.println(Util.byte2HexString(g));
//      buf.readerIndex(index);

        reader.readBytes(1);//0
        reader.readBytes((int)reader.readInt() - 4);//qq长度+4+qq

        byte[] data = reader.readRestBytesAndDestroy();
        if (data.length % 8 != 0)
        {
            return null;//包体长度不是8的解密不出来的，丢弃这个包
        }
        TeaCryptor cry =  new TeaCryptor();
        byte[] data_decrypted = cry.decrypt(data, key);
        if (data_decrypted == null || data_decrypted.length == 0)
        {
            data_decrypted = cry.decrypt(data, new byte[16]);
        }
        if (data_decrypted == null || data_decrypted.length == 0)
        {
            return null;
        }
        cry.destroy();
        reader.update(data_decrypted);
        return new Info(reader);
  }

    private static mark14_classap a(String str, byte[] bArr) {
        Log.d("recvcmd",str);
        try {
            if (str.equals("wtlogin.login")) {
                return new Rewtlogin_login(bArr);
            }
            if (str.equals("wtlogin.trans_emp")) {
                return new Rewtlogin_trans_emp(bArr);
            }
            if (str.equals("GrayUinPro.Check")) {
                return new ReGrayUinPro_Check(bArr);
            }
            if (str.equals("OidbSvc.0x59f")) {
                return new ReOidbSvc_0x59f(bArr);
            }
            if (str.equals("OidbSvc.0x496")) {
                return new ReOidbSvc_0x496(bArr);
            }
            if (str.equals("OidbSvc.0x7c4_0")) {
                return new ReOidbSvc_0x7c4_0(bArr);
            }
            if (str.equals("OidbSvc.0x7a2_0")) {
                return new ReOidbSvc_0x7a2_0(bArr);
            }
            if (str.equals("StatSvc.SimpleGet")) {
                return new ReStatSvc_SimpleGet(bArr);
            }
            if (str.equals("StatSvc.register")) {
                return new ReStatSvc_register(bArr);
            }
            if (str.equals("ConfigPushSvc.PushReq")) {
                return new ReConfigPushSvc_PushReq(bArr);
            }
            if (str.equals("ConfigPushSvc.PushDomain")) {
                return new ReConfigPushSvc_PushDomain(bArr);
            }
            if (str.equals("friendlist.GetTroopListReqV2")) {
                return new Refriendlist_GetTroopListReqV2(bArr);
            }
            if (str.equals("friendlist.getFriendGroupList")) {
                return new Refriendlist_getFriendGroupList(bArr);
            }
            if (str.equals("friendlist.getTroopMemberList")) {
                return new Refriendlist_getTroopMemberList(bArr);
            }
            if (str.equals("PhSigLcId.Check")) {
                return new RePhSigLcId_Check(bArr);
            }
            if (str.equals("OnlinePush.PbPushTransMsg")) {
                return new ReOnlinePush_PbPushTransMsg(bArr);
            }
            if (str.equals("OnlinePush.PbPushGroupMsg")) {
                return new ReOnlinePush_PbPushGroupMsg(bArr);
            }
            if (str.equals("OnlinePush.PbPushDisMsg")) {
                return new ReOnlinePush_PbPushDisMsg(bArr);
            }
            if (str.equals("OnlinePush.ReqPush")) {
                return new ReOnlinePush_ReqPush(bArr);
            }
            if (str.equals("MessageSvc.PushNotify")) {
                return new ReMessageSvc_PushNotify(bArr);
            }
            if (str.equals("MessageSvc.PushForceOffline")) {
                return new ReMessageSvc_PushForceOffline(bArr);
            }
            if (str.equals("MessageSvc.PbGetMsg")) {
                return new ReMessageSvc_PbGetMsg(bArr);
            }
            if (str.equals("ProfileService.Pb.ReqSystemMsgNew.Group")) {
                return new ReProfileService_Pb_ReqSystemMsgNew_Group(bArr);
            }
            if (str.equals("ImgStore.GroupPicUp")) {
                return new ReImgStore_GroupPicUp(bArr);
            }
            return new mark14_classal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static mark14_classap unPacket(byte[] bArr) throws mark13_classc {
        ByteReader mark10_classd = new ByteReader(bArr);
        Info a = getInfo(mark10_classd, ProtocolInfo.a());
        if (a != null) {
            return a(a.cmd, mark10_classd.readRestBytesAndDestroy()).a(a);
        }
        
        mark10_classd.destroy();
        throw new mark13_classc();
    }
}
