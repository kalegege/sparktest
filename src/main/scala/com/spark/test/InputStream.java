package com.spark.test;

import info.monitorenter.cpdetector.io.ASCIIDetector;
import info.monitorenter.cpdetector.io.ByteOrderMarkDetector;
import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.JChardetFacade;
import info.monitorenter.cpdetector.io.ParsingDetector;
import info.monitorenter.cpdetector.io.UnicodeDetector;

import java.io.*;
import java.nio.charset.Charset;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Administrator on 2017/7/23.
 */
public class InputStream {
    private static String kISOEncoding = "ISO-8859-1";
    private static String kGBKEncoding = "GBK";
    private static String kUTF8Encoding = "UTF-8";

    public static void main(String[] args) throws UnsupportedEncodingException {
//        write("帅哥是的我名字|1000|kalegege");
//        read();
        System.out.println("系统默认编码：    "+System.getProperty("file.encoding"));
//        System.out.println(getLocalFileEncode(new File("e:\\test\\c.txt")));

//        try {
//            File out_file = new File("e:\\test\\c.txt");
//            Writer out = new BufferedWriter(new OutputStreamWriter(
//                    new FileOutputStream(out_file), kUTF8Encoding));
//            List<String> lines = Files.readAllLines(Paths.get(args[0]), Charset.forName(kISOEncoding));
//            for (String line : lines) {
//                String gbk_str = new String(line.getBytes(kISOEncoding), kGBKEncoding);
//                out.append(gbk_str).append("\n");
//            }
//            out.flush();
//            out.close();
//        } catch (IOException e) {
//            System.out.println(e);
//        }
    }

    public static void write(String message){
        File outFile=new File("e:\\test\\c.txt");
        BufferedWriter bf;
        try {
           bf=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
            String gbk_str = new String(message.getBytes(), kGBKEncoding);
            bf.append(gbk_str).append("\n");
            bf.flush();
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void read(){
        File outFile=new File("e:\\test\\c.txt");
        BufferedReader br;
        char[] tmpBytes=new char[1024];
        int byteread=0;
        try {
            br=new BufferedReader(new InputStreamReader(new FileInputStream(outFile),kISOEncoding));
            while((byteread = br.read(tmpBytes))!= -1){
                String tmp=new String(tmpBytes,0,byteread);
                System.out.println(new String(tmp.getBytes()));
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取本地文件的编码格式
     *
     * @param file 要判断的文件编码格式
     *
     * @author 高焕杰
     */
//    public static String getLocalFileEncode(File localFile) {
//
//        /*
//         * cpDetector是探测器，它把探测任务交给具体的探测实现类的实例完成。
//         * cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法 加进来，如ParsingDetector、ByteOrderMarkDetector、JChardetFacade、ASCIIDetector、UnicodeDetector。
//         * cpDetector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的字符集编码。cpDetector是基于统计学原理的，不保证完全正确。
//         */
//        CodepageDetectorProxy codepageDetector = CodepageDetectorProxy.getInstance();
//        codepageDetector.add(new ParsingDetector(false));//ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于指示是否显示探测过程的详细信息，为false不显示。
//        codepageDetector.add(JChardetFacade.getInstance());//JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码 测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。
//        codepageDetector.add(new ByteOrderMarkDetector());
//        codepageDetector.add(ASCIIDetector.getInstance());//ASCIIDetector用于ASCII编码测定
//        codepageDetector.add(UnicodeDetector.getInstance());//UnicodeDetector用于Unicode家族编码的测定
//        Charset charset = null;
//        try {
//            charset = codepageDetector.detectCodepage(localFile.toURI().toURL());
//            if (charset != null){
//                return charset.name();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}
