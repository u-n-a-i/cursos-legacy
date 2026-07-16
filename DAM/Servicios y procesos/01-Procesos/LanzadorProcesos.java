/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lanzadorprocesos;

/**
 *
 * @author blank
 * Lanzador de Acrobat Reader y hasta que no se cierre Calibre
 * 
 * 
 */
public class LanzadorProcesos {
    public void ejecutar(String ruta)
    {
            /*
            En el paquete java.lang tenemos dos clases para la gestión de procesos.
            java.lang.ProcessBuilder Referencia API Java
            java.lang.Process Referencia API Java   
            Las instancias de ProcessBuilder gestionan los atributos de los procesos, 
            mientras que las instancias de Process controlan la ejecución de esos mismos procesos cuando se ejecutan.
            */
                ProcessBuilder pb;
                try {
                        pb = new ProcessBuilder(ruta);
                        Process p = pb.start();
                        p.waitFor();
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }

     }
    public static void main(String[] args) {
        String ruta=
                        "C:\\Program Files\\Adobe\\Acrobat DC\\Acrobat\\Acrobat.exe";
        String ruta2 = 
                "C:\\Program Files\\Calibre2\\calibre.exe";
                LanzadorProcesos lp=new LanzadorProcesos();
                lp.ejecutar(ruta);
                lp.ejecutar(ruta2);
                System.out.println("Finalizado");
    }
}
