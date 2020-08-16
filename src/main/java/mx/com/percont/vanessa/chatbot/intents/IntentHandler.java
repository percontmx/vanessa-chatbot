package mx.com.percont.vanessa.chatbot.intents;

import com.google.gson.JsonObject;
import mx.com.percont.dialogflow.ResponseBuilder;

@FunctionalInterface
public interface IntentHandler {

    JsonObject handle(ResponseBuilder responseBuilder);
}
