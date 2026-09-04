/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
/**
 *
 * @author LENOVO
 */



public class ExportPDF implements Exportable {

    @Override
    public void exportar(JTable tabla, String titulo) {

        try {

            if (tabla.getRowCount() == 0) {

                JOptionPane.showMessageDialog(
                        null,
                        "No hay datos para exportar"
                );

                return;
            }

            JFileChooser seleccionar = new JFileChooser();

            seleccionar.setSelectedFile(
                    new java.io.File("ReporteTorneos.pdf")
            );

            int opcion = seleccionar.showSaveDialog(null);

            if (opcion == JFileChooser.APPROVE_OPTION) {

                String ruta = seleccionar
                        .getSelectedFile()
                        .getAbsolutePath();

                if (!ruta.endsWith(".pdf")) {

                    ruta = ruta + ".pdf";
                }

                Document documento = new Document();

                PdfWriter.getInstance(
                        documento,
                        new FileOutputStream(ruta)
                );

                documento.open();

                documento.add(
                        new Paragraph(titulo)
                );

                documento.add(
                        new Paragraph(" ")
                );

                PdfPTable tablaPDF
                        = new PdfPTable(
                                tabla.getColumnCount()
                        );

                // ENCABEZADOS
                for (int i = 0;
                        i < tabla.getColumnCount();
                        i++) {

                    tablaPDF.addCell(
                            tabla.getColumnName(i)
                    );
                }

                // DATOS
                for (int fila = 0;
                        fila < tabla.getRowCount();
                        fila++) {

                    for (int columna = 0;
                            columna < tabla.getColumnCount();
                            columna++) {

                        Object dato
                                = tabla.getValueAt(
                                        fila,
                                        columna
                                );

                        if (dato == null) {

                            tablaPDF.addCell("");

                        } else {

                            tablaPDF.addCell(
                                    dato.toString()
                            );
                        }
                    }
                }

                documento.add(tablaPDF);

                documento.close();

                JOptionPane.showMessageDialog(
                        null,
                        "PDF exportado correctamente"
                );
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Error al exportar PDF"
            );

            System.out.println(
                    "ERROR PDF: "
                    + e.getMessage()
            );
        }
    }
}