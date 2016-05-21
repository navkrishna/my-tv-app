package com.example.krishna.mytvapp.presenter;

import android.support.v17.leanback.widget.AbstractDetailsDescriptionPresenter;

import com.example.krishna.mytvapp.model.Search;

/**
 * Created by Navkrishna on May, 21 2016
 */
public class DescriptionPresenter extends AbstractDetailsDescriptionPresenter {
    @Override
    protected void onBindDescription(ViewHolder vh, Object item) {
        Search movie = (Search) item;
        vh.getTitle().setText(movie.getTitle());
    }
}
