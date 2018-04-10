package fighting.teamlego.trungtamhienmaunhandaotphcm;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import fighting.teamlego.trungtamhienmaunhandaotphcm.Menu.CuocThiSangTac_Fragment;
import fighting.teamlego.trungtamhienmaunhandaotphcm.Menu.DangKiHienMau_Fragment;
import fighting.teamlego.trungtamhienmaunhandaotphcm.Menu.GuongHienMau_Fragment;
import fighting.teamlego.trungtamhienmaunhandaotphcm.Menu.HoatDongCLB_Fragment;
import fighting.teamlego.trungtamhienmaunhandaotphcm.Menu.HoiDap_Fragment;
import fighting.teamlego.trungtamhienmaunhandaotphcm.Menu.HomeFragment;
import fighting.teamlego.trungtamhienmaunhandaotphcm.Menu.LienHe_Fragment;
import fighting.teamlego.trungtamhienmaunhandaotphcm.Menu.NhomMauVaSucKhoe_Fragment;
import fighting.teamlego.trungtamhienmaunhandaotphcm.Menu.SuKien_Fragment;
import fighting.teamlego.trungtamhienmaunhandaotphcm.Menu.ThongBao_Fragment;
import fighting.teamlego.trungtamhienmaunhandaotphcm.Menu.ThongTin_Fragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        HomeFragment homeFragment = new HomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content_main, homeFragment, homeFragment.getTag()).commit();

        //New
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
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        // Quit if back is pressed
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            moveTaskToBack(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id == R.id.nav_home)
        {
            HomeFragment homeFragment = new HomeFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, homeFragment, homeFragment.getTag()).commit();
        }
        else if (id == R.id.nav_sukien) {
            SuKien_Fragment suKien_fragment = new SuKien_Fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, suKien_fragment, suKien_fragment.getTag()).commit();
        }
        else if (id == R.id.nav_thongbaohienmau) {
            ThongBao_Fragment thongBao_fragment = new ThongBao_Fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, thongBao_fragment, thongBao_fragment.getTag()).commit();
        }
        else if (id == R.id.nav_guonghienmau) {
            GuongHienMau_Fragment guongHienMau_fragment = new GuongHienMau_Fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, guongHienMau_fragment, guongHienMau_fragment.getTag()).commit();
        }
        else if (id == R.id.nav_hoatdongCLB) {
            HoatDongCLB_Fragment hoatDongCLB_fragment = new HoatDongCLB_Fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, hoatDongCLB_fragment, hoatDongCLB_fragment.getTag()).commit();
        }
        else if (id == R.id.nav_cuocthi) {
            CuocThiSangTac_Fragment cuocThiSangTac_fragment = new CuocThiSangTac_Fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, cuocThiSangTac_fragment, cuocThiSangTac_fragment.getTag()).commit();
        }
        else if (id == R.id.nav_hoidap) {
            HoiDap_Fragment hoiDap_fragment = new HoiDap_Fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, hoiDap_fragment, hoiDap_fragment.getTag()).commit();
        }
        else if (id == R.id.nav_nhommauvasuckhoe) {
            NhomMauVaSucKhoe_Fragment nhomMauVaSucKhoe_fragment = new NhomMauVaSucKhoe_Fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, nhomMauVaSucKhoe_fragment, nhomMauVaSucKhoe_fragment.getTag()).commit();
        }
        else if (id == R.id.nav_dangkihienmau) {
            DangKiHienMau_Fragment dangKiHienMau_fragment = new DangKiHienMau_Fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_main, dangKiHienMau_fragment, dangKiHienMau_fragment.getTag()).commit();
        }
        else if (id == R.id.nav_infor) {
            ThongTin_Fragment thongTin_fragment = new ThongTin_Fragment();
            FragmentManager manager = getSupportFragmentManager();
            thongTin_fragment.show(manager, "Thông tin");
        }
        else if (id == R.id.nav_contact) {
            LienHe_Fragment lienHe_fragment = new LienHe_Fragment();
            FragmentManager manager = getSupportFragmentManager();
            lienHe_fragment.show(manager, "Thông tin");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
