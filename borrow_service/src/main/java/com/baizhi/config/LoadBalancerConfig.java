package com.baizhi.config;

//public class LoadBalancerConfig {
//    //最终需要的是RandomLoadBalancer，所以构建客户端时将数据直接给RandomLoadBalancer
//    //需要serviceId
//    //要将返回值的randomLoadBalancer注册一个bean
//    @Bean
//    public ReactiveLoadBalancer<ServiceInstance> randomLoadBalancer(
//            Environment environment,
//            LoadBalancerClientFactory factory){
//        //根据.PROPERTY_NAME（loadbalancer.client.name）去运行环境中获取当前的服务名
//        String serverId = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//        System.out.println(serverId);
//        RandomLoadBalancer randomLoadBalancer =
//                new RandomLoadBalancer(factory.getLazyProvider(serverId, ServiceInstanceListSupplier.class),
//                        serverId);
//        return randomLoadBalancer;
//    }
//}
