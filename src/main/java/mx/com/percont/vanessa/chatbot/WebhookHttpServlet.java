package mx.com.percont.vanessa.chatbot;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@WebServlet(name = "WebhookHttpServlet", value = "/webhook")
public class WebhookHttpServlet extends HttpServlet {

    private WebhookApplication app = new WebhookApplication();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonRequest = req.getReader().lines().collect(Collectors.joining());
        Map<String, String> headers = new HashMap<>();
        CompletableFuture<String> compString = app.handleRequest(jsonRequest, headers);
        try {
            resp.getWriter().write(compString.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new ServletException(e);
        }
    }
}
