package com.android45.musicapp.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.android45.musicapp.ImageConverter;
import com.android45.musicapp.R;
import com.android45.musicapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
Bitmap bitmap, circularBitmap;
    ImageView circularImageView;
    FragmentHomeBinding fragmentHomeBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.maxresdefault);
//        Bitmap circularBitmap = ImageConverter.getRoundedCornerBitmap(bitmap, 100);
//        ImageView circularImageView = (ImageView) findViewById(R.id.imageView);
//        circularImageView.setImageBitmap(circularBitmap);

        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        bitmap= BitmapFactory.decodeResource(this.getResources(), R.drawable.maxresdefault);
        circularBitmap = ImageConverter.getRoundedCornerBitmap(bitmap, 100);
        fragmentHomeBinding.imageView.setImageBitmap(circularBitmap);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}