package dao;

import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

public class Sql2oUserDao implements UserDao {
    public Sql2oUserDao(){}

    @Override
    public void add(Users user) {
        String sql = "INSERT INTO users(username, password, salt, email, display_name, trees_planted,inclan,clan_name) values (:username, :password, :salt, :email, :display_name, :trees_planted, :inClan, :clan_name)";
        try(Connection con = DB.sql2o.open()){
            int id = (int) con.createQuery(sql,true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        } catch (Sql2oException ex){
            System.out.println("Failed to Add: "+ex);
        }
    }

    @Override
    public byte[] getUserSalt(String username) {
        String sql = "SELECT salt from users where username = :username";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("username",username)
                    .executeAndFetchFirst(byte[].class);
        }
    }

    @Override
    public void updateUsername(Users user) {

    }

    @Override
    public void updatePassword(Users user) {

    }


}
