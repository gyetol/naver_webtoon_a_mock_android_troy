package com.softsquared.naverwebtoon.src.main.adapters;

        import android.content.Context;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.viewpager.widget.PagerAdapter;

        import com.bumptech.glide.Glide;
        import com.softsquared.naverwebtoon.R;
        import com.softsquared.naverwebtoon.src.main.fragmentwebtoon.TopBannerService;
        import com.softsquared.naverwebtoon.src.main.interfaces.TopBannerView;
        import com.softsquared.naverwebtoon.src.main.models.TopBannerResponse;
        import com.softsquared.naverwebtoon.src.main.models.TopBannerResult;

        import java.io.IOException;
        import java.io.InputStream;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.List;

public class ImageViewPagerAdapter extends PagerAdapter implements TopBannerView{
    private Context mContext = null;
    private List<TopBannerResult> list = null;


    public ImageViewPagerAdapter(){}

    public ImageViewPagerAdapter(Context mContext) {
        this.mContext = mContext;
        tryGetTopBannerList();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = null;

        if(mContext != null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.page, container, false);
            ImageView imageView = view.findViewById(R.id.viewpager_image);

            Log.d("haha","들어왔니?");
            try {
                String urlString = list.get(position).getBannerPhoto(); //여기서 retrofit통신으로 얻어온 String타입의 사진주소를 받아옵니다.
                Log.d("haha",urlString);
                Glide.with(mContext).load(urlString).into(imageView);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // imageView.setImageResource(R.drawable.webtoon_viewpager_1+position);  //이 주석을 풀면 로컬에 있는 사진으로 잘나옵니다.
        }

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (View)object);
    }

    public void tryGetTopBannerList(){
        final TopBannerService topBannerService = new TopBannerService(this);
        topBannerService.getTopBannerList();
    }

    @Override
    public void validateSuccess(List<TopBannerResult> results) {
        list = results;
    }

    @Override
    public void validateFailure(String message) {

    }



}
