package eswar.com.spotsoontask.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import eswar.com.spotsoontask.Fragments.ImagesFragment;
import eswar.com.spotsoontask.Fragments.MilestoneFragment;
import eswar.com.spotsoontask.Fragments.VideoFragment;

public class ItemsAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public ItemsAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                VideoFragment tab1 = new VideoFragment();
                return tab1;
            case 1:
                ImagesFragment tab2 = new ImagesFragment();
                return tab2;
            case 2:
                MilestoneFragment tab3 = new MilestoneFragment();
                return tab3;

            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
