package prelol.prelolscore.Database.Abstraction;

import prelol.prelolscore.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

public class Query
{
    public Query(Connection conn)
    {
        this.conn=conn;
    }

    private Connection conn;
    private PreparedStatement ps;

    public void preQuery(String command)
    {
        try
        {
            ps= conn.prepareStatement(command);
        } catch (SQLException ex) {
            Main.Instance().getLogger().log(Level.SEVERE, "Couldn't prepare statement! did we lose connection?", ex);
        }
    }

    public void set(int index, Object o)
    {
        try
        {
            ps.setObject(index,o);
        } catch (SQLException ex) {
            Main.Instance().getLogger().log(Level.SEVERE, "Couldn't set parameter of prepared statement! did we lose connection?", ex);
        }
    }

    public ResultSet query() {

        try
        {
            return ps.executeQuery();
        }
        catch (SQLException ex)
        {
            Main.Instance().getLogger().log(Level.SEVERE, "Execution of the Query failed!", ex);
            close();
        }
        return null;
    }
    public void queryNoResult() {

        try
        {
            ps.execute();
        }
        catch (SQLException ex)
        {
            Main.Instance().getLogger().log(Level.SEVERE,"Execution of the (NoResult) Query failed!", ex);
            close();
        }
    }

    public void close()
    {
        try {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        } catch (SQLException ex) {
            Main.Instance().getLogger().log(Level.SEVERE, "Couldn't close connection!", ex);
        }
    }
}
