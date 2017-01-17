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
import JavaClasses.SendEmail;

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
                //
                //System.out.println(InfoArr[2] + "Funkar det?");
                String s = smessage;
                String[] InfoArr = s.split("/");
                String mail = InfoArr[2];
                String body = "Hi " + InfoArr[0] + ". Your order was successfull. You can pick up your car at " + InfoArr[9] + " on " + InfoArr[6] + ". Details: "
                        + "Car model: " + InfoArr[11] + ", Price: " + InfoArr[5] + ", Order confirmed at: " + InfoArr[6] + ", start date: " + InfoArr[7] + ", return date: " + InfoArr[8]
                        + ", location of pick up: " + InfoArr[9] + ", return location: " + InfoArr[10];
                System.out.println(mail);
                System.out.println(body);
                SendEmail SE = new SendEmail();
                SE.SendEmail(mail, body);
                
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
