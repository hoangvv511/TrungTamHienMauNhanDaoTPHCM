package fighting.teamlego.trungtamhienmaunhandaotphcm.Menu;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fighting.teamlego.trungtamhienmaunhandaotphcm.MainActivity;
import fighting.teamlego.trungtamhienmaunhandaotphcm.Map.MapFragment;
import fighting.teamlego.trungtamhienmaunhandaotphcm.R;
import fighting.teamlego.trungtamhienmaunhandaotphcm.Slide_Image.FragmentSlider;
import fighting.teamlego.trungtamhienmaunhandaotphcm.Slide_Image.SliderIndicator;
import fighting.teamlego.trungtamhienmaunhandaotphcm.Slide_Image.SliderPagerAdapter;
import fighting.teamlego.trungtamhienmaunhandaotphcm.Slide_Image.SliderView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;
    private SliderView sliderView;
    private LinearLayout mLinearLayout;
    private Button btn_map;
    public HomeFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Trung Tâm Hiến Máu Nhân Đạo TP.HCM");
        // Inflate the layout for this fragment
        sliderView = (SliderView) rootView.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) rootView.findViewById(R.id.pagesContainer);
        btn_map = rootView.findViewById(R.id.btn_map);
        btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MapFragment mapFragment = new MapFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content_main, mapFragment, mapFragment.getTag()).commit();
            }
        });
        // jika internet aktfif
        setupSliderOfline();
        TextView tv = (TextView) rootView.findViewById(R.id.tv_sologan);
        tv.setSelected(true);

        return rootView;
    }

//    private void setupSlider() {
//        sliderView.setDurationScroll(800);
//        List<Fragment> fragments = new ArrayList<>();
//        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-1.jpg"));
//        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-2.jpg"));
//        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-3.jpg"));
//        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-4.jpg"));
//
//        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
//        sliderView.setAdapter(mAdapter);
//        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
//        mIndicator.setPageCount(fragments.size());
//        mIndicator.show();
//    }

    private void setupSliderOfline() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("trungtam1"));
        fragments.add(FragmentSlider.newInstance("trungtam2"));
        fragments.add(FragmentSlider.newInstance("trungtam3"));
        fragments.add(FragmentSlider.newInstance("trungtam4"));
        fragments.add(FragmentSlider.newInstance("trungtam5"));
        fragments.add(FragmentSlider.newInstance("trungtam6"));

        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }

}
