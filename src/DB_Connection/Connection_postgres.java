package DB_Connection;

import java.sql.*;

public class Connection_postgres {

    private static Connection con;
    public static void Start_connection(){

        String url = "jdbc:postgresql://localhost:5432/payment_project_demo";//for postgres
        String user = "postgres";
        String pass = "0000";


        try {
            Class.forName("org.postgresql.Driver");//uses static block in driver class
            con = DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void End_Connection() {
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void queryCard(long CardNumber)
    {

        String sql = "select count(*) from cards where cardnumber="+CardNumber;


        try{
            Statement  st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);


            rs.next();
            int count = rs.getInt(1);
            if(count==0)
            {
                throw new IllegalStateException("no card with this number available in database");
            }

        }
        catch (Exception e)
        {
            throw new RuntimeException("error checking card availability" + e);
        }

    }

    public static void queryitems()
    {
        Start_connection();

        String sql = "select * from product limit 10";


        try{
            Statement  st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);


            while(rs.next())
            {
                String rowdata = "";
                for(int col = 1;col<=2;col++)
                {
                    rowdata += rs.getString(col) + "  ";
                }
                System.out.println(rowdata);
            }


        }
        catch (Exception e)
        {
            throw new RuntimeException("error checking card availability" + e);
        }




        End_Connection();
    }


}
