package com.mobile.buttonusertransfer.view;

/**
 * Created by Steven on 11/12/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    UserListAdapter adapter;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the list layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_view_users_list, container, false);
        recView = rootView.findViewById(R.id.rv_recycler_view);
        recView.setHasFixedSize(true);

        // link the adapter to this fragment
        recView.setAdapter(getAdapter());
        getAdapter().notifyDataSetChanged();

        // set layout manager
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recView.setLayoutManager(llm);

        // add dividers between each cell
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recView.getContext(), llm.getOrientation());
        recView.addItemDecoration(dividerItemDecoration);

        return rootView;
    }

    // add items to the list
    public void addItems(List<User> users){

        getAdapter().addItems(users);

        //getAdapter().addItem(item);
        getAdapter().notifyDataSetChanged();
    }

    public UserListAdapter getAdapter(){
        if (adapter == null)
            adapter = new UserListAdapter();
        return adapter;
    }
}