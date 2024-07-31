public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public WordDocument createWordDocument() {
        return null; 
    }

    @Override
    public PdfDocument createPdfDocument() {
        return new PdfDocumentImpl();
    }

    @Override
    public ExcelDocument createExcelDocument() {
        return null; 
    }
}
