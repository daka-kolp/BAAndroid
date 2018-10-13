package com.brainacad.apptask14;

import android.net.Uri;

public class ItemImage {

    private int id;
    private Uri tUri;
    private Uri fullUri;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Uri gettUri() {
        return tUri;
    }

    public void settUri(Uri tUri) {
        this.tUri = tUri;
    }

    public Uri getFullUri() {
        return fullUri;
    }

    public void setFullUri(Uri fullUri) {
        this.fullUri = fullUri;
    }
}
