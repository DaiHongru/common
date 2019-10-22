package com.freework.common.loadon.util;

/**
 * @author daihongru
 */
public class PathUtil {
    private static String seperator = System.getProperty("file.separator");

    private final static String WIN_PATH = "D:/freework/data";

    private final static String MAC_PATH = "/Users/daihongru/workspaces/freework/data";

    private final static String LINUX_PATH = "/home/admin/freework/data";

    private final static String ENTERPRISE_LOGO_PATH = "/image/logo/";

    private final static String USER_PORTRAIT_PATH = "/image/portrait/";

    private final static String CVITAE_PATH = "/document/cvitae/user/";

    private final static String ENTERPRISE_CVITAE_PATH = "/document/cvitae/enterprise/";

    public static String getBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        String winTag = "win";
        String macTag = "mac";
        if (os.toLowerCase().startsWith(macTag)) {
            basePath = MAC_PATH;
        } else if (os.toLowerCase().startsWith(winTag)) {
            basePath = WIN_PATH;
        } else {
            basePath = LINUX_PATH;
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }

    public static String getEnterpriseLogoPath(Integer enterpriseId) {
        String logoPath = ENTERPRISE_LOGO_PATH + enterpriseId + seperator;
        return logoPath.replace("/", seperator);
    }

    public static String getUserPortraitPath(Integer userId) {
        String portraitPath = USER_PORTRAIT_PATH + userId + seperator;
        return portraitPath.replace("/", seperator);
    }

    public static String getCvitaePath(Integer userId) {
        String cvitaePath = CVITAE_PATH + userId + seperator;
        return cvitaePath.replace("/", seperator);
    }

    public static String getEnterpriseCvitaePath(Integer enterpriseId, Integer vocationId, Integer userId) {
        String enterpriseCvitaePath = ENTERPRISE_CVITAE_PATH + enterpriseId + seperator + vocationId + seperator + userId + seperator;
        return enterpriseCvitaePath.replace("/", seperator);
    }
}
