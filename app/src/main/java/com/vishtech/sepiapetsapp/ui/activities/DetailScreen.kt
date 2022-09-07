package com.vishtech.sepiapetsapp.ui.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.vishtech.sepiapetsapp.R

private const val TAG = "DetailScreen"

class DetailScreen : AppCompatActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_screen)

        webView = findViewById(R.id.webView)
        val url: String? = intent.getStringExtra("url")
        if(url != null ){
            webView.loadUrl(url)
        }

        // this will enable the javascript.
        webView.settings.javaScriptEnabled = true

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        webView.webViewClient = WebViewClient()
    }
}