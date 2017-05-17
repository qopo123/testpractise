package com.ych.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.concurrent.TimeoutException;

public class Send {
  private final static String QUEUE_NAME = "hello";

  public static void main(String[] args) throws java.io.IOException, TimeoutException {
    ConnectionFactory cf = new ConnectionFactory();
    cf.setHost("localhost");
    cf.setPort(5672);
    Connection connection = cf.newConnection();
    Channel channel = connection.createChannel();
    channel.queueDeclare(QUEUE_NAME, false, false, false, null);

    String message = "hello world";
    channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

    channel.close();
    connection.close();

  }
}
