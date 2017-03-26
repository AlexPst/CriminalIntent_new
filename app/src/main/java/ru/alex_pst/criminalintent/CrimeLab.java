package ru.alex_pst.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Alex_ on 12.03.2017.
 */

public class CrimeLab {


    private ArrayList<Crime> mCrimes;

    private static CrimeLab sCrimeLab;
    private Context mAppContext;




    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);
            mCrimes.add(crime);
        }

    }
    public static CrimeLab get(Context crime) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(crime.getApplicationContext());
        }
        return sCrimeLab;
    }

    public Crime getCrimes(UUID id){
        for (Crime crime : mCrimes){
            if( crime.getId().equals(id))
                return crime;
        }
        return null;
    }



        public ArrayList<Crime> getCrimes(){
        return mCrimes;
        }
    }

    
