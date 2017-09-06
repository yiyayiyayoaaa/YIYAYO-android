package cx.study.yiyayo.app

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import cx.study.yiyayo.R
import cx.study.yiyayo.app.base.BaseFragment
import org.xwalk.core.XWalkView


/**
 *
 * Created by cheng.xiao on 2017/9/5.
 */

class AddFragment : BaseFragment() {

    @BindView(R.id.x_walk_view)
    lateinit var xWalkView: XWalkView
    companion object {
        fun newInstance(): Fragment {
            return AddFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        xWalkView.loadUrl("file:///android_asset/hello.html")
    }

    override fun onPause() {
        super.onPause()
        xWalkView.pauseTimers()
        xWalkView.onHide()
    }

    override fun onResume() {
        super.onResume()
        xWalkView.resumeTimers()
        xWalkView.onShow()
    }

    override fun onDestroyView() {
        xWalkView.onDestroy()
        super.onDestroyView()
    }

}