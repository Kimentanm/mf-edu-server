package com.mf.util;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;
import com.aspose.words.SaveOutputParameters;

import java.io.*;

/**
 * @Author Kimen
 * @Date 2020/3/30 - 10:01 下午
 */
public class PdfUtil {

    //word文档转PDF，同时删除word文档
    public static SaveOutputParameters doc2pdf(InputStream inputStream, OutputStream outputStream) {
        if (!getLicense()) { // 验证License 若不验证则转化出的pdf文档会有水印产生
            return null;
        }
        try {
            long old = System.currentTimeMillis();
            Document doc = new Document(inputStream); // Address是将要被转化的word文档
            SaveOutputParameters sop = doc.save(outputStream, SaveFormat.PDF);// 全面支持DOC,
            // DOCX, OOXML, RTF HTML, OpenDocument, PDF,
            // EPUB, XPS, SWF 相互转换
            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒"); // 转化用时
            return sop;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //word转PDF时验证License去除水印
    public static boolean getLicense() {
        boolean result = false;
        try {
            String s = "<License><Data><Products><Product>Aspose.Total for Java</Product><Product>Aspose.Words for Java</Product></Products><EditionType>Enterprise</EditionType><SubscriptionExpiry>20991231</SubscriptionExpiry><LicenseExpiry>20991231</LicenseExpiry><SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber></Data><Signature>sNLLKGMUdF0r8O1kKilWAGdgfs2BvJb/2Xp8p5iuDVfZXmhppo+d0Ran1P9TKdjV4ABwAgKXxJ3jcQTqE/2IRfqwnPf8itN8aFZlV3TJPYeD3yWE7IT55Gz6EijUpC7aKeoohTb4w2fpox58wWoF3SNp6sK6jDfiAUGEHYJ9pjU=</Signature></License>";
            ByteArrayInputStream is = new ByteArrayInputStream(s.getBytes());
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
