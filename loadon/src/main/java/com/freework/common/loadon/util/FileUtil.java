package com.freework.common.loadon.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

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
}
