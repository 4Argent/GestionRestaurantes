package General;

import java.io.IOException;

public class LimpiarPantalla {

	public static void limpiarPantalla() {
	    try {
	        if (System.getProperty("os.name").contains("Windows")) {
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        } else {
	            new ProcessBuilder("clear").inheritIO().start().waitFor();
	        }
	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
	}
}
