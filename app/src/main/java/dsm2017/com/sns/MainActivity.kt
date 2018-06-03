package dsm2017.com.sns

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dsm2017.com.sns.ViewPager.MainViewPageData
import dsm2017.com.sns.ViewPager.MainViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewpagerdata1 = arrayListOf<MainViewPageData>()
        val viewpagerdata2 = arrayListOf<MainViewPageData>()

        for(i in 1..5){
            viewpagerdata1.add(MainViewPageData(i.toString(), "sports_name", "user_name", "like : 30", "0000.00.00"))
        }
        for(i in 1..5){
            viewpagerdata2.add(MainViewPageData(i.toString(), "sports_name", "user_name", "like : 30", "0000.00.00"))
        }


        val mainViewPagerAdapter1 = MainViewPagerAdapter(MainActivity@ this, viewpagerdata1)
        main_viewpager1.adapter = mainViewPagerAdapter1

        val mainViewPageAdapter2 = MainViewPagerAdapter(MainActivity@ this, viewpagerdata2)
        main_viewpager2.adapter = mainViewPageAdapter2

        main_viewpager1_detail.setOnClickListener {
            val intent = Intent(MainActivity@this,ShowListActivity::class.java)
            startActivity(intent)
        }

        main_viewpager2_detail.setOnClickListener {
            val intent = Intent(MainActivity@this,ShowListActivity::class.java)
            startActivity(intent)
        }

        fab.setOnClickListener {
            val intent = Intent(MainActivity@this,WriteActivty::class.java)
            startActivity(intent)
        }

        main_mypage.setOnClickListener {
            val intent = Intent(MainActivity@this,MyPageActivity::class.java)
            startActivity(intent)
        }
    }
}
