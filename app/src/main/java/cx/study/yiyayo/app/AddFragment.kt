package cx.study.yiyayo.app

import android.app.Activity.RESULT_CANCELED
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import butterknife.BindView
import com.hdl.mricheditor.bean.CamaraRequestCode
import com.hdl.mricheditor.view.MRichEditor
import cx.study.yiyayo.R
import cx.study.yiyayo.app.base.BaseFragment


/**
 *
 * Created by cheng.xiao on 2017/9/5.
 */

class AddFragment : BaseFragment() {

    @BindView(R.id.mre_editor)
    lateinit var editor: MRichEditor
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
    }

    /**
     * 需要重写这个方法选择图片、拍照才有用哦

     * @param requestCode
     * *
     * @param resultCode
     * *
     * @param data
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(context, "取消操作", Toast.LENGTH_LONG).show()
            return
        }
        if (requestCode == CamaraRequestCode.CAMARA_GET_IMG) {
            editor.insertImg(data!!.data)
        } else if (requestCode == CamaraRequestCode.CAMARA_TAKE_PHOTO) {
            editor.insertImg(data)
        }
    }

}