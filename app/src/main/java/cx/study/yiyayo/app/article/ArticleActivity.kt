package cx.study.yiyayo.app.article

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_GET_CONTENT
import android.net.Uri
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import butterknife.BindView
import cx.study.yiyayo.R
import cx.study.yiyayo.app.base.BaseActivity
import cx.study.yiyayo.utils.ImageUtils
import org.apache.commons.lang3.StringEscapeUtils


/**
 *
 * Created by cheng.xiao on 2017/9/6.
 */

open class ArticleActivity : BaseActivity() {

    @BindView(R.id.web_view)
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_add)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        webView.settings.javaScriptEnabled = true
        webView.settings.defaultTextEncodingName = "utf-8";
        webView.addJavascriptInterface(SelectImageInterface(this@ArticleActivity), "SelectImage")
        webView.loadUrl("file:///android_asset/hello.html")
    }

    class SelectImageInterface(private var context: Activity){

        @JavascriptInterface
        fun select(): String {
            val intent = Intent(ACTION_GET_CONTENT)
            //选择图片格式
            intent.type = "image/*"
            intent.putExtra("return-data", true)
            context.startActivityForResult(intent, 2)
            return "dadasdadsada"
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){
            2 -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val uri: Uri? = data.data
                    if (uri != null) {
                        val str = convert(ImageUtils.getImageString(ImageUtils.getSmallBitmap(uri, this)))
                        webView.loadUrl("javascript:loadImage('$str')")
                    }
                }
            }
        }
    }

    private fun convert(str: String?): String{
        val tag = "data:image/jpeg;base64,$str"
        return StringEscapeUtils.unescapeHtml4(tag)
    }

    override fun onPause() {
        super.onPause()
        webView.evaluateJavascript("getContent()", {str ->
        })
        webView.pauseTimers()
    }

    override fun onResume() {
        super.onResume()
        webView.resumeTimers()
    }

}