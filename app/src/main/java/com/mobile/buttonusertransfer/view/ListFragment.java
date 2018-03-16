package com.mobile.buttonusertransfer.view;

/**
 * Created by Steven on 11/12/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobile.buttonusertransfer.R;
import com.mobile.buttonusertransfer.data.model.User;

import java.util.List;

;

public class ListFragment extends Fragment {

    private final String TAG = getClass().getName();

    private RecyclerView recView;

    VidListAdapter adapter;

    public ListFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = getAdapter();

    }

    @Override
    public void onResume(){
        super.onResume();

    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

  /*          // Inflate the list layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_vid_list, container, false);
        recView = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);

        recView.setHasFixedSize(true);

            // using an ArrayList for better performance since I will be adding often

        //adapter = new VidListAdapter();
        recView.setAdapter(getAdapter());

        getAdapter().notifyDataSetChanged();

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recView.setLayoutManager(llm);

            // infinite scrolling here
        setInfiniteScrolling(llm);

        return rootView;*/
        return null;
    }


        // add items to adapter here, then call adapter.notifyItemRangeInserted
    public void addItems(List<User> videos){

        int oldSize = getAdapter().getItemCount();
        int itemCount = videos.size();

        Log.d(TAG, "Before add, data size: " + oldSize);

        for (User vid : videos){
            //getAdapter().addItem(new VideoItem(vid));
        }

        Log.d(TAG, "AFTER add, data size: " + getAdapter().getItemCount());

        //getAdapter().addItem(item);
        //getAdapter().notifyDataSetChanged();

        getAdapter().notifyItemRangeInserted(oldSize, itemCount);
    }

    public VidListAdapter getAdapter(){
        if (adapter == null)
            adapter = new VidListAdapter();
        return adapter;
    }
}