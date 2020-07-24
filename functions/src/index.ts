import * as functions from 'firebase-functions';
import { dialogflow_app } from './dialogflow_app';

export const vanessaChatbotFunctions = functions.https.onRequest(dialogflow_app);
