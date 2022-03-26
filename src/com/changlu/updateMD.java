package com.changlu;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * 效果：将源目录所有md文件内容中tihuan配置内容替换为tihuanTO内容，最终输出到指定路径。
 * 配置说明：
 *   COPY_ORIGN：源目录
 *   COPY_ORIGN：目标输出目录(可填自己源目录)
 *   tihuan：被替换内容
 *   tihuanTO：替换内容
 *
 * 说明：想要将md文件中的1替换为2，那么被替换内容就是1、替换内容就是2
 *
 * @ClassName updateMD
 * @Author ChangLu
 * @Date 3/26/2022 11:42 AM
 * @Description TODO
 */
public class updateMD {

    private static Logger log = Logger.getLogger("com.changlu.updateMD");

    //源目录
    private static String COPY_ORIGN = "C:\\Users\\93997\\Desktop\\test2";
    //目标目录
    private static String COPY_TO = "C:\\Users\\93997\\Desktop\\test2";
//    private static String tihuan = "https://pictured-bed.oss-cn-beijing.aliyuncs.com/img/beifen-gitee/";
    private static String tihuan = "https://gitee.com/changluJava/picture-bed/raw/master/";
    //替换内容
//    private static String tihuanTO = "https://gitee.com/changluJava/picture-bed/raw/master/";
    private static String tihuanTO = "https://pictured-bed.oss-cn-beijing.aliyuncs.com/img/beifen-gitee/";

 
    public static void main(String[] args) throws Exception{
        Files.walk(Paths.get(COPY_ORIGN)).forEach(path->{
            String originFile = path.toFile().getAbsolutePath();
            String targetFile = path.toFile().getAbsolutePath().replace(COPY_ORIGN, COPY_TO);
            try {
                //若是文件目录，则创建目标目录
                if (Files.isDirectory(path)) {
                    //判断是否存在，不存在则创建
                    if (!new File(targetFile).exists()) {
                        Files.createDirectory(Paths.get(targetFile));
                    }
                }else{
                    //System.out.println("原路径：" + path.toFile().getAbsolutePath() + "  ，目标路径：" + copyFileName);
                    if (targetFile.contains(".md")){
//                        doWork(originFile, targetFile, tihuanTO, tihuan);
                        doWork(originFile, targetFile, tihuan, tihuanTO);
                        System.out.println(targetFile + "已经覆盖完成!");
                    }else{
                        Files.copy(path, Paths.get(targetFile));
                    }
                }
            }catch (Exception e){
                if (e instanceof FileAlreadyExistsException){
                    log.info("目标文件:" + targetFile + " 已经存在");
                }else{
                    e.printStackTrace();
                }
            }
        });
        System.out.println("所有的文件已全部替换！");
    }

    private static void doWork(String originFile,String targetFile,String tihuan,String tihuanTO) throws IOException {
        //读取一个文件，获取到内容
//        String content = readFile("C:\\Users\\93997\\Desktop\\test\\IDEA运行web项目(非maven).md");
        String content = readFile(originFile);
        //将内容中的文字进行替换
        String newContent = content.replaceAll(tihuan, tihuanTO);
        //写入到指定的目录
//        writeFile(newContent, "C:\\Users\\93997\\Desktop\\test1\\IDEA运行web项目(非maven).md");
        writeFile(newContent, targetFile);
    }

    private static void writeFile(String newContent,String targetFile) throws IOException {
        File file = new File(targetFile);
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        osw.write(newContent);
        osw.flush();
    }

    private static String readFile(String originFile) throws IOException {
        FileInputStream fis = new FileInputStream(originFile);
        final InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(isr);
        String content = "";
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            content += line + "\r\n";
        }
        return content;
    }

}