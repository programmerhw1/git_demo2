package com.baizhi.service;

import com.baizhi.client.BookClient;
import com.baizhi.client.UserClient;
import com.baizhi.dto.UserBorrowDTO;
import com.baizhi.entity.Book;
import com.baizhi.entity.Borrow;
import com.baizhi.entity.User;
import com.baizhi.mapper.BorrowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowMapper borrowMapper;
//    @Autowired
//    private RestTemplate restTemplate;//自动注入已经加入@LoadBalanced注解的restTemplate
    @Autowired
    private UserClient userClient;
    @Autowired
    private BookClient bookClient;

    @Override
    public UserBorrowDTO getUserBorrowByUid(Integer uid) {
        System.out.println("原始方法被执行了");
        //borrowList中仅包含了基础的id信息，没有具体信息
        List<Borrow> borrowList = borrowMapper.getBorrowsByUid(uid);
        //进一步根据查询结果去调用user以及book模块中的对应查询方法
        //使用RestTemplate进行远程服务调用
//        RestTemplate restTemplate = new RestTemplate();
        /*
            getForObject会调用其他服务中的方法，并返回对象形式的结果
            参数1：目标方法所在服务的请求路径(将各微服务注册到eureka之后，就可以使用服务名代替ip地址，实现进一步解耦)
            参数2：想要的返回值的类型的类对象
         */
//        User user = restTemplate.getForObject("http://userservice/user/" + uid, User.class);
        User user = userClient.findUserById(uid);
        //获取book的信息，borrowList中可能包含多个bid
        ArrayList<Book> books = new ArrayList<>();
        for (Borrow borrow:borrowList){
//            Book book = restTemplate.getForObject("http://bookservice/book/" + borrow.getBid(), Book.class);
            Book book = bookClient.findBookById(borrow.getBid());
            books.add(book);
        }
        //将当前用户数据以及书籍数据返回
        UserBorrowDTO userBorrowDTO = new UserBorrowDTO();
        userBorrowDTO.setUser(user);
        userBorrowDTO.setBookList(books);
        return userBorrowDTO;
    }
}
