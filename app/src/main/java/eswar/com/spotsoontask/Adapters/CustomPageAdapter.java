package eswar.com.spotsoontask.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import eswar.com.spotsoontask.Modelclasses.VideosModel;
import eswar.com.spotsoontask.R;

/**
 * Created by Anil on 23-08-2016.
 */
public class CustomPageAdapter extends PagerAdapter {
    private Context context;
    private List<VideosModel> dataObjectList;
    private LayoutInflater layoutInflater;

    public CustomPageAdapter(Context context, List<VideosModel> dataObjectList) {
        this.context = context;
        this.layoutInflater = (LayoutInflater) this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
        this.dataObjectList = dataObjectList;
    }

    @Override
    public int getCount() {
        return dataObjectList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = this.layoutInflater.inflate(R.layout.pager_list, container, false);
        ImageView displayImage = (ImageView) view.findViewById(R.id.large_image);
        displayImage.setImageResource(this.dataObjectList.get(position).getImageId());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
