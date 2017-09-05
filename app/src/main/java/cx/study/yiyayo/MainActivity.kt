package cx.study.yiyayo

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import butterknife.BindView
import butterknife.ButterKnife
import cx.study.yiyayo.app.*

class MainActivity : AppCompatActivity() ,BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.bottom_navigation_bar)
    lateinit var bottomNavigationBar: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this@MainActivity)
        val homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragment_container,homeFragment).commit()
        bottomNavigationBar.setOnNavigationItemSelectedListener(this@MainActivity)
    }


    /**
     * 底部导航菜单切换
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val transaction = supportFragmentManager.beginTransaction()
        var fragment: Fragment? = null
        when (item.itemId) {
            R.id.menu_one -> {
                fragment = HomeFragment.newInstance()
            }
            R.id.menu_two -> {
                fragment = SeeFragment.newInstance()
            }
            R.id.menu_three -> {
                fragment = AddFragment.newInstance()
            }
            R.id.menu_four -> {
                fragment = NotificationFragment.newInstance()
            }
            R.id.menu_five -> {
                fragment = UserFragment.newInstance()
            }
        }
        transaction.replace(R.id.fragment_container,fragment).commit()
        return true
    }

}
