package com.example.springfinalproject.Services;
import com.example.springfinalproject.Entity.Ticket;
import com.example.springfinalproject.Entity.Train;
import com.example.springfinalproject.Entity.User;
import com.example.springfinalproject.Utility.TrainUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ResourceBundle;


@Component
    public class EmailService {

        @Autowired
        private JavaMailSender emailSender;
        @Autowired
        UtilityService utilityService;

        public void sendSimpleMessage(
                String to, String subject, String text) {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("TrainEmailer@gmail.com");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);
            emailSender.send(message);

        }
    public void sendSimpleMessage(
            String[] to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("TrainEmailer@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }
    public void sendMessageAboutCanceling(String [] recipients,Train train, HttpServletRequest request){
        ResourceBundle bundle = utilityService.getLocaleBundle(request);
        StringBuilder message= new StringBuilder();
        message.append(bundle.getString("SorryTrain"));
        message.append(TrainUtility.fromTo(train)).append(TrainUtility.dateToString(train.getAgenda().get(0))).append(bundle.getString("CostWasReturned"));
        sendSimpleMessage(recipients,bundle.getString("TrainCanceled"),message.toString());
    }

     public void sendMessageAboutTicketBuying(Train train, User user, HttpServletRequest request){
        ResourceBundle bundle = utilityService.getLocaleBundle(request);
            StringBuilder message= new StringBuilder();
            message.append(bundle.getString("Hello"));
            message.append(user.getName()).append(",");
            message.append(bundle.getString("youJustBooked"));
            message.append(TrainUtility.fromTo(train)).append(". ");
            message.append(bundle.getString("HeIsComingOn"));
            message.append(bundle.getString("YouWatchSchedule"));
            sendSimpleMessage(user.getEmail(),bundle.getString("TicketBought"),message.toString());
        }

}
