package com.meghpy.educationonlinebd;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.animation.Animation;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class Websites extends AppCompatActivity {

    WebView webview;
    //    SwipeRefreshLayout reload;
    LinearLayout layRoot, layNonet;
    LottieAnimationView progressBar;
    ImageView imgBack;
    TextView webTitile;
    Animation animation;
    String USER_AGENT_ = "Mozilla/5.0 (Linux; Android 4.1.1; Galaxy Nexus Build/JRO03C) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);

        layRoot = findViewById(R.id.layRoot);
//        reload = findViewById(R.id.reload);
        layNonet = findViewById(R.id.layNonet);
        progressBar = findViewById(R.id.progressBar);
        imgBack = findViewById(R.id.imgBack);
        webTitile = findViewById(R.id.webTitile);
        animation = android.view.animation.AnimationUtils.loadAnimation(Websites.this, R.anim.middle_to_top);


        Intent intent = getIntent();
        String website = intent.getStringExtra("links");



        //Creating webView programitcally which supports media player and js automatically like a browser
        webview = new WebView(Websites.this);
        webview.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        webview.setFitsSystemWindows(false); // your preferences
        webview.setVerticalScrollBarEnabled(false); // your preferences
        webview.setPadding(15,15,15,15); // your preferences
        layRoot.addView(webview);

        //----------------------------
        webview.getSettings().setUserAgentString(USER_AGENT_);
        webview.getSettings().setLoadsImagesAutomatically(true);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setAllowFileAccess(true);
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setUseWideViewPort(true);


        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setDisplayZoomControls(false);
        webview.getSettings().setBlockNetworkLoads (false);
        webview.getSettings().setMediaPlaybackRequiresUserGesture(false);

        WebSettings webSettings = webview.getSettings();
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setDomStorageEnabled(true);

        webview.setWebChromeClient(new ChromeClient());
        webview.setWebViewClient(new HelloWebViewClient());



        //-----------------------------

        checkDownloadPermission();

        webview.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                DownloadManager.Request request =new DownloadManager.Request(Uri.parse(url));
                request.setTitle(URLUtil.guessFileName(url,contentDisposition,mimetype));
                request.setDescription("Downloading file...");
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,URLUtil.guessFileName(url, contentDisposition, mimetype));
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
                Toast.makeText(getApplicationContext(),"Downloading...",Toast.LENGTH_SHORT).show();
                BroadcastReceiver onComplete = new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        Toast.makeText(getApplicationContext(),"Downloading Complete",Toast.LENGTH_SHORT).show();
                    }
                };
            }
        });

        //-----------------------------

        if (Build.VERSION.SDK_INT >= 19) {
            webview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }

        webview.loadUrl(website);



        if(!isNetworkAvailable(Websites.this)){
            webview.setVisibility(View.GONE);
            layNonet.setVisibility(View.VISIBLE);
        }else{
            webview.setVisibility(View.VISIBLE);
            layNonet.setVisibility(View.GONE);
        }

        webTitile.setText(""+"Website");
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


//        reload.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                reload.setRefreshing(false);
//                webview.reload();
//
//            }
//        });


    }



    public static boolean isNetworkAvailable(Context context) {
        return ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE))
                .getActiveNetworkInfo() != null;
    }


    private class HelloWebViewClient extends WebViewClient {

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
//            reload.setRefreshing(false);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

    }
    //=================================================

    //================================================= defining custom class (ChromeClient)
    private class ChromeClient extends WebChromeClient {
        // Defining some variables


        private View mCustomView;
        private CustomViewCallback mCustomViewCallback;
        protected FrameLayout mFullscreenContainer;
        private int mOriginalOrientation;
        private int mOriginalSystemUiVisibility;
        ChromeClient() {}

        //------------------

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);

            if(newProgress >= 100){
                // Page loading finish
                progressBar.setVisibility(View.GONE);

            }else{
                progressBar.setVisibility(View.VISIBLE);
            }
        }

        //-----------------


        public Bitmap getDefaultVideoPoster() {
            if (mCustomView == null) {
                return null;
            }
            return BitmapFactory.decodeResource(getApplicationContext().getResources(), 2130837573);
        }

        public void onHideCustomView()
        {
            ((FrameLayout)getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }

        public void onShowCustomView(View paramView, CustomViewCallback paramCustomViewCallback)
        {
            if (this.mCustomView != null)
            {
                onHideCustomView();
                return;
            }
            this.mCustomView = paramView;
            this.mOriginalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            this.mOriginalOrientation = getRequestedOrientation();
            this.mCustomViewCallback = paramCustomViewCallback;
            ((FrameLayout)getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
            getWindow().getDecorView().setSystemUiVisibility(3846 | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            finish();
        }
    }


    private void checkDownloadPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(Websites.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(Websites.this, "Write External Storage permission allows us to save files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(Websites.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
        }
    }

}