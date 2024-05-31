import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        ConsultaPelicula consultaPelicula = new ConsultaPelicula();

        System.out.println("Escriba el numero de la pelicula de star Wars que quiere consultar:");

        try {

            var numeroDePelicula = Integer.valueOf(lectura.nextLine());
            Pelicula pelicula = consultaPelicula.busquedaPelicula(numeroDePelicula);
            System.out.println(pelicula);

            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(pelicula);

        } catch (NumberFormatException e){
            System.out.println("Número no encontrado" + e.getMessage());

        } catch(RuntimeException | IOException e){
            System.out.println(e.getMessage());
            //System.out.println("Finalizando la aplicación.");

        }finally {
            System.out.println("Finalizando la aplicación.");

        }
    }
}
