package mx.com.percont.vanessa.chatbot.intents;

import com.google.actions.api.ActionResponse;
import com.google.actions.api.response.ResponseBuilder;
import com.google.api.services.actions_fulfillment.v2.model.BasicCard;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WatchMenuIntent {

    private final String fileData;

    public WatchMenuIntent() {
        InputStream istream =
                this.getClass().getResourceAsStream("/mx/com/percont/vanessa/chatbot/intents/dummy_menu_data.json");
        InputStreamReader isr = new InputStreamReader(istream);
        BufferedReader r = new BufferedReader(isr);
        this.fileData = r.lines().collect(Collectors.joining());
    }

    public ActionResponse getResponse(ResponseBuilder responseBuilder) {
        Product[] products = new Gson().fromJson(fileData, Product[].class);
        responseBuilder.add("Éste es el menú:");
        Arrays.asList(products).stream().map(p -> {
            BasicCard c = new BasicCard();
            c.setTitle(p.getTitle());
            c.setSubtitle(p.getSubtitle());
            return c;
        }).forEach(c -> {
            responseBuilder.add(c);
        });
        return responseBuilder.build();
    }

    public static class Product {
        private String title;
        private String subtitle;


        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
