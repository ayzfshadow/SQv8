package saki.ui;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.ayzf.sqv8.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import saki.client.packagea.mark9_classa;
import saki.qq.global.mark12_classc;
import saki.qq.global.mark12_classh;
import saki.qq.datapacket.unpack.mark14_classah;
import saki.qq.datapacket.unpack.ReMessageSvc_PbGetMsg;
import saki.qq.datapacket.unpack.ReOnlinePush_PbPushDisMsg;
import saki.qq.datapacket.unpack.ReOnlinePush_PbPushGroupMsg;
import saki.qq.datapacket.unpack.ReOnlinePush_PbPushTransMsg;
import saki.ui.packagea.mark22_classb;
import saki.ui.packageb.mark23_classb;
import androidx.appcompat.widget.PopupMenu;
import android.view.MenuItem;

public class MessageActivity extends AppCompatActivity implements TextWatcher, View.OnClickListener, AdapterView.OnItemLongClickListener, mark23_classb,PopupMenu.OnMenuItemClickListener 
{



    public long a;
    public long b = 1;
    public ListView c;
    public mark22_classb d;
    public Button e;
    public EditText f;
    public Button choose;

    /* access modifiers changed from: private */
    public int h = 0;
    private Handler i = new mark21_classf(this);

    private String a(HashMap hashMap)
    {
        String str = "";
        ArrayList arrayList = (ArrayList) hashMap.get("msg");
        if (arrayList != null)
        {
            Iterator it = arrayList.iterator();
            while (it.hasNext())
            {
                str = String.valueOf(str) + ((String) it.next());
            }
        }
        ArrayList arrayList2 = (ArrayList) hashMap.get("img");
        if (arrayList2 != null)
        {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext())
            {
                str = String.valueOf(str) + ((String) it2.next());
            }
        }
        return str;
    }

    public void a(mark14_classah mark14_classah)
    {
    }

    public void a(ReMessageSvc_PbGetMsg mark14_classl)
    {
    }

    public void a(ReOnlinePush_PbPushDisMsg mark14_classv)
    {
    }

    public void a(ReOnlinePush_PbPushGroupMsg mark14_classw)
    {
        if (mark14_classw.c == this.a)
        {
            this.d.a((Bitmap) null, mark14_classw.e, mark14_classw.a, mark14_classw.i, a(mark14_classw.j), mark12_classc.c == mark14_classw.a);
        }
    }

    public void a(ReOnlinePush_PbPushTransMsg mark14_classx)
    {
    }

    public void afterTextChanged(Editable editable)
    {
        if (editable.toString().equals(""))
        {
            if (this.e.isEnabled())
            {
                this.e.setEnabled(false);
            }
        }
        else if (!this.e.isEnabled())
        {
            this.e.setEnabled(true);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4)
    {
    }


    public void showPopup(View view)
    { 
        PopupMenu popupMenu = new PopupMenu(this, view); 
        popupMenu.getMenuInflater().inflate(R.menu.menu_activity_messageactivity, popupMenu.getMenu()); 
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show(); 
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.layoutactivitymessageactivityButtonChoose:{
                    showPopup(view);
                }break;
            case R.id.layoutactivitymessageactivityButtonSend:{
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(this.f.getText().toString());
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    HashMap<String,ArrayList> hashMap = new HashMap<>();
                    if (this.h == 0)
                    {
                        arrayList2.add("msg");
                        hashMap.put("msg", arrayList);
                    }
                    else if (this.h == 1)
                    {
                        arrayList2.add("img");
                        hashMap.put("img", arrayList);
                    }
                    else if (this.h == 2)
                    {
                        arrayList2.add("xml");
                        hashMap.put("xml", arrayList);
                    }
                    else if (this.h == 3)
                    {
                        arrayList2.add("json");
                        hashMap.put("json", arrayList);
                    }

                    hashMap.put("index", arrayList2);
                    startService(mark9_classa.a((Context) this, this.a, -1, hashMap));
                    this.f.setText("");
                }
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem p1)
    {
        switch (p1.getItemId())
        {
            case R.id.menuactivitymessageactivitytypetext:{
                    this.choose.setText("文本");
                    this.h = 0;
                }break;
            case R.id.menuactivitymessageactivitytypeimg:{
                    this.choose.setText("图片");
                    this.h = 1;
                }break;
            case R.id.menuactivitymessageactivitytypexml:{
                    this.choose.setText("xml");
                    this.h = 2;
                }break;
            case R.id.menuactivitymessageactivitytypejson:{
                    this.choose.setText("json");
                    this.h = 3;
                }break;
        }
        return true;
    }


    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.layout_activity_messageactivity);
        this.c = (ListView) findViewById(R.id.id004a);
        this.d = new mark22_classb(this, this.c);
        this.c.setAdapter(this.d);
        this.f = (EditText) findViewById(R.id.id0046);
        this.e = (Button) findViewById(R.id.layoutactivitymessageactivityButtonSend);
        this.choose = this.findViewById(R.id.layoutactivitymessageactivityButtonChoose);
        this.a = getIntent().getLongExtra("id", -1);
        this.e.setOnClickListener(this);
        this.choose.setOnClickListener(this);
        this.e.setEnabled(false);
        this.f.addTextChangedListener(this);
        this.c.setOnItemLongClickListener(this);

        mark12_classh.a().a((mark23_classb) this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy()
    {
        mark12_classh.a().b((mark23_classb) this);
        super.onDestroy();
    }

    @SuppressLint({"NewApi"})
    public boolean onItemLongClick(AdapterView adapterView, View view, int i2, long j)
    {
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("msg", this.d.getItem(i2).b));
        Toast.makeText(this, "复制完成", 0).show();
        return false;
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4)
    {
    }
}
