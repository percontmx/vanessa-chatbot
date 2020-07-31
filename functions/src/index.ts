import * as functions from 'firebase-functions';
import { chatbot_app } from './dialogflow_app';

export const vanessaChatbotFunctions = functions.https.onRequest(chatbot_app);
