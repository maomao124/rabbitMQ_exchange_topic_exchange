package mao;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import mao.tools.RabbitMQ;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * Project name(项目名称)：rabbitMQ交换机之topic交换机
 * Package(包名): mao
 * Class(类名): Producer2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/4/23
 * Time(创建时间)： 13:05
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Producer2
{
    private static final String EXCHANGE_NAME = "topic_exchange";

    public static void main(String[] args) throws IOException, TimeoutException
    {
        Channel channel = RabbitMQ.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        while (true)
        {
            channel.basicPublish(EXCHANGE_NAME,"false.true.true.false",null,"2-3收到".getBytes(StandardCharsets.UTF_8));
            channel.basicPublish(EXCHANGE_NAME,"true.true.true.false",null,"1-3收到".getBytes(StandardCharsets.UTF_8));
            channel.basicPublish(EXCHANGE_NAME,"false.true.false.true",null,"2,4收到".getBytes(StandardCharsets.UTF_8));
            channel.basicPublish(EXCHANGE_NAME,"false.true.true.true",null,"2-4收到".getBytes(StandardCharsets.UTF_8));
            channel.basicPublish(EXCHANGE_NAME,"true.true.true.true",null,"1-4收到".getBytes(StandardCharsets.UTF_8));
        }

    }
}
