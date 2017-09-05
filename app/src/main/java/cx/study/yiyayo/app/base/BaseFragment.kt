package cx.study.yiyayo.app.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import butterknife.ButterKnife
import butterknife.Unbinder

/**
 *
 * Created by cheng.xiao on 2017/9/5.
 */
open class BaseFragment: Fragment() {

    var binder: Unbinder? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binder = ButterKnife.bind(this, view)
    }

    override fun onDestroy() {
        super.onDestroy()
        binder?.unbind()
    }
}