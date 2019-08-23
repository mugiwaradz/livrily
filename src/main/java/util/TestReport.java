package util;
import java.sql.Connection;
import java.util.HashMap;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class TestReport {
	
	DB db = new DBImpl();
	
    public void PrintMession(Integer num_emp)  {
        HashMap<String, Object> hm = new HashMap<String, Object>();
        hm.put("facture_id", num_emp);
        Connection ds = db.getConnection();
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        try {
            jasperReport = JasperCompileManager.compileReport("/home/azb/Desktop/Mession.jrxml");
            jasperPrint = JasperFillManager.fillReport(jasperReport, hm, ds);
            JasperExportManager.exportReportToPdfFile(
            jasperPrint, "/home/azb/Desktop/simple_report.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}