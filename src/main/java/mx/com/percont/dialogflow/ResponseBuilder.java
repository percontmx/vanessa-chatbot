package mx.com.percont.dialogflow;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import mx.com.percont.dialogflow.response.Platform;
import mx.com.percont.dialogflow.response.TextResponse;

import java.util.LinkedList;
import java.util.List;

public class ResponseBuilder {

    private final List<TextResponse> responses;

    public ResponseBuilder(){
        this.responses = new LinkedList<>();
    }

    /**
     *
     * @param platform
     * @param text
     * @return
     */
    public ResponseBuilder add(Platform platform, String text) {
        this.responses.add(new TextResponse(platform, text));
        return this;
    }

    public ResponseBuilder add(String text){
        return this.add(Platform.UNSPECIFIED, text);
    }

    public JsonObject build(){
        JsonObject fullfillmentObject = new JsonObject();
        JsonArray messages = new JsonArray();

        responses.stream().map((response) -> {
            JsonObject generated = new JsonObject();
            Platform platform = response.getPlatform();
            List<String> texts = response.getTexts();

            if (platform != Platform.UNSPECIFIED){
                generated.addProperty("platform", platform.name());
            }

            JsonObject textObject = new JsonObject();
            JsonArray array = new JsonArray();
            if (texts.isEmpty()){
                array.add("");
            } else {
                texts.forEach((text) -> {
                    array.add(text);
                });
            }

            textObject.add("text", array);
            generated.add("text", textObject);
            return generated;
        }).forEach(jsonObject -> messages.add(jsonObject));

        fullfillmentObject.add("fulfillmentMessages", messages);
        return fullfillmentObject;
    }
}
