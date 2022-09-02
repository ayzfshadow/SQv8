package com.saki.aidl;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Parcel;
import android.os.Parcelable;

public class PluginMsg implements Parcelable{
    //必须提供一个名为CREATOR的static final属性 该属性需要实现android.os.Parcelable.Creator<T>接口  
    public static final Parcelable.Creator<PluginMsg> CREATOR = new Parcelable.Creator<PluginMsg>() {  
 
        @Override
        public PluginMsg createFromParcel(Parcel source) {
            return new PluginMsg(source);
        };
  
        @Override  
        public PluginMsg[] newArray(int size) {  
            return new PluginMsg[size];  
        }  
    };  
    public static final int TYPE_GROUP_MSG=0;//群消息
    public static final int TYPE_BYDDY_MSG=1;//好友消息
    public static final int TYPE_DIS_MSG=2;//讨论组消息
    public static final int TYPE_SESS_MSG=4;//临时消息
    public static final int TYPE_SYS_MSG=3;//系统消息
    public static final int TYPE_GET_GROUP_LIST=5;//群列表
    public static final int TYPE_GET_GROUP_INFO=6;//群信息
    public static final int TYPE_GET_GROUP_MEBMER=7;//群成员
    public static final int TYPE_GET_MEMBER_INFO=14;//成员信息
    public static final int TYPE_FAVORITE=8;//点赞
    public static final int TYPE_SET_MEMBER_CARD=9;//设置群名片
    public static final int TYPE_SET_MEMBER_SHUTUP=10;//成员禁言
    public static final int TYPE_SET_GROUP_SHUTUP=11;//群禁言
    public static final int TYPE_DELETE_MEMBER=12;//删除群成员
    public static final int TYPE_AGREE_JOIN=13;//同意入群
    public static final int TYPE_GET_LOGIN_ACCOUNT=15;//获取机器人QQ
    public int type;
    public long groupid;
    public long code;
    public long uin;
    public long time;
    public int value;
    public String groupName;
    public String uinName;
    public String title;
    private HashMap<String, ArrayList<String>> data=new HashMap<String, ArrayList<String>>();
    
    public PluginMsg(Parcel source) {
        readFromParcel(source);
    }
    public PluginMsg() {
    }
    @Override
    public int describeContents() {
        return 0;
    }
    public void clearMsg()
    {
        data=new HashMap<String, ArrayList<String>>();
    }
    public HashMap<String, ArrayList<String>> getData()
    {
        return data;
    }
    public void setData(HashMap<String, ArrayList<String>> data)
    {
        if(data!=null){
            this.data=data;
        }
    }
    public String getTextMsg()
    {
        StringBuilder build=new StringBuilder("");
        ArrayList<String> list=data.get("msg");
        if(list!=null)
        {
            for(String m:list)
                build.append(m);
        }
        return build.toString();
    }
    public ArrayList<String> getMsg(String key)
    {
        return data.get(key);
    }
    public void addMsg(String key,String msg)
    {
        ArrayList<String> index=data.get("index");
        if(index==null){
            index=new ArrayList<String>();
            data.put("index", index);
        }
        index.add(key);
        ArrayList<String> list=data.get(key);
        if(list==null){
            list=new ArrayList<String>();
            data.put(key, list);
        }
        list.add(msg);
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(type);
        dest.writeLong(groupid);
        dest.writeLong(code);
        dest.writeLong(uin);
        dest.writeLong(time);
        dest.writeInt(value);
        dest.writeString(groupName);
        dest.writeString(uinName);
        dest.writeString(title);
        dest.writeMap(data);
    }
     public void readFromParcel(Parcel source) {  
        type=source.readInt();
        groupid=source.readLong();
        code=source.readLong();
        uin=source.readLong();
        time=source.readLong();
        value=source.readInt();
        groupName=source.readString();
        uinName=source.readString();
        title=source.readString();
        source.readMap(data, getClass().getClassLoader());
     }
}
