package com.dao;

import com.connection.Dbconnection;
import com.data.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongDAO {
        public List<Song> readfromdatabase() throws SQLException, ClassNotFoundException {
            List<Song> songlist = new ArrayList<>();
            Connection connection = Dbconnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from songs");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int songId = resultSet.getInt(1);
                String songTitle = resultSet.getString(2);
                String duration = resultSet.getString(3);
                String artist = resultSet.getString(4);
                String album = resultSet.getString(5);
                String genres = resultSet.getString(6);
                String songPath = resultSet.getString(7);
                Song song = new Song(songId, songTitle, duration, artist, album, genres, songPath);
                songlist.add(song);
            }
            return songlist;
        }
}
