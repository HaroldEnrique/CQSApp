package cogran.pe.cqsapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestResponse {


    @SerializedName("messages")
    private List<String> messages;

    @SerializedName("result")
    private List<User> result;

    public List<User> getResult() {
        return result;
    }

    public List<String> getMessages() {
        return messages;
    }

}
