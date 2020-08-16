package mx.com.percont.vanessa.chatbot;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WebhookHttpServlet", value = "/webhook")
public class WebhookHttpServlet extends HttpServlet {

    private final WebhookApplication app = new WebhookApplication();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Gson gson = new Gson();
        JsonObject response = app.handleRequest();
        String responseData = gson.toJson(response);
        resp.getWriter().write(responseData);
        resp.setStatus(200);
        resp.setHeader("Content-type", "application/json");
    }
}
