package practice;

abstract class ReportGenerator {


    void report(String text){
        System.out.println("otchet po practike... "+ text);
    }
}
class PdfReport extends ReportGenerator{



    void report(String text){
        System.out.println("otchet po practike... na prf format na urok "+ text);
    }
}
class ExcelReport extends ReportGenerator{


    void report(String text){
        System.out.println("otchet po practike... na excel format na urok "+ text);
    }
}
class HtmlReport extends ReportGenerator{

    void report(String text){
        System.out.println("otchet po practike... na html format na urok "+ text);
    }
}

class Main{
    public static void main(String[] args) {
        HtmlReport htmlReport = new HtmlReport();
        htmlReport.report("matem");
        ExcelReport excelReport = new ExcelReport();
        excelReport.report("history");
        PdfReport pdfReport = new PdfReport();
        pdfReport.report("informatika");
    }
}