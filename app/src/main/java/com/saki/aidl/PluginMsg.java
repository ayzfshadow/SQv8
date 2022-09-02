package com.saki.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PluginMsg implements Parcelable,java.io.Serializable {
  
  
	private static final long serialVersionUID = 202107231733L;
	
  
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public PluginMsg createFromParcel(Parcel parcel) {
            return new PluginMsg(parcel);
        }

        public PluginMsg[] newArray(int i) {
            return new PluginMsg[i];
        }
    };
    public static final int TYPE_AGREE_JOIN = 13;
    public static final int TYPE_BYDDY_MSG = 1;
    public static final int TYPE_DELETE_MEMBER = 12;
    public static final int TYPE_DIS_MSG = 2;
    public static final int TYPE_FAVORITE = 8;
    public static final int TYPE_GET_GROUP_INFO = 6;
    public static final int TYPE_GET_GROUP_LIST = 5;
    public static final int TYPE_GET_GROUP_MEBMER = 7;
    public static final int TYPE_GET_LOGIN_ACCOUNT = 15;
    public static final int TYPE_GET_MEMBER_INFO = 14;
    public static final int TYPE_GROUP_MSG = 0;
    public static final int TYPE_SESS_MSG = 4;
    public static final int TYPE_SET_GROUP_SHUTUP = 11;
    public static final int TYPE_SET_MEMBER_CARD = 9;
    public static final int TYPE_SET_MEMBER_SHUTUP = 10;
    public static final int TYPE_SYS_MSG = 3;
    public long code;
    private HashMap data = new HashMap();
    public String groupName;
    public long groupid;
    public long time;
    public String title;
    public int type;
    public long uin;
    public String uinName;
    public int value;

    public PluginMsg() {
    }

    public PluginMsg(Parcel parcel) {
        readFromParcel(parcel);
    }

    public void addMsg(String str, String str2) {
        ArrayList arrayList = (ArrayList) this.data.get("index");
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.data.put("index", arrayList);
        }
        arrayList.add(str);
        ArrayList arrayList2 = (ArrayList) this.data.get(str);
        if (arrayList2 == null) {
            arrayList2 = new ArrayList();
            this.data.put(str, arrayList2);
        }
        arrayList2.add(str2);
    }

    public void clearMsg() {
        this.data = new HashMap();
    }

    public int describeContents() {
        return 0;
    }

    public HashMap getData() {
        return this.data;
    }

    public ArrayList getMsg(String str) {
        return (ArrayList) this.data.get(str);
    }

    public String getTextMsg() {
        StringBuilder sb = new StringBuilder("");
        ArrayList arrayList = (ArrayList) this.data.get("msg");
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
            }
        }
        return sb.toString();
    }

    public void readFromParcel(Parcel parcel) {
        this.type = parcel.readInt();
        this.groupid = parcel.readLong();
        this.code = parcel.readLong();
        this.uin = parcel.readLong();
        this.time = parcel.readLong();
        this.value = parcel.readInt();
        this.groupName = parcel.readString();
        this.uinName = parcel.readString();
        this.title = parcel.readString();
        parcel.readMap(this.data, getClass().getClassLoader());
    }

    public void setData(HashMap hashMap) {
        if (hashMap != null) {
            this.data = hashMap;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeLong(this.groupid);
        parcel.writeLong(this.code);
        parcel.writeLong(this.uin);
        parcel.writeLong(this.time);
        parcel.writeInt(this.value);
        parcel.writeString(this.groupName);
        parcel.writeString(this.uinName);
        parcel.writeString(this.title);
        parcel.writeMap(this.data);
    }
}
