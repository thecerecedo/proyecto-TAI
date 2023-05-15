import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MiBD 
{
	private static String user = "postgres"; //User de la BD
	private static String pswd = "malcon123"; //Password de la BD
	private static String bd = "proyectoBD"; //Nombre de la BD
	private static String server = "jdbc:postgresql://localhost:5432/"+bd; //Llamando a nuestro server de BD
	private static String driver = "org.postgresql.Driver";//Driver que permite conectarse con PostgreSQL
	private static Connection con = null; //Para verificar la conexión
	
	public MiBD() 
	{
		try
		{
			Class.forName(driver);
			con = (Connection)DriverManager.getConnection(server, user, 
					pswd);
			
			if(con != null)
			{
				System.out.println("La conexión a la BD: "+ server +" "
						+ "se realizo al 100%");
			}
		}
		catch(SQLException ex)
		{
			System.out.println("Error al intentar conectarse a la BD"+ 
		server);
		}
		catch(ClassNotFoundException ex)
		{
			System.out.println(ex);
		}
	}	
	
	public ResultSet getQuery(String query)
	{
		Statement state = null;
		ResultSet result = null;
		
		try
		{
			state=(Statement) con.createStatement();
			result=state.executeQuery(query);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public void setQuery (String query)
	{
		Statement state = null;
		try
		{
			state = (Statement) con.createStatement();
			state.executeQuery(query);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}

	

