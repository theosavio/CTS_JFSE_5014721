public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        WordDocument wordDoc = wordFactory.createWordDocument();
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        PdfDocument pdfDoc = pdfFactory.createPdfDocument();
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        ExcelDocument excelDoc = excelFactory.createExcelDocument();
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();
    }
}
