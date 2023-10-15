package com.baizhi.config;

//@Configuration
//@LoadBalancerClient(
//        value = "USERSERVICE",   //指定客户端为谁服务
//        configuration = LoadBalancerConfig.class //使用自定的配置来开启客户端
//)
//public class TemplateConfig {
//    @Bean
//    //加入这个注解，Eureka会自动根据服务名对服务进行调用（服务发现），
//    //此外还可以自动提供负载均衡（默认是轮询机制）
//    @LoadBalanced
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }
//}
