'use scrict'

const functions = require('firebase-functions')
const { WebhookClient } = require('dialogflow-fulfillment')

exports.vanessa_chatbot_functions = functions.https.onRequest((request, response) => {
    const agent = new WebhookClient({ request, response })
    let intent = new Map()
    agent.handleRequest(intent)  
})