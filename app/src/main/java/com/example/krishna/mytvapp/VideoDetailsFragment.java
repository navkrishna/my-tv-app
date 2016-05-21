package com.example.krishna.mytvapp;

import android.os.Bundle;
import android.support.v17.leanback.app.DetailsFragment;
import android.support.v17.leanback.widget.Action;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.ClassPresenterSelector;
import android.support.v17.leanback.widget.DetailsOverviewRow;
import android.support.v17.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import android.support.v17.leanback.widget.OnActionClickedListener;
import android.support.v17.leanback.widget.SparseArrayObjectAdapter;

import com.example.krishna.mytvapp.model.Search;
import com.example.krishna.mytvapp.presenter.DescriptionPresenter;

/**
 * Created by Navkrishna on May, 21 2016
 */
public class VideoDetailsFragment extends DetailsFragment {

    ClassPresenterSelector mClassPresenterSelector;
    FullWidthDetailsOverviewRowPresenter fullWidthDetailsOverviewRowPresenter;
    ArrayObjectAdapter mAdapter;
    Search movie;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movie = getActivity().getIntent().getParcelableExtra("video");

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mClassPresenterSelector = new ClassPresenterSelector();
        DescriptionPresenter descriptionPresenter = new DescriptionPresenter();
        fullWidthDetailsOverviewRowPresenter = new FullWidthDetailsOverviewRowPresenter(descriptionPresenter);
        mClassPresenterSelector.addClassPresenter(DetailsOverviewRow.class, fullWidthDetailsOverviewRowPresenter);

        fullWidthDetailsOverviewRowPresenter.setOnActionClickedListener(new OnActionClickedListener() {
            @Override
            public void onActionClicked(Action action) {
            }
        });

        DetailsOverviewRow actionRow = new DetailsOverviewRow(movie);
        SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter();
        sparseArrayObjectAdapter.set(0, new Action(0, "Action 0"));
        sparseArrayObjectAdapter.set(1, new Action(1, "Action 1"));
        sparseArrayObjectAdapter.set(2, new Action(2, "Action 2"));
        sparseArrayObjectAdapter.set(3, new Action(3, "Action 3"));

        actionRow.setActionsAdapter(sparseArrayObjectAdapter);

        mAdapter = new ArrayObjectAdapter(mClassPresenterSelector);
        mAdapter.add(actionRow);
        setAdapter(mAdapter);
    }
}
