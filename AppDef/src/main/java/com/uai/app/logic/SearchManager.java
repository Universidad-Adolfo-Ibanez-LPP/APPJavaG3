package com.uai.app.logic;


import com.uai.app.dominio.Libro;
import com.uai.app.dominio.enums.Tittles;
import org.apache.commons.text.CaseUtils;
import org.apache.commons.text.similarity.LevenshteinDistance;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;

public class SearchManager{


    public static final int FILTER_MAX_DISTANCE = 4;


    private static LevenshteinDistance lv = new LevenshteinDistance();

    private static SearchManager instance;


    private SearchManager(){

    }

    public static SearchManager getInstance(){
        if (instance == null){
            instance = new SearchManager();
        }
        return instance;
    }


    public HashSet<Libro> buscarLibroPorAtributo(Tittles title, String theSearch){
        return buscarLibroPorAtributo(title, theSearch, FILTER_MAX_DISTANCE);
    }

    //mismo metodo que el de arriba solo que pedimos la precision
    public HashSet<Libro> buscarLibroPorAtributo(Tittles title, String toSearch, int precision){
        //ahora instancio un mapa con esas claves
        HashSet<Libro> data = DataManager.getInstance().getData();
        HashSet<Libro> resultados = new HashSet<Libro>();
        for (Libro l : data){
            //Uso lo mismo que en el data manager
            Class<?> classObj = l.getClass();
            Method obtenerPropiedad = null;
            try {
                String camelCase = CaseUtils.toCamelCase(title.getVal(), true);
                obtenerPropiedad = classObj.getDeclaredMethod("get"+camelCase);
                String propiedad = String.valueOf(obtenerPropiedad.invoke(l));

                // si es un numero entonces no uso distancia de leventeihns
                if (obtenerPropiedad.getReturnType().isPrimitive() ||
                        obtenerPropiedad.getReturnType().isAssignableFrom(Integer.class)){
                    if (toSearch.trim().equalsIgnoreCase(propiedad)){
                        resultados.add(l);
                    }
                } else {
                    //Con una distancia de 3 estamos bien cubiertos
                    if (lv.apply(toSearch, propiedad) < precision){
                        resultados.add(l);
                    }
                }


            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

        }
        return resultados;
    }


}