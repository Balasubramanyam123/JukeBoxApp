package com.data;

public class Song {
    private int songId;
    private String songTitle;
    private String duration;
    private String artist;
    private String album;
    private String genres;
    private String songPath;

    public Song(int songId,String songTitle, String duration, String artist, String album, String genres, String songPath) {
        this.songId = songId;
        this.songTitle = songTitle;
        this.duration = duration;
        this.artist = artist;
        this.album = album;
        this.genres = genres;
        this.songPath = songPath;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    @Override
    public String toString() {
        return "Song{" +
                "SongTitle='" + songTitle + '\'' +
                ", duration='" + duration + '\'' +
                ", artist=" + artist +
                ", album=" + album +
                ", genres=" + genres +
                ", songPath='" + songPath + '\'' +
                '}';
    }
}
