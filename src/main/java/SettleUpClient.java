import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.settleup.client.JSONResult;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

public class SettleUpClient {

    public List<JSONResult> getJSONRestuls(int rent, String activity, int numberBedrooms) throws Exception {
        Client client = ClientBuilder.newClient();
        String targetUrl = "http://18.216.201.147:8080/settleup/services/settleUpService/json/" + rent + "/" + activity + "/" + numberBedrooms;
        WebTarget target = client.target(targetUrl);

        String respone = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        List<JSONResult> results = mapper.readValue(respone, new TypeReference<List<JSONResult>>() {
        });

        return results;
    }

}
