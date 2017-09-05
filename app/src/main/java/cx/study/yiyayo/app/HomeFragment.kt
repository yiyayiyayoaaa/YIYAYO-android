package cx.study.yiyayo.app

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import cx.study.yiyayo.R
import cx.study.yiyayo.app.base.BaseFragment
import cx.study.yiyayo.bean.User

/**
 *
 * Created by cheng.xiao on 2017/9/5.
 */

class HomeFragment : BaseFragment() {

    @BindView(R.id.list_view)
    lateinit var listView: RecyclerView
    companion object {
        fun newInstance(): Fragment {
            return HomeFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listView.layoutManager = LinearLayoutManager(context ,LinearLayoutManager.VERTICAL, false)
        val userList: ArrayList<User> = ArrayList()
        var i = 0
        while (i < 15) {
            userList.add(User())
            i ++
        }
        listView.adapter = Adapter(userList)
    }




    class Adapter(var userList: ArrayList<User>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

        override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        }

        override fun getItemCount(): Int = userList.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_view_item_user, parent, false)
            return ViewHolder(view)
        }


        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            init {
                ButterKnife.bind(itemView)
            }
        }

    }
}