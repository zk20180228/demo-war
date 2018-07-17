package cn.ctcc.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Description: druid数据源配置
 * @Author: zhangkui
 * @CreateDate: 2018/7/13 13:58
 * @Modifier: zhangkui
 * @version: V1.0
 */
@Configuration
public class DruidDBConfig {
    private Logger logger = LoggerFactory.getLogger(DruidDBConfig.class);

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.filters}")
    private String filters;

    @Value("${spring.datasource.connectionProperties}")
    private String connectionProperties;
    /**
    # 下面为连接池的补充设置，应用到上面所有数据源中

    # 初始化大小，最小，最大

    spring.datasource.initialSize=5

    spring.datasource.minIdle=5

    spring.datasource.maxActive=20

            # 配置获取连接等待超时的时间

    spring.datasource.maxWait=60000

            # 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒

    spring.datasource.timeBetweenEvictionRunsMillis=60000

            # 配置一个连接在池中最小生存的时间，单位是毫秒

    spring.datasource.minEvictableIdleTimeMillis=300000

    spring.datasource.validationQuery=SELECT 1 FROM DUAL

    spring.datasource.testWhileIdle=true

    spring.datasource.testOnBorrow=false

    spring.datasource.testOnReturn=false

            # 打开PSCache，并且指定每个连接上PSCache的大小

    spring.datasource.poolPreparedStatements=true

    spring.datasource.maxPoolPreparedStatementPerConnectionSize=20

            # 配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙

    spring.datasource.filters=stat,wall,log4j

    # 通过connectProperties属性来打开mergeSql功能；慢SQL记录

    spring.datasource.connectionProperties=druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000

            # 合并多个DruidDataSource的监控数据

    #spring.datasource.useGlobalDataSourceStat=true

    需要注意的是：spring.datasource.type旧的spring boot版本是不能识别的。
    */
    @Bean     //声明其为Bean实例
    @Primary  //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource(){
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        //configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            logger.error("druid configuration initialization filter", e);
        }
        datasource.setConnectionProperties(connectionProperties);

        return datasource;
    }
}