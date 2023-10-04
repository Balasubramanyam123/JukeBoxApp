package com.appImpl;

import com.dao.SongDAO;
import com.data.Song;
import com.excepetion.SongNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SongImplTest {
    SongImpl songimpl;
    List<Song> songList;
    SongDAO songDAO;

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        songimpl = new SongImpl();
        songDAO = new SongDAO();
        songList = songDAO.readfromdatabase();
    }

    @AfterEach
    void tearDown() {
        songimpl = null;
        songList = null;
        songDAO = null;
    }

    @Test
    void searchByName() throws SongNotFoundException {
        int expected = 1;
        List<Song> actual = songimpl.searchByName(songList,"sita");
        assertEquals(expected, actual.size() );
    }

    @Test
    void searchByArtist() throws SongNotFoundException {
        int expected = 1;
        List<Song> actual = songimpl.searchByArtist(songList,"sidSriRam");
        assertEquals(expected,actual.size());
    }

    @Test
    void searchByAlbum() throws SongNotFoundException {
        int expected = 2;
        List<Song> actual = songimpl.searchByAlbum(songList,"pushpa");
        assertEquals(expected,actual.size());

    }

    @Test
    void searchByGenre() throws SongNotFoundException {
        int expected = 2;
        List<Song> actual = songimpl.searchByGenre(songList,"love");
        assertEquals(expected,actual.size());
    }
}