package com.example.demo.repos;

import com.example.demo.models.Kompis;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by: Ulf Nyberg
 * Date: 2021-04-08
 * Time: 14:44
 * Project: demo01
 * Copyright: MIT
 */
public class DAO {

    public List<Kompis> getAllKompisar (){
        Kompis k1 = new Kompis(1, "Bobbie", "Gatugatan 12", 67766);
        Kompis k2 = new Kompis(2, "Gentry", "Gatugatan 1", 989867);
        Kompis k3 = new Kompis(3, "Stephen", "Gatugatan 182", 223232);
        Kompis k4 = new Kompis(4, "Fry", "Gatugatan 1298", 8978878);

        List<Kompis> lista = new LinkedList<>();
        lista.add(k1);
        lista.add(k2);
        lista.add(k3);
        lista.add(k4);

        return lista;
    }
}
