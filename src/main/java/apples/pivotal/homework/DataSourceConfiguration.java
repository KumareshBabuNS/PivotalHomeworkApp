package apples.pivotal.homework;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration
{

    @Bean
    public Cloud cloud()
    {
        return new CloudFactory().getCloud();
    }

    @Bean
    @ConfigurationProperties(DataSourceProperties.PREFIX)
    public DataSource dataSource()
    {
        return cloud().getSingletonServiceConnector(DataSource.class, null);
    }

}
