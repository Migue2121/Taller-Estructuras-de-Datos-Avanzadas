
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ANDRES
 */
public class GenerarDatos {

    private String nombreArchivo = "prueba.txt";

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void generarDatos(int instruc) {
        try {
            String ruta = "prueba.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(instruc+" \n");
            for (int i = 0; i < instruc; i++) {

                int tipo = (int) (Math.random() * 3 + 1);
                int numero = (int) (Math.random() * 100 + 1);

                switch (tipo) {
                    case 1: {
                        String n = ("insert " + numero+" ");
                        bw.write(n);
                        break;
                    }
                    case 2: {
                        String n = ("getMin " + numero+" ");
                        bw.write(n);
                        break;
                    }
                    case 3: {
                        String n = ("removeMin ");
                        bw.write(n);
                        break;
                    }
                }
                if (i != instruc - 1) {
                    bw.write("\n");
                }
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] llenarArreglo(String arr[]) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            int j = 0;
            while ((linea = br.readLine()) != null) {
                arr[j] = linea;
                j++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return arr;
    }

    public int tamArr(String archivo) throws IOException {//No se hizo uso de este método
        Path file = Paths.get(archivo);
        long count = Files.lines(file).count();
        return (int) count;
    }
}
