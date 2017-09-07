package cx.study.yiyayo.app.article

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_GET_CONTENT
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Base64
import android.webkit.JavascriptInterface
import android.webkit.WebView
import butterknife.BindView
import cx.study.yiyayo.R
import cx.study.yiyayo.app.base.BaseActivity
import java.io.ByteArrayOutputStream


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

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
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
                        val inputStream = contentResolver.openInputStream(uri)
                        val bitmap = BitmapFactory.decodeStream(inputStream)
                        val str =  bitmapToString(bitmap)
                        webView.evaluateJavascript("javascript:loadImage($str)",null)
                    }
                }
            }
        }
    }

    private fun bitmapToString(bitmap: Bitmap): String? {
        //将Bitmap转换成字符串
        val string: String?
        val bStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bStream)
        val bytes = bStream.toByteArray()
        string = Base64.encodeToString(bytes, Base64.DEFAULT)
        return string
    }

    override fun onPause() {
        super.onPause()
        webView.pauseTimers()
    }

    override fun onResume() {
        super.onResume()
        webView.resumeTimers()
    }

}