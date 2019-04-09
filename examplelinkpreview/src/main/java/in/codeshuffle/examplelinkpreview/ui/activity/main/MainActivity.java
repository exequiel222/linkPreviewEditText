package in.codeshuffle.examplelinkpreview.ui.activity.main;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.codeshuffle.examplelinkpreview.R;
import in.codeshuffle.examplelinkpreview.ui.fragment.aboutdev.AboutDevFragment;
import in.codeshuffle.examplelinkpreview.ui.fragment.demoscreen.DemoFragment;
import in.codeshuffle.examplelinkpreview.ui.fragment.webpagescreen.WebPageContent;
import in.codeshuffle.examplelinkpreview.ui.fragment.webpagescreen.WebPageFragment;
import in.codeshuffle.examplelinkpreview.util.AppUtils;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.navView)
    NavigationView navigationView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.container)
    ViewGroup container;

    private FragmentManager fragmentManager;
    private DemoFragment demoFragment;
    private WebPageFragment githubFragment;
    private WebPageFragment aboutLibraryFragment;
    private WebPageFragment issueFeedBackFragment;
    private WebPageFragment donateBeerFragment;
    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupFragments();
        setupNavDrawer();
        setupActionbarWithToggle();
    }

    private void setupActionbarWithToggle() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                    this, mDrawerLayout, toolbar,
                    R.string.navigation_drawer_open, R.string.navigation_drawer_close
            );
            mDrawerLayout.setDrawerListener(mDrawerToggle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            mDrawerToggle.syncState();
        }
    }

    private void setupNavDrawer() {
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setupFragments() {
        demoFragment = DemoFragment.getInstance();
        aboutLibraryFragment = WebPageFragment.getInstance(WebPageContent.PAGE_VIEW_ABOUT_LIBRARY);
        githubFragment = WebPageFragment.getInstance(WebPageContent.PAGE_VIEW_IN_GITHUB);
        issueFeedBackFragment = WebPageFragment.getInstance(WebPageContent.PAGE_ISSUE_AND_FEEDBACK);
        donateBeerFragment = WebPageFragment.getInstance(WebPageContent.PAGE_DONATE_BEER);

        fragmentManager = getSupportFragmentManager();
        replaceFragment(demoFragment);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navMenuHome:
                replaceFragment(demoFragment);
                toolbar.setTitle(getString(R.string.library_app_name));
                menuItem.setChecked(true);
                break;
            case R.id.navMenuAboutLibrary:
                replaceFragment(aboutLibraryFragment);
                toolbar.setTitle(getString(R.string.about_library));
                menuItem.setChecked(true);
                break;
            case R.id.navMenuGithub:
                replaceFragment(githubFragment);
                toolbar.setTitle(getString(R.string.source_code));
                menuItem.setChecked(true);
                break;
            case R.id.navMenuIssueFeedback:
                replaceFragment(issueFeedBackFragment);
                toolbar.setTitle(getString(R.string.issues_and_feedback));
                menuItem.setChecked(true);
                break;
            case R.id.navMenuDonateBeer:
                replaceFragment(donateBeerFragment);
                toolbar.setTitle(getString(R.string.thanks_for_the_beer));
                AppUtils.showShortToast(this,
                        getString(R.string.thats_so_nice_of_you));
                break;
            case R.id.navMenuAbout:
                AboutDevFragment aboutDevFragment = AboutDevFragment.getInstance();
                aboutDevFragment.show(getSupportFragmentManager(), aboutDevFragment.getTag());
                break;
            case R.id.navMenuRateApp:
                AppUtils.openPlayStoreForApp(this);
                AppUtils.showShortToast(this,
                        getString(R.string.thanks_for_the_support));
                break;
            case R.id.navMenuShareApp:
                AppUtils.shareLibraryApp(this);
                break;
        }
        mDrawerLayout.closeDrawers();
        return true;
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        AppUtils.showShortToast(this, getString(R.string.press_back_to_exit));

        new Handler().postDelayed(()
                -> doubleBackToExitPressedOnce = false, 2000);
    }

    private void replaceFragment(Fragment instance) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, instance);
        fragmentTransaction.commit();
    }
}
