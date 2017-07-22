package eswar.com.spotsoontask.Fragments;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import eswar.com.spotsoontask.Adapters.AdapterCardview;
import eswar.com.spotsoontask.Modelclasses.Modelcardviewdetails;
import eswar.com.spotsoontask.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {
    private RecyclerView recyclerview;
    private String[] names;
    private TypedArray profile_pics;
    private String[] time;
    private List<Modelcardviewdetails> modelcardviewdetailsList;
    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_video, container, false);

        names = getResources().getStringArray(R.array.names);
        profile_pics = getResources().obtainTypedArray(R.array.profile_pics);
        time = getResources().getStringArray(R.array.time);
        modelcardviewdetailsList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Modelcardviewdetails modelcardviewdetails = new Modelcardviewdetails(names[i], time[i], profile_pics.getResourceId(i, -1));
            modelcardviewdetailsList.add(modelcardviewdetails);
        }

        recyclerview = (RecyclerView)v.findViewById(R.id.rcv_videos);
        LinearLayoutManager layoutManager = new LinearLayoutManager(container.getContext());
        recyclerview.setLayoutManager(layoutManager);
        AdapterCardview adapter = new AdapterCardview(modelcardviewdetailsList, getActivity());
        recyclerview.setAdapter(adapter);



        return v;
    }

}
