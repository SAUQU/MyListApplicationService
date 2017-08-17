package com.example.segundoauqui.mylistapplicationservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by segundoauqui on 8/17/17.
 */

public class DynamicReciever extends BroadcastReceiver {

    RecyclerView rvRandList;


    public DynamicReciever(RecyclerView rvRandList) {
        this.rvRandList = rvRandList;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction()) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Toast.makeText(context, "Broadcast:  Airplane mode has changed ", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "Broadcast:  Power connected", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_TIMEZONE_CHANGED:
                Toast.makeText(context, "Broadcast:  Timezone has changed ", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_WALLPAPER_CHANGED:
                Toast.makeText(context, "Broadcast:   Wallpaper has changed ", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context, "Broadcast:   Power disconnected ", Toast.LENGTH_SHORT).show();
                break;
            case "list":
                ArrayList<ListObject> randomList = intent.getParcelableArrayListExtra("randomList");
                ListAdapter randomsListAdapter = new ListAdapter(randomList);
                rvRandList.setAdapter(randomsListAdapter);
                randomsListAdapter.notifyDataSetChanged();

                break;

        }

    }
}