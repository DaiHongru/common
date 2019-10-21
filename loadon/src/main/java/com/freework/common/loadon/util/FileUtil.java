package com.freework.common.loadon.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author daihongru
 */
public class FileUtil {
    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 获取文件的扩展名
     *
     * @param fileName
     * @return
     */
    public static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 如果Path是文件路径则删除该文件，
     * 如果Path是目录路径则删除该目录下的所有文件
     *
     * @param path
     */
    public static void deleteFileOrPath(String path) {
        File fileOrPath = new File(PathUtil.getBasePath() + path);
        if (fileOrPath.exists()) {
            if (fileOrPath.isDirectory()) {
                File files[] = fileOrPath.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }
        logger.info("删除文件或目录：" + path);
    }

    /**
     * 创建目标路径所涉及到的目录
     *
     * @param targetAddr
     */
    public static void mkdirPath(String targetAddr) {
        File dirPath = new File(PathUtil.getBasePath() + targetAddr);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
            logger.info("创建目录：" + targetAddr);
        }
    }

    /**
     * 拷贝文件
     *
     * @param srcPath
     * @param targetPath
     * @throws RuntimeException
     */
    public static void copyFile(String srcPath, String targetPath) throws RuntimeException {
        File srcFile = new File(PathUtil.getBasePath() + srcPath);
        File targetFile = new File(PathUtil.getBasePath() + targetPath);
        if (!srcFile.exists()) {
            throw new RuntimeException("源文件不存在！");
        }
        if (!srcFile.isFile()) {
            throw new RuntimeException("源文件不是文件！");
        }
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(srcFile);
            out = new FileOutputStream(targetFile);
            byte[] buf = new byte[8 * 1024];
            int len = 0;
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
                out.flush();
            }
            logger.info("拷贝文件：[" + srcPath + "]到[" + targetPath + "]");
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                System.out.println("关闭输入流错误！");
            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                System.out.println("关闭输出流错误！");
            }
        }
    }
}
