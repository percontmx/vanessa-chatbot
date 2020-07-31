import { dialogflow } from 'actions-on-google';

const agent_app = dialogflow({
    debug: true
});

agent_app.intent('webhook_intent', (e) => {
    e.add("Webhook intent response");
});

export { agent_app as chatbot_app };