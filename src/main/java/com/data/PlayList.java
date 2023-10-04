package com.data;

import java.util.List;

public class PlayList {
    String playListName;
    int playListId;

    public PlayList(int playListId, String playListName) {
        this.playListName = playListName;
        this.playListId = playListId;
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }

    public int getPlayListId() {
        return playListId;
    }

    public void setPlayListId(int playListId) {
        this.playListId = playListId;
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "playListName='" + playListName + '\'' +
                ", playListId=" + playListId +
                '}';
    }
}
