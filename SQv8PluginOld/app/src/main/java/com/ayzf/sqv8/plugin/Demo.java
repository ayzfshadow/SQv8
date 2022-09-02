package com.ayzf.sqv8.plugin;

import android.content.Context;
import com.saki.aidl.PluginMsg;
import com.setqq.plugin.sdk.API;
import com.setqq.plugin.sdk.IPlugin;

public class Demo implements IPlugin
{
    private Context ayzf;
    public static API api;
    /**
     * 主程序加载插件时调用
     * @param context 主程序上下文句柄
     * @param api 接口类
     */
    @Override
    public void onLoad(Context context,API api)
    {
        this.ayzf = context;
        this.api = api;
    }

    /**
     * 插件被打开或关闭时调用
     * @param o 打开为true 关闭为false
     */
    public void onSet(boolean o)
    {}
    /**
     * 发送消息
     * @param msg 消息包
     * @return 返回结果包
     */
    public static PluginMsg send(PluginMsg msg)
    {
        if (api != null)
        {
            return api.send(msg);
        }
        return null;
    }
    /**
     *由主程序接收消息时调用
     *@param 消息包体
     */
    @Override
    public void onMessageHandler(final PluginMsg param)
    {
        final long gn = param.groupid;//群号
        final long uin = param.uin;//账号
        final String uinName = param.uinName;//昵称
        final String msg = param.getTextMsg();//群消息
    }
}
  
/*注释
* 作者 暗影之风
* 时间 2020年8月6日23:18
* 注释介绍SQv8的type使用
*
* TYPE_GROUP_MSG = 0;// 群消息
* TYPE_BUDDY_MSG = 1;// 好友消息
* TYPE_DIS_MSG = 2;// 讨论组消息
* TYPE_SYS_MSG = 3;// 系统消息
* TYPE_SESS_MSG = 4;// 临时消息
* TYPE_GET_GROUP_LIST = 5;// 群列表，发送后返回的包getMsg("troop")为群列表
* TYPE_GET_GROUP_INFO = 6;// 群信息，发送后返回的包getMsg("member")为成员列表
* TYPE_GET_GROUP_MEBMER = 7;// 群成员
* TYPE_FAVORITE = 8;// 点赞
* TYPE_SET_MEMBER_CARD = 9;// 设置群名片
* TYPE_SET_MEMBER_SHUTUP = 10;// 成员禁言
* TYPE_SET_GROUP_SHUTUP = 11;// 群禁言
* TYPE_DELETE_MEMBER = 12;// 删除群成员
* TYPE_AGREE_JOIN = 13;// 同意入群
* TYPE_GET_MEMBER_INFO = 14;// 成员信息
* TYPE_GET_LOGIN_ACCOUNT = 15;// 获取机器人QQ,发送后返回包的Uin为机器人QQ
*
*/

/*注释
* 作者 暗影之风
* 时间 2020年8月6日23:23
* 注释介绍SQv8使用参数
*
* public int type; //消息类型
* public long groupid; //群号
* public long code;//群code，发送临时消息需要这个
* public long uin;//发送者QQ
* public long time;//消息发送时间戳
* public int value;//附加值，禁言时间，等
* public String groupName;//群名
* public String uinName;//发送者昵称
* public String title;//发送者名片，修改群名片时的名片
* public String getTextMsg()//获取文本消息内容(请在清空消息前调用才有返回值)
* public void clearMsg() //清空消息(发送消息前清空掉源消息)
* public void addMsg(String key, String msg)//添加消息内容key为 msg(文本消息)xml(卡片消息)json(json消息)
* public ArrayList<String> getMsg(String key)//获取对应的消息内容key同上
*
*/


