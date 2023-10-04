package com.data;

public class playListSongs {
    int playListId;
    int songId;

    public int getPlayListId() {
        return playListId;
    }

    public void setPlayListId(int playListId) {
        this.playListId = playListId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public playListSongs(int playListId, int songId) {
        this.playListId = playListId;
        this.songId = songId;
    }

}
