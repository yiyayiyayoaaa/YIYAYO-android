package cx.study.yiyayo.app.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.Unbinder


/**
 *
 * Created by cheng.xiao on 2017/9/6.
 */
@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {
    lateinit var binder: Unbinder


    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        binder = ButterKnife.bind(this@BaseActivity)
    }

    override fun onDestroy() {
        super.onDestroy()
        binder.unbind()
    }
}