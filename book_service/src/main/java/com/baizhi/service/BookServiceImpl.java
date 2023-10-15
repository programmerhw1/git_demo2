package com.baizhi.service;

import com.baizhi.entity.Book;
import com.baizhi.mapper.BookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookMapper mapper;

    @Override
    public Book getBookById(int bid) {
        return mapper.getBookById(bid);
    }
}
