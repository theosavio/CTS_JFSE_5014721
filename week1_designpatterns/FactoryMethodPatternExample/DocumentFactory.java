public abstract class DocumentFactory {
    public abstract WordDocument createWordDocument();
    public abstract PdfDocument createPdfDocument();
    public abstract ExcelDocument createExcelDocument();
}