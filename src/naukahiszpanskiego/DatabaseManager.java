/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package naukahiszpanskiego;

/**
 *
 * @author Zbyszek
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlserver://LAPTOP-UDL7HP27;databaseName=projekt";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "student";
    private Connection connection;

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }


    // Dodaj inne metody, takie jak pobieranie słów z bazy danych, porównywanie tłumaczeń itp.
     public SpanishWord getRandomSpanishWord() throws SQLException {
        String query = "SELECT TOP 1 word FROM spanish_words ORDER BY NEWID()";
        
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                String word = resultSet.getString("word");
                return new SpanishWord(word);
            }
        }
        
        return null;
    }
    
    public boolean checkTranslation(SpanishWord spanishWord, String translation) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM polish_words WHERE word = ? AND translation = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, spanishWord.getWord());
            statement.setString(2, translation);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    return count > 0;
                }
            }
        }
        
        return false;
    }
}
