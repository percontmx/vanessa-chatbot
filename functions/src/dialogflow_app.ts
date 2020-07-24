import { dialogflow } from 'actions-on-google';

const agent_app = dialogflow({
    debug: true
});

agent_app.intent('webhook_intent', (e) => {
    e.add("tu reputa madre");
});

export { agent_app as dialogflow_app };