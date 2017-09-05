package cx.study.yiyayo.app.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast

/**
 *
 * Created by cheng.xiao on 2017/9/5.
 */
open class BaseFragment: Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Toast.makeText(context, this.javaClass.name, Toast.LENGTH_SHORT).show()
    }
}