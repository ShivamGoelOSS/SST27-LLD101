public class ReportService {
    GenerateService gen = new GenerateService();
    void report(){
        gen.generate();
        System.out.println("Report contents...");
    }
}