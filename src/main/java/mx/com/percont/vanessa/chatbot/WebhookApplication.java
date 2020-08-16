package mx.com.percont.vanessa.chatbot;

import com.google.gson.JsonObject;
import mx.com.percont.dialogflow.ResponseBuilder;
import mx.com.percont.dialogflow.response.Platform;
import mx.com.percont.vanessa.chatbot.intents.IntentHandler;

public class WebhookApplication {

    public JsonObject handleRequest() {
        IntentHandler handler = (builder -> {
            builder.add(Platform.FACEBOOK, "Alitas Facebook");
            builder.add("Alitas normales");
            builder.add("Tender normales");
            builder.add(Platform.FACEBOOK, "Tender Facebook");
            return builder.build();
        });
        ResponseBuilder builder = new ResponseBuilder();
        return handler.handle(builder);
    }
}
