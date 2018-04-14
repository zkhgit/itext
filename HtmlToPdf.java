package tom;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;

/**
 * 利用HTML代码片段生成PDF
 *
 * zkh
 * 2018年3月13日 下午2:05:17
 */
public class HtmlToPdf {

	public static void tomPdf(String html, String DEST) throws FileNotFoundException, IOException {
		ConverterProperties props = new ConverterProperties();
        DefaultFontProvider defaultFontProvider = new DefaultFontProvider(false, false, false);
        defaultFontProvider.addDirectory("src");
        props.setFontProvider(defaultFontProvider);
        HtmlConverter.convertToPdf(html, new FileOutputStream("DEST"), props);
	}
	
	public static void main(String[] args) {
		String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\"/>\n" +
                "    <title>标题</title>\n" +
                "</head>\n" +
                "<style>\n" +
                "    *{\n" +
                "        font-family: KaiTi_GB2312;\n" +
                "    }\n" +
                "</style>\n" +
                "<body>\n" +
                "    这是带有中文的html格式内容hello world! <font color=\"red\">XMLWorkerHelper</font> [这是带有中文的html格式内容]\n" +
                "</body>\n" +
                "</html>";
		String DEST = "F:\\itext\\testPdf.pdf";
		
		try {
			tomPdf(html, DEST);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
