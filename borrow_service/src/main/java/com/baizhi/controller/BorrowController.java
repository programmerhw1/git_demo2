package com.baizhi.controller;

import com.baizhi.dto.UserBorrowDTO;
import com.baizhi.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowController {
    @Autowired
    private BorrowService borrowService;


    //本注解可以写关于Hystrix的相关配置
    //fallbackMethod-用于指定后备方法
//    @HystrixCommand(fallbackMethod = "onError")
    @RequestMapping("/borrow/{uid}")
    public UserBorrowDTO queryUserBorrowByUid(@PathVariable Integer uid){
        return borrowService.getUserBorrowByUid(uid);
    }

    //本方法的作用是当目标方法发生异常之后，不要直接返回异常，转为执行本后备方法
    //后备方法的返回值类型和形参列表应于原始方法一致
    //把这种虽然能正常响应但服务能力下降的做法叫做服务降级
//    public UserBorrowDTO onError(Integer uid){
//        System.out.println("降级方法被执行了");
//        return new UserBorrowDTO(null, Collections.emptyList());
//    }
}
