package com.uai.app.logic;

import com.uai.app.dominio.Libro;
import com.uai.app.dominio.enums.Tittles;
import com.uai.app.exceptions.DataNotLoadedException;
import org.apache.commons.text.CaseUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class DataManager {

    private HashSet<Libro> data;

    private static DataManager instance;


    private  DataManager(){
    }

    public static DataManager getInstance(){
        if (instance == null){
            instance = new DataManager();
            SearchManager.getInstance();
        }
        return instance;
    }

    public HashSet<Libro> getData() {
        return data;
    }

    public void setData(HashSet<Libro> data) {
        this.data = data;
    }

    public String getDataAsString() throws DataNotLoadedException {

        StringBuilder sb = new StringBuilder(data.size()*50);
        for (Libro p : data){
            sb.append(p);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void agregarLibro(Libro p){
        this.data.add(p);
    }
    
    public void removerLibro(Libro p){
        this.data.remove(p);
    }

    public void removerLibros(Collection<Libro> libros){
        this.data.removeAll(libros);
    }
}
