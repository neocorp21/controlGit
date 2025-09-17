package org.example;

import org.example.reader.XD;

import java.io.IOException;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
        XD xd = new XD();
        List<FilaExcelDTO> data= xd.leerDesdeExcel("C:\\Users\\xvlad\\Desktop\\valorExcel\\valor.xlsx");
        System.out.println(data);

        String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String salida = "C:\\Users\\xvlad\\Desktop\\valorExcel\\salida_" + fecha + ".xlsx";
        xd.escribirAExcel(salida, data);
        System.out.println("Archivo escrito en: " + salida);
    }
}