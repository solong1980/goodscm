package springboot;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;

public class ActiveMqConfig {
	@Bean
    public Topic goodsAddTopic(){
        return new ActiveMQTopic("goodsAddTopic");
    }

    @Bean
    public Queue queue(){
        return new ActiveMQQueue("queue");
    }
}
