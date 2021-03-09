package prelol.prelolscore.Database.TableAcces;

import com.sun.tools.javac.resources.CompilerProperties;
import prelol.prelolscore.Database.Abstraction.Query;
import prelol.prelolscore.Database.SQLite;
import prelol.prelolscore.Database.Types.Cuboid;
import prelol.prelolscore.Main;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class DBCuboids extends SQLite
{
    private static DBCuboids _dbcuboids;
    public static DBCuboids Instance()
    {
        if(_dbcuboids==null)
            _dbcuboids=new DBCuboids();
        return  _dbcuboids;
    }

    public DBCuboids()
    {

        SQLiteCreateTokensTable=
                "CREATE TABLE IF NOT EXISTS tbl_cuboids (" +
                //"`id` int(11) NOT NULL," +
                "`name` varchar(32) NOT NULL," +
                "`world` varchar(32) NOT NULL," +
                "`x1` int(11) NOT NULL," +
                "`y1` int(11) NOT NULL," +
                "`z1` int(11) NOT NULL," +

                "`x2` int(11) NOT NULL," +
                "`y2` int(11) NOT NULL," +
                "`z2` int(11) NOT NULL" +
                //"PRIMARY KEY (`id`)" +
                ");";
    }

    public List<Cuboid> getAllCuboids()
    {
        Query q = new Query(getSQLConnection());
        q.preQuery("SELECT rowid, * FROM tbl_cuboids");
        ResultSet rs = q.query();
        List<Cuboid> cs = new ArrayList<>();
        try
        {
            while (rs.next())
            {
                Cuboid c = new Cuboid(
                        rs.getInt("rowid"),
                        Main.Instance().getServer().getWorld(rs.getString("world")),
                        rs.getInt( "x1"),
                        rs.getInt( "y1"),
                        rs.getInt( "z1"),

                        rs.getInt( "x2"),
                        rs.getInt( "y2"),
                        rs.getInt( "z2")
                );
                c.setName(rs.getString( "name"));
                cs.add(c);
            }
        }
        catch (Exception ex)
        {
            Main.Instance().getLogger().log(Level.SEVERE, "Couldn't get all cuboids", ex);
        }
        finally
        {
            q.close();
        }
        return cs;
    }

    public Cuboid getCuboid(int id)
    {
        Query q = new Query(getSQLConnection());
        q.preQuery("SELECT rowid, * FROM tbl_cuboids WHERE rowid = '"+id+"';");
        ResultSet rs= q.query();
        try
        {
            if(rs.next())
            {
                Cuboid c= new Cuboid(
                        rs.getInt( "rowid"),
                        Main.Instance().getServer().getWorld(rs.getString("world")),
                        rs.getInt( "x1"),
                        rs.getInt( "y1"),
                        rs.getInt( "z1"),

                        rs.getInt( "x2"),
                        rs.getInt( "y2"),
                        rs.getInt( "z2")
                        );
                c.setName(rs.getString("name"));
            }
        }
        catch (Exception ex)
        {
            Main.Instance().getLogger().log(Level.SEVERE, "Couldn't get cuboid with id "+id, ex);
        }
        finally
        {
            q.close();
        }
        return null;
    }
    public void setCuboid(Cuboid cuboid)
    {
        if(cuboid.getId()==-1)
        {
            Query q = newQuery();
            q.preQuery("INSERT INTO tbl_cuboids (name,world,x1,y1,z1,x2,y2,z2) VALUES(?,?,?,?,?,?,?,?)");
            q.set(1, cuboid.getName());
            q.set(2, cuboid.getWorld().getName());
            q.set(3, cuboid.getMinX());
            q.set(4, cuboid.getMinY());
            q.set(5, cuboid.getMinZ());
            q.set(6, cuboid.getMaxX());
            q.set(7, cuboid.getMaxY());
            q.set(8, cuboid.getMaxZ());
            q.queryNoResult();
            q.close();
        }
        else
        {
            Query q = newQuery();
            q.preQuery("INSERT INTO tbl_cuboids (ROWID,name,world,x1,y1,z1,x2,y2,z2) VALUES(?,?,?,?,?,?,?,?,?)");
            q.set(2, cuboid.getId());
            q.set(2, cuboid.getName());
            q.set(3, cuboid.getWorld().getName());
            q.set(4, cuboid.getMinX());
            q.set(5, cuboid.getMinY());
            q.set(6, cuboid.getMinZ());
            q.set(7, cuboid.getMaxX());
            q.set(8, cuboid.getMaxY());
            q.set(9, cuboid.getMaxZ());
            q.queryNoResult();
            q.close();
        }

    }

    public void removeCuboid(int id)
    {
        Query q = new Query(getSQLConnection());
        q.preQuery("DELETE FROM tbl_cuboids WHERE rowid = "+id+";");
        q.queryNoResult();
        q.close();
    }
}
