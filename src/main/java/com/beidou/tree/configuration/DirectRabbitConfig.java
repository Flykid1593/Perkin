
package com.beidou.tree.configuration;
import org.springframework.context.annotation.Configuration;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.DirectExchange;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.amqp.core.Queue;
/**
 * @author Perkin
 * @version 1.0
 * @date 2020/7/8 0008 18:30
 */
@Configuration
public class DirectRabbitConfig {
//    @Bean
//    public Queue TestDirectQueue() {
//        //一般设置一下队列的持久化就好,其余两个就是默认false
//        return new Queue("TestDirectQueue",true);
//    }
//    //Direct交换机 起名：TestDirectExchange
//    @Bean
//    DirectExchange TestDirectExchange() {
//        //  return new DirectExchange("TestDirectExchange",true,true);
//        return new DirectExchange("TestDirectExchange",true,false);
//    }
//
//    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
//    @Bean
//    Binding bindingDirect() {
//        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");
//    }
//
//    @Bean
//    DirectExchange lonelyDirectExchange() {
//        return new DirectExchange("lonelyDirectExchange");
//    }
//
}
