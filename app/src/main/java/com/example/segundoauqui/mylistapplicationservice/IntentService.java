package com.example.segundoauqui.mylistapplicationservice;

import android.content.Intent;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by segundoauqui on 8/17/17.
 */

public class IntentService extends android.app.IntentService {



    public int imgs[]={
            R.drawable.adcg,
            R.drawable.donte,
            R.drawable.mfb,
            R.drawable.spl,
            R.drawable.sts,
            R.drawable.spy,
            R.drawable.nuwwi,
            R.drawable.nwwi,
            R.drawable.tendo
    };

    public IntentService() {
        super("ListObject");
    }
    ArrayList<ListObject> randomList = new ArrayList<>();
    SecureRandom randomS = new SecureRandom();
    @Override
    protected void onHandleIntent(Intent intent) {
        switch(intent.getAction()) {
            case "createObject":
                String number1 = new BigInteger(130, randomS).toString(32);
                double random2 = ((double)(new Random()).nextInt(100000 - 1))/100;
                int random3 = (new Random()).nextInt(1000 - 1);
                int random4 = imgs[(new Random()).nextInt(9)];
                randomList.add(new ListObject(number1, random2, random3, random4));
                break;
        }
    }

    @Override
    public void onCreate() {

        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Intent intent = new Intent();
        intent.setAction("list");
        intent.putExtra("randomList",randomList);
        sendBroadcast(intent);
        super.onDestroy();
    }
}
