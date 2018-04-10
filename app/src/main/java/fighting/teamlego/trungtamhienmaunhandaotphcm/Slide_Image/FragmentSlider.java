package fighting.teamlego.trungtamhienmaunhandaotphcm.Slide_Image;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import fighting.teamlego.trungtamhienmaunhandaotphcm.R;

public class FragmentSlider extends Fragment { // implements View.OnTouchListener {

    private static final String ARG_PARAM1 = "params";

    private String imageUrls;

    public FragmentSlider() {
    }

    public static FragmentSlider newInstance(String params) {
        FragmentSlider fragment = new FragmentSlider();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, params);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        imageUrls = getArguments().getString(ARG_PARAM1);

        Uri uri = Uri.parse("android.resource://fighting.teamlego.hoichuthapdobinhduong/drawable/" + imageUrls);

        View view = inflater.inflate(R.layout.fragment_slider_item, container, false);
        ImageView img = (ImageView) view.findViewById(R.id.img);
        Glide.with(getActivity())
                .load(uri)
                .placeholder(R.drawable.trungtam1)
                .into(img);

//        img.setOnTouchListener(this);
        return view;
    }
}