package cx.study.yiyayo.app

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cx.study.yiyayo.app.base.BaseFragment

/**
 *
 * Created by cheng.xiao on 2017/9/5.
 */

class NotificationFragment : BaseFragment() {
    
    companion object {
        fun newInstance(): Fragment {
            return NotificationFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}