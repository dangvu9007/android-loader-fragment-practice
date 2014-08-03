package com.zlargon.loader1lab;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MyLoaderCallbacks myLoaderCallbacks = new MyLoaderCallbacks(this);
//
//        getLoaderManager().initLoader(0, null, myLoaderCallbacks);
//        Log.d(MyLoaderCallbacks.TAG, "do something ...");
//
//        for (int i = 0; i < 100; i++) {
//            Log.w(MyLoaderCallbacks.TAG, "Main Thread " + i);
//        }
    }
}
