import java.sql.ResultSet;
import java.sql.SQLException;

public class Main 
{
	public static void main (String []args)
	{
		MiBD conexion =  new MiBD();
		ResultSet result;
		ResultSet result2;
		ResultSet result3;
		ResultSet result4;
		ResultSet result5;
		ResultSet result6;
		ResultSet result7;
		ResultSet result8;
		ResultSet result9;

		equipo_puertos equipo1=new equipo_puertos();
		equipo_propietarios equipo2=new equipo_propietarios();
		embarcaciones embarcaciones =new embarcaciones();
		propietarios propietarios = new propietarios();
		contratos contratos = new contratos();
		mantenimiento mantenimiento = new mantenimiento();
		clientes clientes = new clientes();
		paseos_del_puerto paseos_del_puerto = new paseos_del_puerto();
		equipo equipo =new equipo();
		result = conexion.getQuery("select * from equipo_paseos_del_puerto");
		try
		{
			while(result.next())
			{
				equipo1.jabon = result.getInt("jabon");
				equipo1.papel = result.getInt("papel_higienico");
				equipo1.toallas =  result.getInt("toallas");
				equipo1.libros = result.getInt("libros_navegacion");
				equipo1.diagramas =  result.getInt("diagramas");
				equipo1.tablas =  result.getInt("tablas_madera");

				System.out.println ("la cantidad de jabon es:" + equipo1.jabon);
				System.out.println("la cantidad de papel es:"+ equipo1.papel);
				System.out.println("la cantidad de toallas es:"+equipo1.toallas);
				System.out.println("la cantidad de libros es:"+ equipo1.libros);
				System.out.println("la cantidad de diagramas es:"+ equipo1.diagramas);
				System.out.println("la cantidad de tablas de madera es:"+ equipo1.tablas);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		result2 = conexion.getQuery("select * from equipo_propietarios");   //modificar
		try
		{
			while(result2.next())
			{
				equipo2.equipo_propID = result2.getInt("equipo_propID");
				equipo2.velas = result2.getInt("velas");
				equipo2.anclas =  result2.getInt("anclas");
				equipo2.cuerdas = result2.getInt("cuerdas");
				equipo2.lanchas =  result2.getInt("lanchas");
				equipo2.salvavidas =  result2.getInt("salvavidas");
				equipo2.refrigeradores =  result2.getInt("refrigeradores");
				equipo2.brujulas =  result2.getInt("brujulas");
				equipo2.indicadores =  result2.getInt("indicadores");
				equipo2.estufas =  result2.getInt("estufas");
				equipo2.radios=  result2.getInt("radios");

				System.out.println ("la cantidad de velas es:" + equipo2.velas);
				System.out.println("la cantidad de anclas es:"+equipo2.anclas);
				System.out.println("la cantidad de cuerdas es:"+equipo2.cuerdas);
				System.out.println("la cantidad de lanchas es:"+equipo2.lanchas);
				System.out.println("la cantidad de salvavidas es:"+equipo2.salvavidas);
				System.out.println("la cantidad de refrigeradores de madera es:"+equipo2.refrigeradores);
				System.out.println("la cantidad de brujulas es:"+equipo2.brujulas);
				System.out.println("la cantidad de indicadores es:"+equipo2.indicadores);
				System.out.println("la cantidad de estufas es:"+equipo2.estufas);
				System.out.println("la cantidad de radios es:"+equipo2.radios);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		result3 = conexion.getQuery("select * from embarcaciones");
		try
		{
			while(result3.next())
			{
				embarcaciones.embarcacionesID = result3.getInt("embarcacionesID");
				embarcaciones.pequeñas = result3.getInt("pequeñas");
				embarcaciones.grandes = result3.getInt("grandes");


				System.out.println ("la cantidad de embarcaciones pequeñas es:" + embarcaciones.pequeñas);
				System.out.println ("la cantidad de embarcaciones grandes es:" + embarcaciones.grandes);

			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		result4 = conexion.getQuery("select * from propietarios");
		try
		{
			while(result4.next())
			{
				propietarios.propietariosid = result4.getInt("propietariosid");
				propietarios.disponibilidad = result4.getString("disponibilidad");


				System.out.println (propietarios.propietariosid);
				System.out.println (propietarios.disponibilidad);

			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		result5 = conexion.getQuery("select * from contratos");
		try
		{
			while(result5.next())
			{
				contratos.contratosID = result5.getInt("contratosID");
				contratos.registro_actividad = result5.getString("registro_actividad");


				System.out.println (contratos.contratosID);
				System.out.println ("su  registro es el siguiente: " + contratos.registro_actividad);

			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		result6 = conexion.getQuery("select * from costo_de_mantenimiento");
		try
		{
			while(result6.next())
			{
				mantenimiento.mantenimientoID = result6.getInt("mantenimientoID");
				mantenimiento.limpieza = result6.getInt("limpieza");
				mantenimiento.cambios_de_aceite = result6.getInt("cambios_de_aceite");
				mantenimiento.reparaciones = result6.getInt("reparaciones");


				System.out.println (contratos.contratosID);
				System.out.println ("el cargo de limpieza es: " + mantenimiento.limpieza);
				System.out.println ("el cargo de cambio de aceite es: " + mantenimiento.cambios_de_aceite);
				System.out.println ("el cargo de reparaciones es: " + mantenimiento.reparaciones);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		result7 = conexion.getQuery("select * from clientes");
		try
		{
			while(result7.next())
			{
				clientes.clienteid = result7.getInt("clienteid");
				clientes.nombre = result7.getString("nombre");

				System.out.println (clientes.clienteid);
				System.out.println ( clientes.nombre);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		result8 = conexion.getQuery("select * from paseos_del_puerto");
		try
		{
			while(result8.next())
			{
				paseos_del_puerto.localizacion = result8.getString("localizacion");
				paseos_del_puerto.horario = result8.getString("horario");

				System.out.println (paseos_del_puerto.localizacion);
				System.out.println (paseos_del_puerto.horario);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		result9 = conexion.getQuery("select * from equipo");
		try
		{
			while(result9.next())
			{
				equipo.equipoID = result9.getInt("equipoID");
				equipo.registro_de_actividad = result9.getString("registro_de_actividad");
				equipo.tripulacion = result9.getInt("tripulacion");

				System.out.println (equipo.equipoID);
				System.out.println (equipo.registro_de_actividad);
				System.out.println ("la tripulacion extra fue de: " + equipo.tripulacion);

			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}


