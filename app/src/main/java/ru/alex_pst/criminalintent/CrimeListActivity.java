package ru.alex_pst.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Alex_ on 12.03.2017.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new CrimeListFragment();
    }
}
