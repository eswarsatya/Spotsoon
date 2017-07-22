package eswar.com.spotsoontask.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import eswar.com.spotsoontask.Adapters.CustomPageAdapter;
import eswar.com.spotsoontask.Adapters.ItemsAdapter;
import eswar.com.spotsoontask.R;
import eswar.com.spotsoontask.Modelclasses.VideosModel;
import me.relex.circleindicator.CircleIndicator;

public class Homeactivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
  private  ViewPager viewPager,viewPagertop;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_homeactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        List<VideosModel> getData = dataSource();
        viewPagertop = (ViewPager) findViewById(R.id.viewpager);
        CustomPageAdapter mCustomPagerAdapter = new CustomPageAdapter(Homeactivity.this, getData);
        viewPagertop.setAdapter(mCustomPagerAdapter);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPagertop);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
final TabLayout.Tab tab1=tabLayout.newTab().setText("VIDEOS");
        final TabLayout.Tab tab2=tabLayout.newTab().setText("IMAGES");
        final TabLayout.Tab tab3=tabLayout.newTab().setText("MILESTONE");

        tab1.setIcon(R.drawable.select_video);
        tab2.setIcon(R.drawable.image);
        tab3.setIcon(R.drawable.milestone);

        tabLayout.addTab(tab1,0);
        tabLayout.addTab(tab2,1);
        tabLayout.addTab(tab3,2);


        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this,R.color.tab_selector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,R.color.colorAccent));

//
//
//        tabLayout.addTab(tabLayout.newTab().setText("VIDEOS").setIcon(R.drawable.video));
//
//        tabLayout.addTab(tabLayout.newTab().setText("IMAGES").setIcon(R.drawable.image));
//
//        tabLayout.addTab(tabLayout.newTab().setText("MILESTONE").setIcon(R.drawable.milestone));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPager = (ViewPager) findViewById(R.id.pager);

        ItemsAdapter adapter = new ItemsAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
switch (position){
    case 0:
    tab1.setIcon(R.drawable.select_video);
    tab2.setIcon(R.drawable.image);
        tab3.setIcon(R.drawable.milestone);
        break;
    case 1:
        tab1.setIcon(R.drawable.video);
        tab2.setIcon(R.drawable.select_image);
        tab3.setIcon(R.drawable.milestone);
        break;
    case 2:
        tab1.setIcon(R.drawable.video);
        tab2.setIcon(R.drawable.image);
        tab3.setIcon(R.drawable.select_milestone);
       break;

}


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
});
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private List<VideosModel> dataSource(){
        List<VideosModel> data = new ArrayList<VideosModel>();
        data.add(new VideosModel(R.drawable.bieber));
        data.add(new VideosModel(R.drawable.rehman));
        data.add(new VideosModel(R.drawable.eminem));
        data.add(new VideosModel(R.drawable.jackson));
        data.add(new VideosModel(R.drawable.ludacris));
        return data;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}

