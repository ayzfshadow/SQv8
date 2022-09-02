package saki.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.net.http.SslError;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Keep;
import com.ayzf.sqv8.R;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;
import saki.client.packagea.mark9_classa;
import saki.ui.LoginActivity;

public class OtherWindow extends Dialog implements
View.OnClickListener ,DialogInterface.OnDismissListener
{

	private Context context;

	private LoginResultHandler handler;
	class WebC extends WebViewClient {
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler,SslError error) {
            handler.proceed();
        }
        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            view.loadUrl("file:///android_asset/404.html");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
			System.out.println(url);
			return true;
//            }
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            Uri u = request.getUrl();
			System.out.println();
			System.out.println(URLDecoder.decode(u.toString()));
			onVerifyCAPTCHA(URLDecoder.decode(u.toString()).replaceAll("^jsbridge://CAPTCHA/onVerifyCAPTCHA\\?p=","").replaceAll("#2$",""));
//            String scheme = u.getScheme();
//            if (scheme.equals("http")||scheme.equals("https")){
//                return super.shouldOverrideUrlLoading(view,request);
//            } else {

			return true;
//            }
        }
    }
    private WebView web;


	private String ticket;

	private int result;

    public OtherWindow(Context context, String url,LoginResultHandler handler) {
        super(context);
		this.handler=handler;
		this.context=context;
		System.out.println(url);
        setContentView(R.layout.layout_view_chaptchadialog);
        web = (WebView) findViewById(R.id.layoutviewchaptchadialogWebview1);
		WebSettings mWebSettings = web.getSettings();
        //让webview支持js
        mWebSettings.setJavaScriptEnabled(true);
        //设置是否支持缩放模式
        mWebSettings.setSupportZoom(false);
        mWebSettings.setBuiltInZoomControls(true);
        // 是否显示+ -
        mWebSettings.setDisplayZoomControls(false);
		web.addJavascriptInterface(this,"CAPTCHA");
		web.setWebViewClient(new WebC());



        web.loadUrl(url);


        setOnDismissListener(this);
        show();
    }

	@JavascriptInterface
	@Keep
	public void onVerifyCAPTCHA(String json){
		try
		{
			JSONObject g = new JSONObject(json);
			this.result=g.getInt("result");
			if(result==0){
				this.ticket=g.getString("ticket");
			}

		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		this.dismiss();
	}

    @Override
    public void onClick(View v) {
        dismiss();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        if (context != null) {
			if(this.ticket==null){
				handler.a(3,"放弃滑块验证".getBytes());
				return;
			}
			if(this.result==0){
				context.startService(mark9_classa.a(context, this.ticket));
			}
        }
    }
}

