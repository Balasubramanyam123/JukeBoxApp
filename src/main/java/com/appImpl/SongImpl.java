package com.appImpl;

import com.data.Song;
import com.excepetion.SongNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class SongImpl {
    public void displyAll(List<Song> songList) throws SongNotFoundException {

            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%4s %15s %15s %15s %15s %15s %20s","SongId", "SONGTITLE", "DURATION", "ARTISTNAME ", "ALBUMNAME", "GENERE", "SONGPATH");
            System.out.println();
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            for (Song song: songList) {
                System.out.printf("%4s %15s %15s %15s %15s %15s %30s",song.getSongId(), song.getSongTitle(), song.getDuration(), song.getArtist(), song.getAlbum(), song.getGenres(), song.getSongPath());
                System.out.println("");
            }

            if (songList.isEmpty()) {
                throw new SongNotFoundException("Song not found");
            }

    }

    public List<Song> searchByName(List<Song> songList, String songName) throws SongNotFoundException {

            List<Song> searchedList = new ArrayList<>();
            for (Song song:songList) {
                if(song.getSongTitle().toLowerCase().contains(songName.toLowerCase())){
                    searchedList.add(song);
                }
            }
            searchedList.sort((s1,s2) -> (s1.getSongTitle().compareToIgnoreCase(s2.getSongTitle())));
            displyAll(searchedList);
            if (songList.isEmpty()) {
                throw new SongNotFoundException("Song not found");
            }
            return searchedList;

    }

    public List<Song> searchByArtist(List<Song> songList, String artistName) throws SongNotFoundException {

            List<Song> searchedList = new ArrayList<>();
            for (Song song:songList) {
                if(song.getArtist().toLowerCase().contains(artistName.toLowerCase())){
                    searchedList.add(song);
                }
            }
            searchedList.sort((s1,s2) -> (s1.getSongTitle().compareToIgnoreCase(s2.getSongTitle())));
            displyAll(searchedList);
            if (songList.isEmpty()) {
                throw new SongNotFoundException("Song not found");
            }
            return searchedList;

    }
    public List<Song> searchByAlbum(List<Song> songList, String albumName) throws SongNotFoundException {
        List<Song> searchedList = new ArrayList<>();

            for (Song song:songList) {
                if(song.getAlbum().toLowerCase().contains(albumName.toLowerCase())){
                    searchedList.add(song);
                }
            }
            searchedList.sort((s1,s2) -> (s1.getSongTitle().compareToIgnoreCase(s2.getSongTitle())));
            displyAll(searchedList);
            if (songList.isEmpty()) {
                throw new SongNotFoundException("Song not found");
            }

        return searchedList;
    }

    public List<Song> searchByGenre(List<Song> songList, String genreName) throws SongNotFoundException {
            List<Song> searchedList = new ArrayList<>();
            for (Song song:songList) {
                if(song.getGenres().toLowerCase().contains(genreName.toLowerCase())){
                    searchedList.add(song);
                }
            }
            searchedList.sort((s1,s2) -> (s1.getSongTitle().compareToIgnoreCase(s2.getSongTitle())));
            displyAll(searchedList);
            if (songList.isEmpty()) {
                throw new SongNotFoundException("Song not found");
            }
            return searchedList;

    }
}
