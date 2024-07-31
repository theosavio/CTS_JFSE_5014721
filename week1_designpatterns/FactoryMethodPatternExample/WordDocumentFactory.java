public class WordDocumentFactory extends DocumentFactory {
    @Override
    public WordDocument createWordDocument() {
        return new WordDocumentImpl();
    }

    @Override
    public PdfDocument createPdfDocument() {
        return null; 
    }

    @Override
    public ExcelDocument createExcelDocument() {
        return null; 
    }
}
