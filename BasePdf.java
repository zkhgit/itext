package tom;

import java.io.File;

import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.pdf.EncryptionConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;

/**
 * 创建添加了水印并加密的基础PdfDocument
 *
 * zkh
 * 2018年3月21日 上午8:10:09
 */
public class BasePdf {

	private static PdfDocument pdf;
	
	private BasePdf() {}
	
	public static PdfDocument getBasePdf(String DEST) throws Exception {
		/**检查pdf存放路径（如果所给路径中的部分文件夹不存在，则自动创建）*/
		new File(DEST).getParentFile().mkdirs();
		/**创建加密的Pdf文档*/
		pdf = new PdfDocument(new PdfWriter(DEST, 
				new WriterProperties()
					.setStandardEncryption(
						null, // "jxjy".getBytes(),  // 用户密码 
						null, // "jxjy".getBytes(),  // 所有者（创建者）密码 
	            		EncryptionConstants.ALLOW_PRINTING, // 权限，使用用户密码打开时允许的操作
	                    EncryptionConstants.ENCRYPTION_AES_128 | EncryptionConstants.DO_NOT_ENCRYPT_METADATA // 加密等级
					)
			)
		);
		/**添加水印*/
		pdf.addEventHandler(PdfDocumentEvent.END_PAGE, new Watermark("这 就 是 一 行 水 印 文 字", 175, 705));
		pdf.addEventHandler(PdfDocumentEvent.END_PAGE, new Watermark("这 是 一 行 水 印 文 字", 440,715));
		pdf.addEventHandler(PdfDocumentEvent.END_PAGE, new Watermark("这 就 是 一 行 水 印 文 字", 175, 425));
		pdf.addEventHandler(PdfDocumentEvent.END_PAGE, new Watermark("这 是 一 行 水 印 文 字", 440,435));
		pdf.addEventHandler(PdfDocumentEvent.END_PAGE, new Watermark("这 就 是 一 行 水 印 文 字", 175, 145));
		pdf.addEventHandler(PdfDocumentEvent.END_PAGE, new Watermark("这 是 一 行 水 印 文 字", 440,155));
		return pdf;
	}
}
