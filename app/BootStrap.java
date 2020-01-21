
import play.*;
import play.jobs.*;
import play.test.*;

import models.*;

@OnApplicationStart
public class BootStrap extends Job {

    public void doJob() {
        // Check if the database is empty
        if(Client.count() == 0) {
            Fixtures.loadModels("data.yml");
            new Client("Joseph", "jzandu", "1111").save();
            new Client ("Lola","lolap","2222").save();
        }
    }

}
