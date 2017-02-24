package hu.pe.routengo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by megaman on 24.02.2017.
 */
public class IntroAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;

    public IntroAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setFragments(Fragment... params) {
        this.list = Arrays.asList(params);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
