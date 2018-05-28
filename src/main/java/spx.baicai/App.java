package spx.baicai;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.ldap.LdapAutoConfiguration;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapAutoConfiguration;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@EnableAutoConfiguration(exclude={
        JmxAutoConfiguration.class,
        CassandraAutoConfiguration.class,
        CouchbaseAutoConfiguration.class,
        EmbeddedLdapAutoConfiguration.class,
        FreeMarkerAutoConfiguration.class,
        LdapAutoConfiguration.class,
        RabbitAutoConfiguration.class,
        SolrAutoConfiguration.class,
        DataSourceAutoConfiguration.class
})
@SpringBootApplication
@ComponentScan(basePackages = {"spx.baicai"})
public class App implements EnvironmentAware {
    protected Logger log = LoggerFactory.getLogger(this.getClass());

    private Environment env;
    @Override
    public void setEnvironment(Environment environment) {
        this.env=environment;
    }

    @Bean(name="dataSource")
    public DataSource datasource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
        ds.setUsername(env.getProperty("spring.datasource.user"));
        ds.setPassword(env.getProperty("spring.datasource.password"));
        ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        return ds;
    }


    public static void main( String[] args )
    {
        SpringApplication app = new SpringApplication(App.class);
        app.setBannerMode(Banner.Mode.OFF);//现在的版本没有setShowBanner(false)方法了
        app.run(args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            log.info(ctx.toString());
//            String[] beanNames = ctx.getBeanDefinitionNames();
        };
    }
}
