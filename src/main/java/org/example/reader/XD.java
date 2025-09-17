package org.example.reader;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.FilaExcelDTO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XD {
    // dentro de la clase XD
    public List<FilaExcelDTO> leerDesdeExcel(String ruta) throws IOException {
        List<FilaExcelDTO> filas = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(ruta);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

            Iterator<Row> rowIterator = sheet.rowIterator();

            // Leer encabezado (fila 0) A-J
            List<String> encabezado = new ArrayList<>();
            if (rowIterator.hasNext()) {
                Row headerRow = rowIterator.next();
                for (int i = 0; i < 10; i++) {
                    Cell cell = headerRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    encabezado.add(formatter.formatCellValue(cell, evaluator).trim());
                }
                System.out.println("Encabezado: " + encabezado);
            }

            // Leer filas y mapear a DTO (A-J)
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Determinar si la fila está vacía (todas las celdas A-J vacías) usando formatter
                boolean filaVacia = true;
                for (int i = 0; i < 10; i++) {
                    Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (!formatter.formatCellValue(cell, evaluator).trim().isEmpty()) {
                        filaVacia = false;
                        break;
                    }
                }
                if (filaVacia) {
                    continue; // Saltar fila vacía
                }

                FilaExcelDTO filaDTO = new FilaExcelDTO();
                filaDTO.setColumnaA(formatter.formatCellValue(row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK), evaluator).trim());
                filaDTO.setColumnaB(formatter.formatCellValue(row.getCell(1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK), evaluator).trim());
                filaDTO.setColumnaC(formatter.formatCellValue(row.getCell(2, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK), evaluator).trim());
                filaDTO.setColumnaD(formatter.formatCellValue(row.getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK), evaluator).trim());
                filaDTO.setColumnaE(formatter.formatCellValue(row.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK), evaluator).trim());
                filaDTO.setColumnaF(formatter.formatCellValue(row.getCell(5, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK), evaluator).trim());
                filaDTO.setColumnaG(formatter.formatCellValue(row.getCell(6, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK), evaluator).trim());
                filaDTO.setColumnaH(formatter.formatCellValue(row.getCell(7, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK), evaluator).trim());
                filaDTO.setColumnaI(formatter.formatCellValue(row.getCell(8, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK), evaluator).trim());
                filaDTO.setColumnaJ(formatter.formatCellValue(row.getCell(9, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK), evaluator).trim());

                filas.add(filaDTO);
            }



            return filas;
        }

    }

    // Escribe la lista de DTOs a un archivo .xlsx (columnas A-J)
    public void escribirAExcel(String rutaSalida, List<FilaExcelDTO> filas) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Datos");

            // Cabecera: usar nombres amigables o los mismos A..J
            Row header = sheet.createRow(0);
            String[] headers = new String[]{"Email", "Perfil", "C", "D", "E", "F", "G", "H", "I", "Unidad"};
            for (int i = 0; i < headers.length; i++) {
                Cell c = header.createCell(i);
                c.setCellValue(headers[i]);
            }

            // Rellenar filas
            int rowIndex = 1;
            for (FilaExcelDTO dto : filas) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(dto.getColumnaA() == null ? "" : dto.getColumnaA());
                row.createCell(1).setCellValue(dto.getColumnaB() == null ? "" : dto.getColumnaB());
                row.createCell(2).setCellValue(dto.getColumnaC() == null ? "" : dto.getColumnaC());
                row.createCell(3).setCellValue(dto.getColumnaD() == null ? "" : dto.getColumnaD());
                row.createCell(4).setCellValue(dto.getColumnaE() == null ? "" : dto.getColumnaE());
                row.createCell(5).setCellValue(dto.getColumnaF() == null ? "" : dto.getColumnaF());
                row.createCell(6).setCellValue(dto.getColumnaG() == null ? "" : dto.getColumnaG());
                row.createCell(7).setCellValue(dto.getColumnaH() == null ? "" : dto.getColumnaH());
                row.createCell(8).setCellValue(dto.getColumnaI() == null ? "" : dto.getColumnaI());
                row.createCell(9).setCellValue(dto.getColumnaJ() == null ? "" : dto.getColumnaJ());
            }

            // Autoajustar columnas
            for (int i = 0; i < 10; i++) {
                sheet.autoSizeColumn(i);
            }

            // Escribir en archivo
            try (FileOutputStream fos = new FileOutputStream(rutaSalida)) {
                workbook.write(fos);
            }
        }
    }

}
