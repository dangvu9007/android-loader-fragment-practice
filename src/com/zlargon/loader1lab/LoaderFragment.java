package com.zlargon.loader1lab;

import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.ListFragment;
import android.widget.SimpleCursorAdapter;

public class LoaderFragment extends ListFragment {

    // mCursorAdapter Getter/Setter
    private SimpleCursorAdapter cursorAdapter;

    public SimpleCursorAdapter getCursorAdapter() {
        return cursorAdapter;
    }

    public void setCursorAdapter(SimpleCursorAdapter cursorAdapter) {
        this.cursorAdapter = cursorAdapter;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.cursorAdapter = new SimpleCursorAdapter(
            getActivity(),
            android.R.layout.simple_list_item_2,
            null,
            new String[] {
                Contacts.DISPLAY_NAME,
                Contacts._ID
            },
            new int[] {
                android.R.id.text1,
                android.R.id.text2
            }
          );

        setListAdapter(this.cursorAdapter);

        MyLoaderCallbacks myLoaderCallbacks = new MyLoaderCallbacks(this);
        getLoaderManager().initLoader(0, null, myLoaderCallbacks);
    }
}
