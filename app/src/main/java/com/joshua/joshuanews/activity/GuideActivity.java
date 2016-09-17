package com.joshua.joshuanews.activity;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.joshua.joshuanews.R;
import com.joshua.joshuanews.util.UiUtils;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {
    private static final int[] mImages = new int[]{
            R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3};
    private ViewPager vp_guide;
    private ArrayList<ImageView> mArrayList;
    private LinearLayout llpointGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        initListener();
        initViewPager();
        initPoints();
    }


    private void initUI() {
        setContentView(R.layout.activity_guide);
        vp_guide = (ViewPager) findViewById(R.id.vp_guide);
        llpointGroup = (LinearLayout) findViewById(R.id.ll_point_group);
    }


    private void initViewPager() {
        mArrayList = new ArrayList<>();
        for (int i = 0; i < mImages.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(mImages[i]);
            mArrayList.add(imageView);
        }
        vp_guide.setAdapter(new GuideAdapter());

    }

    private void initPoints() {
        for (int i = 0; i < mImages.length; i++) {
            View point = new View(this);
            point.setBackgroundResource(R.drawable.shape_point_gray);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(UiUtils.px2dip(10),UiUtils.px2dip(10));
            if(i>0){
                params.leftMargin=UiUtils.px2dip(10);
            }
            point.setLayoutParams(params);
            llpointGroup.addView(point);
        }
    }

    private void initListener() {
llpointGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
    @Override
    public void onGlobalLayout() {

    }
});
    }

    class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mImages.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mArrayList.get(position));
            return mArrayList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    class  GuideListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
