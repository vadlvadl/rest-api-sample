import java.util.List;
import java.util.Map;

public class SessionClass {

    public String name;

    public String sessionID;


    public void setSession(Map<String,String> session) {
        this.name = session.get("name");
        this.sessionID = session.get("value");
    }

    public String getSessionID() {
        return sessionID;
    }
}
