package mx.com.percont.vanessa.chatbot;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.inject.Inject;
import mx.com.percont.vanessa.chatbot.intents.WatchMenuIntentDelegate;

public class WebhookApplication extends DialogflowApp {

    @Inject
    private WatchMenuIntentDelegate watchMenuIntentDelegate;

    @ForIntent("watch_menu")
    public ActionResponse watchMenu(ActionRequest request) {
        WatchMenuIntentDelegate intent = new WatchMenuIntentDelegate();
        return intent.getResponse(request, getResponseBuilder(request));
    }

}
