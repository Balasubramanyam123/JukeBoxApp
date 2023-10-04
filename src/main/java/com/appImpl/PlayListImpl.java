package com.appImpl;

import com.connection.Dbconnection;

import java.sql.*;

public class PlayListImpl {

    public void createPlaylist(String playListName) {
        try{
            Connection connection = Dbconnection.getConnection();
            String sql = "insert into playlist(playlistname) values(?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,playListName);
            int row =preparedStatement.executeUpdate();
            if(row>0)
            {
                System.out.println("Playlist Created Successfully :)");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSongs(int playListId, int songId){
        try {
            Connection connection = Dbconnection.getConnection();
            String sql = "insert existinglists (songId, playListId) values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,songId);
            preparedStatement.setInt(2,playListId);
            int row = preparedStatement.executeUpdate();
            if(row>0)
            {
                System.out.println("Song inserted Successfully :)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertAlbum(int playlistId, String albumName)
    {
        try
        {
            Connection connection = Dbconnection.getConnection();
            String sql = "select songid from songs where album=?";
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1,albumName);
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next())
            {
                int songId=resultSet.getInt(1);
                insertSongs(playlistId,songId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void displayPlayLists() {
        try {
            Connection connection = Dbconnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from playlist");
            System.out.printf("%5s %10s\n", "PlaylistId", "PlaylistName");
            System.out.println("..................................................................................\n");
            while (resultSet.next()) {
                System.out.printf("%5s %10s\n", resultSet.getInt(1), resultSet.getString(2));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayPlayListContent(int playListId){
        try {
            System.out.println("Available Songs in the playlist:");
            System.out.printf("%-10s %10s\n","SongId", "SongName");
            System.out.println("........................................");
            Connection connection = Dbconnection.getConnection();
            Statement statement = connection.createStatement();
            Statement statement1 = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select songId from existinglists where playlistid=" + playListId);
            while (resultSet.next()) {
                ResultSet resultSet1 = statement1.executeQuery("select songId,songtitle from songs where songid=" + resultSet.getInt(1));
                while (resultSet1.next()) {
                    System.out.printf("%-10s %10s\n", resultSet1.getInt(1),resultSet1.getString(2));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
