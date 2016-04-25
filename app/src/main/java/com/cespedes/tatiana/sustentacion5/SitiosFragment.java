package com.cespedes.tatiana.sustentacion5;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class SitiosFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3;


    public SitiosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_sitios, null);
        tabLayout = (TabLayout) view.findViewById(R.id.tabSitios);
        viewPager = (ViewPager) view.findViewById(R.id.viewpagerSitios);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        tabLayout.post(new Runnable() {

            @Override
            public void run() {
                 tabLayout.setupWithViewPager(viewPager);
            }
        });
       return view;
    //    return inflater.inflate(R.layout.fragment_sitios, container, false);
    }

    class MyAdapter extends FragmentPagerAdapter {


        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
            case 0:
                return new sitios_tunel();
            case 1:
                return new sitios_chibuga();
            case 2:
                return new sitios_laura();
            }
            return null;
        }
        @Override
        public int getCount() {
             return int_items;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Túnel";
                case 1:
                    return "Chibugá";
                case 2:
                    return "Santuario";
            }
            return null;
        }
    }
}
