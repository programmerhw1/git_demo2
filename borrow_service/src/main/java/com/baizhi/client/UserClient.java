package com.baizhi.client;

import com.baizhi.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//用这个client去和user模块做交互
//标明本接口是一个Http请求客户端
@FeignClient("userservice")
public interface UserClient {

    //在本接口中直接定义访问其他微服务的方法
    //访问路径和返回值及参数和其他微服务的方法一致即可
    @RequestMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid") int uid);
}
