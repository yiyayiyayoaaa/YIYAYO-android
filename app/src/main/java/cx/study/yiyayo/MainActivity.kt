package cx.study.yiyayo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageButton
import android.widget.RadioGroup
import butterknife.BindView
import butterknife.ButterKnife
import cx.study.yiyayo.app.HomeFragment
import cx.study.yiyayo.app.NotificationFragment
import cx.study.yiyayo.app.SeeFragment
import cx.study.yiyayo.app.UserFragment
import cx.study.yiyayo.app.article.ArticleActivity

class MainActivity : AppCompatActivity() ,RadioGroup.OnCheckedChangeListener {
//    @BindView(R.id.bottom_navigation_bar)
//    lateinit var bottomNavigationBar: BottomNavigationView
//    @BindView(R.id.radio_home)
//    lateinit var radioHome: ImageButton
//    @BindView(R.id.radio_see)
//    lateinit var radioSee: ImageButton
    @BindView(R.id.radio_add)
    lateinit var radioAdd: ImageButton
//    lateinit var radioNotification: ImageButton
//    @BindView(R.id.radio_user)
//    lateinit var radioUser: ImageButton

    @BindView(R.id.radio_group)
    lateinit var radioGroup: RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this@MainActivity)
        val homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragment_container,homeFragment).commit()
        radioGroup.setOnCheckedChangeListener(this@MainActivity)
        radioAdd.setOnClickListener {  startActivity(Intent(this@MainActivity, ArticleActivity::class.java)) }
    }


    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = when (radioGroup.checkedRadioButtonId) {
            R.id.radio_home -> {
                HomeFragment.newInstance()
            }
            R.id.radio_see -> {
                SeeFragment.newInstance()
            }
            R.id.radio_notification -> {
                NotificationFragment.newInstance()
            }
            R.id.radio_user -> {
                UserFragment.newInstance()
            }
            else -> return
        }
        transaction.replace(R.id.fragment_container,fragment).commit()
    }

}
