package com.baizhi.dto;

import com.baizhi.entity.Book;
import com.baizhi.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBorrowDTO {
    private User user;
    private List<Book> bookList;
}
