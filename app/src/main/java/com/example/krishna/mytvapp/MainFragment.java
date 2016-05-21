package com.example.krishna.mytvapp;

import android.os.Bundle;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewClickedListener;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;
import android.util.Log;

import com.example.krishna.mytvapp.model.Search;
import com.example.krishna.mytvapp.presenter.GridTextItemPresenter;
import com.example.krishna.mytvapp.presenter.MovieCardPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navkrishna on May, 21 2016
 */
public class MainFragment extends BrowseFragment {

    private static final String TAG = "MainFragment";
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

        HeaderItem gridItemImagePresenterHeader = new HeaderItem(1, "Image items");

        ArrayObjectAdapter gridImageRowAdapter = new ArrayObjectAdapter(new MovieCardPresenter());
        List<Search> searchList = getSearchMockData();
        for (int i = 0; i < urls.length; i++) {
            gridImageRowAdapter.add(searchList.get(i));
        }

        mRowsAdapter.add(new ListRow(gridItemImagePresenterHeader, gridImageRowAdapter));

        setOnItemViewSelectedListener(onItemViewSelectedListener);
        setOnItemViewClickedListener(onItemViewClickedListener);

        setAdapter(mRowsAdapter);
    }

    String[] urls = {
            "http://ia.media-imdb.com/images/M/MV5BMTI4MDAwMDY3N15BMl5BanBnXkFtZTcwODIwMzMzMQ@@._V1._CR46,1,342,473_SY132_CR3,0,89,132_AL_.jpg_V1_SX300.jpg",
            "http://ia.media-imdb.com/images/M/MV5BODE1MDczNTUxOV5BMl5BanBnXkFtZTcwMTA0NDQyNA@@._V1_SX300.jpg",
            "http://ia.media-imdb.com/images/M/MV5BMTk5NzM1ODgyN15BMl5BanBnXkFtZTcwMzA5MjAzMw@@._V1_SX300.jpg",
            "http://ia.media-imdb.com/images/M/MV5BODE1MTM1MzA2NF5BMl5BanBnXkFtZTcwODQ5MTA2Mg@@._V1_SX300.jpg"

    };

    private List<Search> getSearchMockData() {
        List<Search> searchList = new ArrayList<>();
        for (int i = 0; i < urls.length; i++) {
            Search search = new Search();
            search.setPoster(urls[i]);
            search.setTitle("title: " + i);
            search.setImdbID("imdb id: " + i);
            search.setYear("2015");
            search.setType("movie");
            searchList.add(search);
        }
        return searchList;
    }

    OnItemViewSelectedListener onItemViewSelectedListener = new OnItemViewSelectedListener() {
        @Override
        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            Log.i(TAG, "onItemSelected: " + getSelectedPosition());
        }
    };

    OnItemViewClickedListener onItemViewClickedListener = new OnItemViewClickedListener() {
        @Override
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            Log.i(TAG, "onItemClicked: ");
        }
    };

}
