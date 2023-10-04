package com.appImpl;

import com.connection.Dbconnection;
import com.dao.SongDAO;
import com.data.AudioData;
import com.data.Song;
import com.excepetion.SongNotFoundException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JukeBoxOperation {
    public void Operations() throws SQLException, ClassNotFoundException, SongNotFoundException {
        SongDAO songDAO = new SongDAO();
        SongImpl songImpl = new SongImpl();
        PlayListImpl playList = new PlayListImpl();
        PlayMusic playMusic = new PlayMusic();
        Scanner scanner = new Scanner(System.in);
        Connection connection = Dbconnection.getConnection();

        int choice,choice1,choice2,choice3;

        List<Song> songList;
        songList = songDAO.readfromdatabase();
        //songImpl.displyAll(songList);



        do{
            System.out.println("------------------WELCOME------------------");
            System.out.println("----------Main Menu-------------------");
            System.out.println("Select an opertation\n 1.Song Details \n 2.PlayList Details \n 3.Play Song \n 4.Exit");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    do{
                        System.out.println("Select an opertation\n 1.SearchByNames \n 2.SearchByArtist \n 3.SearchByAlbum \n 4.SearchByGenre \n 5.DisplayAllSongs \n 6.Exit");
                        choice1 = scanner.nextInt();
                        switch (choice1){
                            case 1:
                                System.out.println("Enter name of song");
                                scanner.nextLine();
                                String songName = scanner.nextLine();
                                songImpl.searchByName(songList, songName);
                                break;
                            case 2 :
                                System.out.println("Enter artist Name");
                                scanner.nextLine();
                                String artistName = scanner.nextLine();
                                songImpl.searchByArtist(songList, artistName);
                                break;
                            case 3 :
                                System.out.println("Enter album Name");
                                scanner.nextLine();
                                String albumName = scanner.nextLine();
                                songImpl.searchByAlbum(songList, albumName);
                                break;
                            case 4:
                                System.out.println("Enter genre Name");
                                scanner.nextLine();
                                String genreName = scanner.nextLine();
                                songImpl.searchByGenre(songList, genreName);
                                break;
                            case 5:
                                songImpl.displyAll(songList);
                                break;
                            case 6:
                                break;
                        }
                    }while (choice1 < 6);
                    break;
                case 2:
                    do{
                        System.out.println("Select an opertation\n 1.CreatePlayList  \n 2.InsertSong \n 3.InsertAlbum \n 4.DisplayAllPLayLists \n 5.DisplayPlayListContent \n 6.Exit");
                        choice2 = scanner.nextInt();
                        switch (choice2) {
                            case 1:
                                System.out.println("Create playList Name");
                                scanner.nextLine();
                                String createPlaylist = scanner.nextLine();
                                playList.createPlaylist(createPlaylist);
                                break;
                            case 2:
                                playList.displayPlayLists();
                                System.out.println("Enter the playListId");
                                int playListId1 = scanner.nextInt();
                                songImpl.displyAll(songList);
                                System.out.println("Enter the songId");
                                int songId = scanner.nextInt();
                                playList.insertSongs(playListId1,songId);
                                break;
                            case 3:
                                playList.displayPlayLists();
                                System.out.println("Enter the playListId");
                                int playListId2 = scanner.nextInt();
                                songImpl.displyAll(songList);
                                System.out.println("Enter the songAlbum");
                                String album = scanner.next();
                                playList.insertAlbum(playListId2,album);
                                break;
                            case 4:
                                playList.displayPlayLists();
                                break;
                            case 5:
                                playList.displayPlayLists();
                                System.out.println("Enter the playListId to show songs");
                                int playListId3 = scanner.nextInt();
                                playList.displayPlayListContent(playListId3);
                                break;
                            case 6:
                                break;
                        }
                    }while(choice2 < 6);
                    break;
                case 3:
                    do{
                        System.out.println("Choose an option to Play Music:- \n 1.Playlists \n 2.Songs \n 3.Play selected Song \n 4.Exit");
                        choice3=scanner.nextInt();
                        switch (choice3) {
                            case 1:
                                playList.displayPlayLists();
                                System.out.println("Enter playlist id to play music:");
                                int playListId = scanner.nextInt();
                                int songId;
                                List<AudioData> audioList = new ArrayList<>(0);
                                Statement statement = connection.createStatement();
                                Statement statement1 = connection.createStatement();
                                ResultSet resultSet = statement.executeQuery("select songid from existinglists where playlistid=" + playListId);
                                while (resultSet.next()) {
                                    songId = resultSet.getInt(1);
                                    ResultSet resultSet1 = statement1.executeQuery("select songtitle,songpath from songs where songid=" + songId);
                                    while (resultSet1.next()) {
                                        audioList.add(new AudioData(resultSet1.getString(1), resultSet1.getString(2)));
                                    }
                                }
                                playMusic.playerOperation(audioList);
                                break;

                            case 2:
                                songImpl.displyAll(songList);
                                List<AudioData> songAudioList = new ArrayList<>();
                                Statement statement2 = connection.createStatement();
                                ResultSet resultSet2 = statement2.executeQuery("select songtitle,songpath from songs");
                                while (resultSet2.next()) {
                                    songAudioList.add(new AudioData(resultSet2.getString(1), resultSet2.getString(2)));
                                }
                                playMusic.playerOperation(songAudioList);
                                break;
                            case 3:
                                songImpl.displyAll(songList);
                                System.out.println("Enter the songId to play music:");
                                int songId1 = scanner.nextInt();
                                List<AudioData> song = new ArrayList<>();
                                Statement statement3 = connection.createStatement();
                                ResultSet resultSet3 = statement3.executeQuery("select songtitle,songpath from songs where songid=" + songId1);
                                while (resultSet3.next()) {
                                    song.add(new AudioData(resultSet3.getString(1),resultSet3.getString(2)));
                                }
                                playMusic.playerOperation(song);
                                break;
                            case 4:
                                break;
                        }
                    }while(choice3 < 4);
                    break;
                case 4:
                    break;
            }

        }while(choice < 4);
    }
}
