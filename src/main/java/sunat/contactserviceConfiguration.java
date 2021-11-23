package sunat;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class contactserviceConfiguration extends Configuration {
    // TODO: implement service configuration
    private DataSourceFactory database = new DataSourceFactory();

    @JsonProperty("database")
    public DataSourceFactory getDatabase(){
        return database;
    }
    @JsonProperty("database")
    public void setDatabase(DataSourceFactory database){
        this.database = database;
    }
}
