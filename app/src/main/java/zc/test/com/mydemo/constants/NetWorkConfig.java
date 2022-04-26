package zc.test.com.mydemo.constants;

public final class NetWorkConfig {
    public static String HOST_URL = "http://ht.tyzkf8.com";
    public static String BASE_URL = HOST_URL+"/api";

    //首页数据
    public static final String CONFIG_GETCONFIGDATA=BASE_URL+"/config/getConfigData";

    //列表数据
    public static final String ARTICLE_INFO=BASE_URL+"/article/getArticleInfo";
    //图形验证码
    public static final String VERIFY=BASE_URL+"/common/verify";

    public static final String SHUIXI_LOGIN="http://sx.wateryun.com.cn:3403/cs_y/login/loginAP";


    //嵌套网页地址
    public static final String SHUIXI_QTURL="http://192.168.1.102:8080";

    //
    public static final String CREATE_GETAPP="https://sx.water-mind.com/cs_s/applyModule/findOne";
}
