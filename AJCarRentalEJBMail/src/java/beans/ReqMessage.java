/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author bumblebee
 */
//@JMSDestinationDefinition(name = "java:app/Queue", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "Queue")
//@MessageDriven(activationConfig = {
//    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:app/Queue"),
//    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
//})
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/Queue")
})
public class ReqMessage implements MessageListener {
    
    public ReqMessage() {
    }
    
    @Override
    public void onMessage(Message message) {
        System.out.println("HEEEEEEEEEEEEEEEEEEEEEEEEEEEEEJ");
    TextMessage msg = null;
        String smessage="";
        try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;
                smessage = msg.getText();
                System.out.println("\n******* RegMessage-MDB******** Message from RegQueue: Length = " + smessage.length() + "\tcontent = ******** " + smessage + "******");
                
                
                //This is where I could call my calcBean which does the calculation
                //Since I havent implemented the feature I thought I might as well comment it out for now
                //calcBean cb = new calcBean();
                //cb.calc(smessage);
                
            } else {
               System.err.println("RegMessage-MDB!!!!!! Message of wrong type: " +  message.getClass().getName());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Throwable te) {
            te.printStackTrace();
        }        
    }
    
}
