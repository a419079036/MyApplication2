package com.example.administrator.day07_03fragment2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment
{

    String title;

    public BlankFragment()
    {
        // Required empty public constructor
    }
    public BlankFragment(String title)
    {
        this.title=title;
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_blank,container,false);
        // Inflate the layout for this fragment
        TextView tv= (TextView) view.findViewById(R.id.tv_frag);
        tv.setText(title);
        return view;
    }

}
