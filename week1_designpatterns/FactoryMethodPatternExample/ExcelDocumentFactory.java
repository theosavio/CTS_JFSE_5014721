public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public WordDocument createWordDocument() {
        return null;
    }

    @Override
    public PdfDocument createPdfDocument() {
        return null; 
    }

    @Override
    public ExcelDocument createExcelDocument() {
        return new ExcelDocumentImpl();
    }
}
