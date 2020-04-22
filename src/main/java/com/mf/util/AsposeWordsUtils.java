package com.mf.util;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class AsposeWordsUtils {

    /**
     * 判断是否有授权文件 如果没有则会认为是试用版，转换的文件会有水印
     *
     * @return
     */
    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = AsposeWordsUtils.class.getClassLoader().getResourceAsStream("license.xml");
            License asposeLic = new License();
            asposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Word转PDF操作
     *
     * @param sourceFile 源文件
     * @param targetFile  目标文件
     */
    public static void doc2pdf(String sourceFile, String targetFile) {
        if (!getLicense()) {// 验证License 若不验证则转化出的pdf文档会有水印产生
            return;
        }
        try {
            long old = System.currentTimeMillis();
            File file = new File(targetFile);  //新建一个空白pdf文档
            FileOutputStream os = new FileOutputStream(file);
            Document doc = new Document(sourceFile);                    //sourcerFile是将要被转化的word文档
            doc.save(os, SaveFormat.PDF);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
            os.close();
            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");  //转化用时
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void doc2pdf1(File sourceFile, OutputStream targetFile) {
//        if (!getLicense()) {// 验证License 若不验证则转化出的pdf文档会有水印产生
//            return;
//        }
//        try {
//            long old = System.currentTimeMillis();
////            File file = new File(targetFile);
//            FileOutputStream os = new FileOutputStream(sourceFile);
//            Document doc = new Document(sourceFile.getAbsolutePath());                    //sourcerFile是将要被转化的word文档
//            doc.save(os, SaveFormat.PDF);//全面支持DOC, DOCX, OOXML, RTF HTML, OpenDocument, PDF, EPUB, XPS, SWF 相互转换
//            os.close();
//            long now = System.currentTimeMillis();
//            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");  //转化用时
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
