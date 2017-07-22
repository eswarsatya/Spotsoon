package eswar.com.spotsoontask.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import eswar.com.spotsoontask.Modelclasses.Modelcardviewdetails;
import eswar.com.spotsoontask.R;

/**
 * Created by ESWARI on 21-07-2017.
 */

public class AdapterCardview extends RecyclerView.Adapter<AdapterCardview.MemberViewHolder> {
    private List<Modelcardviewdetails> members;
    private Context context;

    public AdapterCardview(List<Modelcardviewdetails> members, Context context) {
        this.members = members;
        this.context = context;
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView name_tv;
        private TextView vidoetime_tv;
        private ImageView pic_iv;

        public MemberViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cv_videos);
            name_tv = (TextView) itemView.findViewById(R.id.tv_videoName);
            vidoetime_tv = (TextView) itemView.findViewById(R.id.tv_videotime);
            pic_iv = (ImageView) itemView.findViewById(R.id.igv_ProfilePic);
        }
    }

    @Override
    public void onBindViewHolder(MemberViewHolder memberViewHolder, int i) {
        memberViewHolder.name_tv.setText(members.get(i).getName());
        memberViewHolder.vidoetime_tv.setText(members.get(i).getEmail());
        memberViewHolder.pic_iv.setImageResource(members.get(i).getPhotoID());
    }

    @Override
    public MemberViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_row, viewGroup, false);
        MemberViewHolder memberViewHolder = new MemberViewHolder(view);
        return memberViewHolder;
    }

    @Override
    public int getItemCount() {
        return members.size();
    }
}



