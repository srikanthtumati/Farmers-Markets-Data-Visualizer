package edu.rpi.cs.csci4963.u19.tumats.hw05.farmers_market;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;


public class DatabaseLoader {

    /**
     * Determines whether the boolean value in the csv file is either true or false
     * @param val the parameter passed in from the csv
     * @return true if csv has Y and false otherwise
     */
    public static boolean parseBoolean(String val){
        return val.equals("Y");
    }

    /**
     * Main method to initialize and create tables in database
     * @param args Command line arguments
     * @throws IOException when data files are not found
     */
    public static void main(String[] args) throws IOException {
        Connection con = null;
        try (BufferedReader br = new BufferedReader(new FileReader("Source Code/Export.csv"))) {
            String line;
            int count = 0;
//            String url = "jdbc:mysql://localhost:3306/farms?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC";

            String url = "jdbc:mysql://localhost:3306?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC";
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter SQL root username: ");
                String username = sc.nextLine();
                System.out.print("Enter SQL root password: ");
                String password = sc.nextLine();
                System.out.println("Attempting to connect!");
                con = DriverManager.getConnection(url, username, password);
                System.out.println("Successfully connected!");
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
            String query0 = "CREATE DATABASE if not exists farms;";
            String query1 = "use farms;";
            String query2 = "CREATE TABLE farmData (FMID INT PRIMARY KEY, marketName VARCHAR(100), website VARCHAR(200), facebook VARCHAR(200),\n" +
                    "twitter VARCHAR(100), youtube VARCHAR(100), otherMedia VARCHAR(200), street VARCHAR(100), city VARCHAR(50), county VARCHAR(50),  state VARCHAR(30), zip INT, season1D VARCHAR(100), season1T VARCHAR(200), season2D VARCHAR(200), season2T VARCHAR(200), season3D VARCHAR(200), season3T VARCHAR(200), season4D VARCHAR(200), season4T VARCHAR(200), x DECIMAL(15, 10), y DECIMAL(15, 10), location VARCHAR(100), credit BOOLEAN, WIC BOOLEAN, WICcash BOOLEAN, SFMNP BOOLEAN, SNAP BOOLEAN, Organic BOOLEAN, bakedGoods BOOLEAN, cheese BOOLEAN, crafts BOOLEAN, flowers BOOLEAN, eggs BOOLEAN, seafood BOOLEAN, herbs BOOLEAN, vegetables BOOLEAN, honey BOOLEAN, jams BOOLEAN, maple BOOLEAN, meat BOOLEAN, nursery BOOLEAN, nuts BOOLEAN, plants BOOLEAN, poultry BOOLEAN, prepared BOOLEAN, soap BOOLEAN, trees BOOLEAN, wine BOOLEAN, coffee BOOLEAN, beans BOOLEAN, fruits BOOLEAN, grains BOOLEAN, juices BOOLEAN, mushrooms BOOLEAN, petfood BOOLEAN, tofu BOOLEAN, wildHarvested BOOLEAN, updateTime VARCHAR(25));";
            String query3 = "CREATE TABLE locationData(zip INT PRIMARY KEY, latitude DECIMAL(15, 10), longitude DECIMAL(15, 10), city VARCHAR(30), state VARCHAR(30), county VARCHAR(30));";
            try( PreparedStatement q0 = con.prepareStatement(query0)){
                q0.executeUpdate();
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
            try( PreparedStatement q1 = con.prepareStatement(query1)){
                q1.executeUpdate();
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
            try( PreparedStatement q2 = con.prepareStatement(query2)){
                q2.executeUpdate();
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
            try( PreparedStatement q3 = con.prepareStatement(query3)){
                q3.executeUpdate();
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
            while ((line = br.readLine()) != null) {
                if (count == 0){
                    count += 1;
                    continue;
                }
                String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (tokens[1].charAt(0) == '"')
                    tokens[1] = tokens[1].substring(1, tokens[1].length()-1);
                try
                {
                    String query = "INSERT INTO farmData VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                    try (PreparedStatement stat = con.prepareStatement(query)) {
                        stat.setInt(1, Integer.parseInt(tokens[0]));
                        stat.setString(2, tokens[1]);
                        stat.setString(3, tokens[2]);
                        stat.setString(4, tokens[3]);
                        stat.setString(5, tokens[4]);
                        stat.setString(6, tokens[5]);
                        stat.setString(7, tokens[6]);
                        stat.setString(8, tokens[7]);
                        stat.setString(9, tokens[8]);
                        stat.setString(10, tokens[9]);
                        stat.setString(11, tokens[10]);
                        try {
                            stat.setInt(12, Integer.parseInt(tokens[11]));
                        }
                        catch(NumberFormatException ex){
                            stat.setInt(12, -1);
                        }
                        stat.setString(13, tokens[12]);
                        stat.setString(14, tokens[13]);
                        stat.setString(15, tokens[14]);
                        stat.setString(16, tokens[15]);
                        stat.setString(17, tokens[16]);
                        stat.setString(18, tokens[17]);
                        stat.setString(19, tokens[18]);
                        stat.setString(20, tokens[19]);
                        try {
                            stat.setDouble(21, Double.parseDouble(tokens[20]));
                        }
                        catch(NumberFormatException ex){
                            stat.setDouble(21, -200.0);
                        }
                        try {
                            stat.setDouble(22, Double.parseDouble(tokens[21]));
                        }
                        catch(NumberFormatException ex){
                            stat.setDouble(22, -200.0);
                        }
                        stat.setString(23, tokens[22]);
                        stat.setBoolean(24, parseBoolean(tokens[23]));
                        stat.setBoolean(25, parseBoolean(tokens[24]));
                        stat.setBoolean(26, parseBoolean(tokens[25]));
                        stat.setBoolean(27, parseBoolean(tokens[26]));
                        stat.setBoolean(28, parseBoolean(tokens[27]));
                        stat.setBoolean(29, parseBoolean(tokens[28]));
                        stat.setBoolean(30, parseBoolean(tokens[29]));
                        stat.setBoolean(31, parseBoolean(tokens[30]));
                        stat.setBoolean(32, parseBoolean(tokens[31]));
                        stat.setBoolean(33, parseBoolean(tokens[32]));
                        stat.setBoolean(34, parseBoolean(tokens[33]));
                        stat.setBoolean(35, parseBoolean(tokens[34]));
                        stat.setBoolean(36, parseBoolean(tokens[35]));
                        stat.setBoolean(37, parseBoolean(tokens[36]));
                        stat.setBoolean(38, parseBoolean(tokens[37]));
                        stat.setBoolean(39, parseBoolean(tokens[38]));
                        stat.setBoolean(40, parseBoolean(tokens[39]));
                        stat.setBoolean(41, parseBoolean(tokens[40]));
                        stat.setBoolean(42, parseBoolean(tokens[41]));
                        stat.setBoolean(43, parseBoolean(tokens[42]));
                        stat.setBoolean(44, parseBoolean(tokens[43]));
                        stat.setBoolean(45, parseBoolean(tokens[44]));
                        stat.setBoolean(46, parseBoolean(tokens[45]));
                        stat.setBoolean(47, parseBoolean(tokens[46]));
                        stat.setBoolean(48, parseBoolean(tokens[47]));
                        stat.setBoolean(49, parseBoolean(tokens[48]));
                        stat.setBoolean(50, parseBoolean(tokens[49]));
                        stat.setBoolean(51, parseBoolean(tokens[50]));
                        stat.setBoolean(52, parseBoolean(tokens[51]));
                        stat.setBoolean(53, parseBoolean(tokens[52]));
                        stat.setBoolean(54, parseBoolean(tokens[53]));
                        stat.setBoolean(55, parseBoolean(tokens[54]));
                        stat.setBoolean(56, parseBoolean(tokens[55]));
                        stat.setBoolean(57, parseBoolean(tokens[56]));
                        stat.setBoolean(58, parseBoolean(tokens[57]));
                        stat.setString(59, tokens[58]);


                        int recordUpdate = stat.executeUpdate();
                        System.out.println(recordUpdate + " rows successfully added into database!");
                    }
                }
                catch (SQLException ex) {
//                    for (Throwable t : ex)
//                        System.out.println(t.getMessage());
//                    System.out.println("Opening connection unsuccesful!");
                }
            }

//            System.out.println("done!");
//            Scanner sc = new Scanner(System.in);
//            String userResponse = sc.nextLine();
//            String query = "SELECT * from farmData where state=?;";
//            try (PreparedStatement stat = con.prepareStatement(query)) {
//                stat.setString(1, userResponse);
//                ResultSet rs = stat.executeQuery();
//                while (rs.next()){
//                    System.out.println(rs.getString("marketName"));
//                }
//            }
//            catch(SQLException ex){
//                ex.printStackTrace();
//            }

        }
        try (BufferedReader br = new BufferedReader(new FileReader("Source Code/zip_codes_states.csv"))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                if (count == 0){
                    count += 1;
                    continue;
                }
                line = line.replace("\"", "");
                String[] tokens = line.split(",");
                try
                {
                    String query = "INSERT INTO locationData VALUES (?,?,?,?,?,?);";
                    try (PreparedStatement stat = con.prepareStatement(query)) {
                        stat.setInt(1, Integer.parseInt(tokens[0]));
                        try {
                            stat.setDouble(2, Double.parseDouble(tokens[1]));
                        }
                        catch (NumberFormatException ex){
                            continue;
                        }
                        try {
                            stat.setDouble(3, Double.parseDouble(tokens[2]));
                        }
                        catch( NumberFormatException ex){
                            continue;
                        }
                        stat.setString(4, tokens[3]);
                        stat.setString(5, tokens[4]);
                        try {
                            stat.setString(6, tokens[5]);
                        }
                        catch(ArrayIndexOutOfBoundsException ex){
                            System.out.println(tokens[0]);
                            break;
                        }
                        int recordUpdate = stat.executeUpdate();
                        System.out.println(recordUpdate + " rows successfully added into database!");
                    }
                }
                catch (SQLException ex) {
                    for (Throwable t : ex)
                        System.out.println(t.getMessage());
                    System.out.println("Opening connection unsuccesful!");
                }
            }
            System.out.println("done!");
        }
        if (con != null) {
            try {
                con.close();
            }
            catch (SQLException ex) {
                for (Throwable t : ex)
                    System.out.println(t.getMessage());
                System.out.println("Closing connection unsuccesful!");
            }
        }

    }
}
