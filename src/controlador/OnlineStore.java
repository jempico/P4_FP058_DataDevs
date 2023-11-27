package controlador;
import java.lang.*;

import controlador.main.ConexionBD;
import vista.GestionOS;

public class OnlineStore {

	public static void main(String[] args) {
		// GestionOS gestion = new GestionOS();
		// gestion.inicio();
		ConexionBD conexionBD = new ConexionBD();
		conexionBD.conectar();
	}

}
