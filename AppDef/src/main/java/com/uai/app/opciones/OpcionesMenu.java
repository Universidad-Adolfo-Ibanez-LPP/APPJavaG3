package com.uai.app.opciones;

import java.util.*;

import com.uai.app.dominio.Libro;
import com.uai.app.logic.DataManager;;

public class OpcionesMenu {

    //Opcion 1 (agregar libro)
    public static Libro crearLibro(){
        Libro libro_new = new Libro();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el titulo:");
        String titulo = scanner.nextLine();
        libro_new.setTitulo(titulo);

        System.out.println("Ingrese el autor:");
        String autor = scanner.nextLine();
        libro_new.setAutor(autor);

        System.out.println("Ingrese el anio:");
        String anio = scanner.nextLine();
        libro_new.setAnio(anio);

        System.out.println("Ingrese el numero de estante:");
        String est_num = scanner.nextLine();
        libro_new.setEstante_numero(est_num);

        System.out.println("Ingrese la seccion del estante:");
        String est_sec = scanner.nextLine();
        libro_new.setEstante_seccion(est_sec);

        System.out.println("Ingrese el piso:");
        String piso = scanner.nextLine();
        libro_new.setPiso(piso);

        System.out.println("Ingrese el edificio:");
        String edificio = scanner.nextLine();
        libro_new.setEdificio(edificio);

        System.out.println("Ingrese la sede:");
        String sede = scanner.nextLine();
        libro_new.setSede(sede);
        return libro_new;
    }

    //Opcion 2 (Eliminar libro)
    public static void eliminarLibro(){
        System.out.println("Ingrese el nombre del libro que quiere eliminar: ");
        Scanner scanner = new Scanner(System.in);
        String delete = scanner.nextLine();
        HashSet<Libro> data = DataManager.getInstance().getData();
        Libro libroBorrar = null;
        for (Libro l : data){
            if (l.getTitulo().equals(delete)){
                libroBorrar = l;
            }
        }
        if (libroBorrar != null){
            DataManager.getInstance().removerLibro(libroBorrar);
        }

    }

    //Opcion 3 (agregar una sede)
    
    //Opcion 4 (eliminar una sede solo si no tiene libros asociados)

    //Opcion 5 (editar un libro)
    public static void editarLibro(){
        System.out.println("Ingrese el nombre del libro que quiere editar: ");
        Scanner scanner = new Scanner(System.in);
        String edit = scanner.nextLine();
        HashSet<Libro> data = DataManager.getInstance().getData();
        Libro libroEditar = null;
        for (Libro l : data){
            if (l.getTitulo().equals(edit)){
                libroEditar = l;
            }
        }
        if(libroEditar != null){
            System.out.println("Ingrese el nuevo autor:");
            String autor = scanner.nextLine();
            libroEditar.setAutor(autor);

            System.out.println("Ingrese el nuevo anio:");
            String anio = scanner.nextLine();
            libroEditar.setAnio(anio);

            System.out.println("Ingrese el nuevo numero del estante:");
            String est_num = scanner.nextLine();
            libroEditar.setEstante_numero(est_num);

            System.out.println("Ingrese la nueva seccion del estante:");
            String est_sec = scanner.nextLine();
            libroEditar.setEstante_seccion(est_sec);

            System.out.println("Ingrese el nuevo piso:");
            String piso = scanner.nextLine();
            libroEditar.setPiso(piso);

            System.out.println("Ingrese el nuevo edificio:");
            String edificio = scanner.nextLine();
            libroEditar.setEdificio(edificio);

            System.out.println("Ingrese la nueva sede:");
            String sede = scanner.nextLine();
            libroEditar.setSede(sede);
        }
    }

    //Opcion 6 (cambiar un libro de sede)
    public static void cambiarSede(){
        System.out.println("Ingrese el nombre del libro que quiere cambiar de sede:");
        Scanner scanner = new Scanner(System.in);
        String edit = scanner.nextLine();
        HashSet<Libro> data = DataManager.getInstance().getData();
        Libro libroEditar = null;
        for (Libro l : data){
            if (l.getTitulo().equals(edit)){
                libroEditar = l;
            }
        }
        if(libroEditar != null){
            System.out.println("Ingrese la nueva sede:");
            String sede = scanner.nextLine();
            libroEditar.setSede(sede); 
        }    
    }

    //Opcion 7 (cambiar un libro de seccion)
    public static void cambiarSeccion(){
        System.out.println("Ingrese el nombre del libro que quiere cambiar de sección:");
        Scanner scanner = new Scanner(System.in);
        String edit = scanner.nextLine();
        HashSet<Libro> data = DataManager.getInstance().getData();
        Libro libroEditar = null;
        for (Libro l : data){
            if (l.getTitulo().equals(edit)){
                libroEditar = l;
            }
        }
        if(libroEditar != null){
            System.out.println("Ingrese la nueva seccion del estante:");
            String est_sec = scanner.nextLine();
            libroEditar.setEstante_seccion(est_sec);
        }
    }

    //Opcion 8 (cambiar un libro de piso)
    public static void cambiarPiso(){
        System.out.println("Ingrese el nombre del libro que quiere cambiar de piso:");
        Scanner scanner = new Scanner(System.in);
        String edit = scanner.nextLine();
        HashSet<Libro> data = DataManager.getInstance().getData();
        Libro libroEditar = null;
        for (Libro l : data){
            if (l.getTitulo().equals(edit)){
                libroEditar = l;
            }
        }
        if(libroEditar != null){
            System.out.println("Ingrese el nuevo piso:");
            String piso = scanner.nextLine();
            libroEditar.setPiso(piso);
        }
    }

    //Opcion 9 (agregar secciones)

    //Opcion 10 (eliminar seccion solo si no tiene libros asociados)

    //Opcion 11 (agregar pisos)

    //Opcion 12 (eliminar pisos solo si no tiene libros asociados)

    
}
