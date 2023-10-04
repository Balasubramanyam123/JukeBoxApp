package com.appImpl;


import com.excepetion.SongNotFoundException;

import java.sql.SQLException;


public class JukeBoxOperationImpl {
    public static void main(String[] args)  {
        JukeBoxOperation jukeBoxOperation = new JukeBoxOperation();
        try {
            jukeBoxOperation.Operations();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SongNotFoundException e) {
            e.printStackTrace();
        }
    }
}
