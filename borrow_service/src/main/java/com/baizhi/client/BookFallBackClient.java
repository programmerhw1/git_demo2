package com.baizhi.client;

import com.baizhi.entity.Book;
import org.springframework.stereotype.Component;

@Component//必须作为bean，否则feign无法注入实现类
public class BookFallBackClient implements BookClient {
    @Override
    public Book findBookById(int bid) {//s实现 类中的方法就是接口方法的后备方法
        Book book = new Book();
        book.setTitle("我是备选方案");
        return book;
    }
}
