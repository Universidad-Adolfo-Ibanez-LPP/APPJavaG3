package com.uai.app;

import com.uai.app.exceptions.CSVNotFoundException;
import com.uai.app.file.FileManager;
import com.uai.app.logic.DataManager;
import com.uai.app.logic.SearchManager;
import com.uai.app.opciones.OpcionesMenu;
import com.uai.app.dominio.Libro;
import com.uai.app.dominio.enums.Tittles;

import java.util.InputMismatchException;
import java.util.*;

public class App2 {

    private static FileManager fileManager;

    public static void main(String[] args ){
        System.out.println("COMENZANDO");
        String fileName = args[0];

        try {
            //instancio el file manager
            fileManager = new FileManager(fileName);
            //instancio y seteo la data
            DataManager.getInstance().setData(fileManager.getData());

        } catch (CSVNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {
            System.out.println("************MENU******************");
            System.out.println("1. Agregar un libro nuevo");
            System.out.println("2. Quitar un libro");
            System.out.println("3. Agregar una sede");
            System.out.println("4. Quitar una sede (en el caso que no tenga libros asociados)");
            System.out.println("5. Editar un libro");
            System.out.println("6. Cambiar un libro de sede");
            System.out.println("7. Cambiar un libro de seccion");
            System.out.println("8. Cambiar libro de piso");
            System.out.println("9. Agregar seccion");
            System.out.println("10. Eliminar seccion (en el caso que no tenga libros asociados)");
            System.out.println("11. Agregar piso");
            System.out.println("12. Quitar piso (en el caso que no tenga libros asociados)");
            System.out.println("13. Buscar libro");
            System.out.println("14. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion){
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        Libro nuevoLibro = OpcionesMenu.crearLibro();
                        DataManager.getInstance().agregarLibro(nuevoLibro);
                        fileManager.saveData();
                        System.out.println("Se agrego el libro con exito!");
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        OpcionesMenu.eliminarLibro();
                        fileManager.saveData();
                        System.out.println("Se ha borrado el libro con exito!");
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        fileManager.saveData();
                        break;
                    case 4:
                        System.out.println("Has seleccionado la opcion 4");
                        fileManager.saveData();
                        break;
                    case 5:
                        System.out.println("Has seleccionado la opcion 5");
                        OpcionesMenu.editarLibro();
                        fileManager.saveData();
                        System.out.println("Se ha editado el libro con exito!");
                        break;
                    case 6:
                        System.out.println("Has seleccionado la opcion 6");
                        OpcionesMenu.cambiarSede();
                        fileManager.saveData();
                        System.out.println("Se ha cambiado la sede con exito!");
                        break;
                    case 7:
                        System.out.println("Has seleccionado la opcion 7");
                        OpcionesMenu.cambiarSeccion();
                        fileManager.saveData();
                        System.out.println("Se ha cambiado la sección con exito!");
                        break;
                    case 8:
                        System.out.println("Has seleccionado la opcion 8");
                        OpcionesMenu.cambiarPiso();
                        fileManager.saveData();
                        System.out.println("Se ha cambiado el piso con exito!");
                        break;
                    case 9:
                        System.out.println("Has seleccionado la opcion 9");
                        fileManager.saveData();
                        break;
                    case 10:
                        System.out.println("Has seleccionado la opcion 10");
                        fileManager.saveData();
                        break;
                    case 11:
                        System.out.println("Has seleccionado la opcion 11");
                        fileManager.saveData();
                        break;
                    case 12:
                        System.out.println("Has seleccionado la opcion 12");
                        fileManager.saveData();
                        break;
                    case 13:
                        System.out.println("Has seleccionado la opcion 13");
                        System.out.println("Ingrese el libro que quiere buscar:");
                        sn.nextLine();
                        String buscar = sn.nextLine();
                        HashSet<Libro> busqueda = SearchManager.getInstance().buscarLibroPorAtributo(Tittles.TITULO, buscar, 10);
                        StringBuilder sb = new StringBuilder(busqueda.size()*50);
                        for (Libro p : busqueda){
                            sb.append(p);
                            sb.append(" Numero estante: ");
                            sb.append(p.getEstante_numero());
                            sb.append(" Seccion estante: ");
                            sb.append(p.getEstante_seccion());
                            sb.append(" Piso: ");
                            sb.append(p.getPiso());
                            sb.append(" Edificio: ");
                            sb.append(p.getEdificio());
                            sb.append(" Sede: ");
                            sb.append(p.getSede());
                            sb.append("\n");
                        }
                        System.out.println(sb.toString());
                        break;
                    case 14:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 14");
                }
            }catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                sn.next();
            } 
            
        }

        System.out.println("Terminado");

    }

    public static void saveData(){
        fileManager.saveData();
    }
}