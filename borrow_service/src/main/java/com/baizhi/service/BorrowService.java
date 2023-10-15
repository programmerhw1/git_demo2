package com.baizhi.service;

import com.baizhi.dto.UserBorrowDTO;

public interface BorrowService {
    UserBorrowDTO getUserBorrowByUid(Integer uid);
}
