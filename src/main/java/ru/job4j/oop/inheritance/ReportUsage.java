package ru.job4j.oop.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        //TextReport report = new TextReport();
        // String text = report.generate("Report's name", "Report's body");
        // System.out.println(text);
        // HtmlReport rep = new HtmlReport();
        // String htmlText = rep.generate("Report's name", "Report's body");
        // System.out.println(htmlText);
        JSONReport jsonReport = new JSONReport();
        String jsonText = jsonReport.generate("name", "body");
        System.out.println(jsonText);
    }
}
