package com.zlargon.loader1lab;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;

public class MyLoaderCallbacks implements LoaderCallbacks<Cursor> {

    public static final String TAG = "CONTENT_LOADER";
    private LoaderFragment loaderFragment;
//    private Context mContext;

    static final String[] CONTATCTS_SUMMARY_PROJECTION = new String[] {
        Contacts._ID,
        Contacts.DISPLAY_NAME,
        Contacts.CONTACT_STATUS
    };

//    public MyLoaderCallbacks(Context context) {
//        super();
//        this.mContext = context;
//
//    }

    public MyLoaderCallbacks(LoaderFragment loaderFragment) {
        super();
        this.loaderFragment = loaderFragment;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Log.e(TAG, "Start Loading ...");

        Uri baseUri = Contacts.CONTENT_URI;
        String select = String.format(
            "((%s NOTNULL) AND (%s = 1) AND (%s != ''))",
            Contacts.DISPLAY_NAME,
            Contacts.HAS_PHONE_NUMBER,
            Contacts.DISPLAY_NAME
        );

        return new CursorLoader(
            // mContext,
            loaderFragment.getActivity(),
            baseUri,
            CONTATCTS_SUMMARY_PROJECTION,
            select,
            null,
            Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC"
        );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cur) {
        Log.e(TAG, "Finish Loading ...");

        loaderFragment.getCursorAdapter().changeCursor(cur);

        if (cur.moveToFirst()) {
            String name;
            String id;
            int nameColumn = cur.getColumnIndex(Contacts.DISPLAY_NAME);
            int idColumn = cur.getColumnIndex(Contacts._ID);

            do {
                name = cur.getString(nameColumn);
                id = cur.getString(idColumn);

                Log.d(TAG, "name = " + name);
                Log.d(TAG, "id = " + id);
            } while (cur.moveToNext());
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        Log.e(TAG, "Load Reset ...");
    }
}
