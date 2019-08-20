package com.lwc.service;

import com.lwc.dao.UserTailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTailService {
    @Autowired
    private UserTailDao userTailDao;

}
