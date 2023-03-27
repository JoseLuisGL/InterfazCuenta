
public class Main {

	public static void main(String[] args) {
		Splash splash = new Splash();

        try {
            Thread.sleep(3000); // espera 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        splash.dispose();
		
		Ventana v1 = new Ventana();
	}
}
