import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

public class SettleUpClient {

    Client client = ClientBuilder.newClient();
    WebTarget target = client.target("http://18.216.201.147:8080/settleup/services/settleUpService/json/800/Sports/2");

    String respone = target.request(MediaType.APPLICATION_JSON).get(String.class);

}
