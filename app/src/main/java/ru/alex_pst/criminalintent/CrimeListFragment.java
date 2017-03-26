package ru.alex_pst.criminalintent;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static ru.alex_pst.criminalintent.R.layout.fragment_crime_list;

/**
 * Created by Alex_ on 12.03.2017.
 */

public class CrimeListFragment extends ListFragment {

    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crime_title);
        mCrimes = CrimeLab.get(getActivity()).getCrimes();
        CrimeAdapter adapter = new CrimeAdapter(mCrimes);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id){
        Crime crime = ((CrimeAdapter)getListAdapter()).getItem(position);
        //запускаем CrimeActivity
        Intent intent = new Intent(getActivity(), CrimeActivity.class);
        intent.putExtra(CrimeFragment.EXTRA_CRIME_ID, crime.getId());
        startActivityForResult(intent, 0);

    }




    private class CrimeAdapter extends ArrayAdapter<Crime>{
        public CrimeAdapter(ArrayList<Crime> crimes){
            super(getActivity(), android.R.layout.simple_list_item_1, crimes);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            if(null == convertView){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_crime, null);
            }
            Crime crime = getItem(position);

            TextView titleTextView = (TextView) convertView.findViewById(R.id.list_item__crime_title_text_view);
            titleTextView.setText(crime.getTitle());

            TextView dateTextView = (TextView) convertView.findViewById(R.id.list_crime_date_text_view);
            dateTextView.setText((CharSequence) crime.getDate());

            CheckBox solvedCheckBox = (CheckBox) convertView.findViewById((R.id.list_item_crime_solved_check_box));
            solvedCheckBox.setChecked(crime.isSolved());

            return convertView;}
    }


}