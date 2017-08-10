package app.vini.com.meadota.Util;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;


public class SignupFragment extends Fragment {

    protected ViewPager viewPager;

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public ViewPager getViewPager() {
        return viewPager;
    }

}
