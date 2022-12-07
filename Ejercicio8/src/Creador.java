/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author FREDDY
 */
public class Creador {

    public void crearArchivo(int ints, String dats[], String ruta) {
        try {

            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter fw = new PrintWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(String.valueOf(ints+" \n"));

            for (int i = 0; i < dats.length; i++) {
                if (i == dats.length - 1) {
                    bw.write(dats[i] + " \n");
                } else {
                    bw.write(dats[i] + " \n");
                }
            }
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Creador creador = new Creador();
        Scanner sc = new Scanner(System.in);
        int instruc = sc.nextInt();
        //String ruta = sc.next();
        String ruta = "C:/Users/FREDDY/Desktop/prueba/dats.txt";
        String[] casos = new String[instruc];

        for (int i = 0; i < instruc; i++) {
            int tipo = (int) (Math.random() * 3 + 1);
            int numero = (int) (Math.random() * 1000 + 1);

            switch (tipo) {
                case 1: {
                    String n = ("insert " + numero);
                    casos[i] = n;
                    break;
                }
                case 2: {
                    String n = ("getMin " + numero);
                    casos[i] = n;
                    break;
                }
                case 3: {
                    String n = ("removeMin ");
                    casos[i] = n;
                    break;
                }
            }
        }
        creador.crearArchivo(instruc, casos, ruta);

        for (int i = 0; i < casos.length; i++) {
            System.out.println(casos[i]);
        }
    }

}
