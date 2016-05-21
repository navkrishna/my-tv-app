package com.example.krishna.mytvapp;

import android.os.Bundle;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;

import com.example.krishna.mytvapp.presenter.GridTextItemPresenter;

/**
 * Created by Navkrishna on May, 21 2016
 */
public class MainFragment extends BrowseFragment {

    ArrayObjectAdapter mRowsAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadMultipleRows();
    }

    private void loadMultipleRows() {
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        HeaderItem gridItemTextPresenterHeader = new HeaderItem(0, "Grid Item text Presenter");

        ArrayObjectAdapter gridTextRowAdapter = new ArrayObjectAdapter(new GridTextItemPresenter());
        gridTextRowAdapter.add("Item 1");
        gridTextRowAdapter.add("Item 2");
        gridTextRowAdapter.add("Item 3");
        gridTextRowAdapter.add("Item 4");
        gridTextRowAdapter.add("Item 5");

        mRowsAdapter.add(new ListRow(gridItemTextPresenterHeader, gridTextRowAdapter));
        setAdapter(mRowsAdapter);
    }

}
