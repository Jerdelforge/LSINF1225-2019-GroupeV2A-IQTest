package be.llamy.iqwhizz.Database.Table;

import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "USERS", primaryKeys = {"username"})
public class User {

    public User(){}

    public User(String username, String hashedpassword){
        setUsername(username);
        setPassword(hashedpassword);
    }

    @NonNull
    private String username;
    @NonNull
    private String password;

    private boolean gender;
    private String city;
    private int age;

    public static String hashPassword(String password){

        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            return new String(digest.digest(password.getBytes()));
        }catch (NoSuchAlgorithmException e){
            Log.e("IQW/User", e.getMessage());
        }
        return null;
    }



    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = hashPassword(password);
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
