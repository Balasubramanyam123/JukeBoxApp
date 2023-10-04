package com.dao;

import com.appImpl.SongImpl;
import com.data.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SongDAOTest {
    SongDAO songDAO;
    List<Song> songList;

    @BeforeEach
    void setUp() throws SQLException, ClassNotFoundException {
        songDAO = new SongDAO();
        songList = songDAO.readfromdatabase();


    }

    @AfterEach
    void tearDown() {
        songDAO = null;
        songList = null;
    }

    @Test
    void readfromdatabase() {
        int expected = 5;
        int actual = songList.size();
        assertEquals(expected, actual);

    }
}