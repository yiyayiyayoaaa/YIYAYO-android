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
        supportFragmentManager.beginTransaction().add(homeFragment, HomeFragment.TAG).commit()
        bottomNavigationBar.setOnNavigationItemSelectedListener(this@MainActivity)
    }


    /**
     * 底部导航
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val transaction = supportFragmentManager.beginTransaction()
        var fragment: Fragment? = null
        when (item.itemId) {
            R.id.menu_one -> {
                fragment = supportFragmentManager.findFragmentByTag(HomeFragment.TAG)
                if (fragment == null) {
                    fragment = HomeFragment.newInstance()
                    transaction.add(fragment, HomeFragment.TAG)
                }
            }
            R.id.menu_two -> {
                fragment = supportFragmentManager.findFragmentByTag(SeeFragment.TAG)
                if (fragment == null) {
                    fragment = SeeFragment.newInstance()
                    transaction.add(fragment, SeeFragment.TAG)
                }
            }
            R.id.menu_three -> {
                fragment = supportFragmentManager.findFragmentByTag(AddFragment.TAG)
                if (fragment == null) {
                    fragment = AddFragment.newInstance()
                    transaction.add(fragment, AddFragment.TAG)
                }
            }
            R.id.menu_four -> {
                fragment = supportFragmentManager.findFragmentByTag(NotificationFragment.TAG)
                if (fragment == null) {
                    fragment = NotificationFragment.newInstance()
                    transaction.add(fragment, NotificationFragment.TAG)
                }
            }
            R.id.menu_five -> {
                fragment = supportFragmentManager.findFragmentByTag(UserFragment.TAG)
                if (fragment == null) {
                    fragment = UserFragment.newInstance()
                    transaction.add(fragment, UserFragment.TAG)
                }
            }
        }
        transaction.show(fragment).commit()
        return true
    }
}
