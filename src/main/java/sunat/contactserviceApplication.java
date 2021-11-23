package sunat;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.hibernate.tool.schema.internal.AbstractSchemaMigrator;
import sunat.db.Contact;

public class contactserviceApplication extends Application<contactserviceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new contactserviceApplication().run(args);
    }
    private final HibernateBundle<contactserviceConfiguration> hibernateBundle =
            new HibernateBundle<contactserviceConfiguration>(Contact.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(contactserviceConfiguration contactserviceConfiguration) {
                    return contactserviceConfiguration.getDatabase();
                }
            };

    @Override
    public String getName() {
        return "contactservice";
    }

    @Override
    public void initialize(final Bootstrap<contactserviceConfiguration> bootstrap) {
        // TODO: application initialization
        bootstrap.addBundle(new MigrationsBundle<contactserviceConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(contactserviceConfiguration contactserviceConfiguration) {
                return contactserviceConfiguration.getDatabase();
            }
        });
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final contactserviceConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
