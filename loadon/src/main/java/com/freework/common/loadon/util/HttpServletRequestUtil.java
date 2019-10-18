package com.freework.common.loadon.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author daihongru
 */
public class HttpServletRequestUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpServletRequestUtil.class);

    public static Integer getInteger(HttpServletRequest request, String key) {
        try {
            return Integer.decode(request.getParameter(key));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return -2;
        }
    }

    public static long getLong(HttpServletRequest request, String key) {
        try {
            return Long.valueOf(request.getParameter(key));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return -1;
        }
    }

    public static Double getDouble(HttpServletRequest request, String key) {
        try {
            return Double.valueOf(request.getParameter(key));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return -1d;
        }
    }

    public static boolean getBoolean(HttpServletRequest request, String key) {
        try {
            return Boolean.valueOf(request.getParameter(key));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    public static String getString(HttpServletRequest request, String key) {
        try {
            String result = request.getParameter(key);
            if (result != null) {
                result = result.trim();
            }
            if ("".equals(result)) {
                result = null;
            }
            return result;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
