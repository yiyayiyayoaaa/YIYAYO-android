package cx.study.yiyayo

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife

class MainActivity : AppCompatActivity() ,BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.bottom_navigation_bar)
    lateinit var bottomNavigationBar: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this@MainActivity)
        bottomNavigationBar.setOnNavigationItemSelectedListener(this@MainActivity)
    }


    /**
     * 底部导航
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
        return true
    }
}
