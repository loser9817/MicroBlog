package com.loser.dao;

import com.loser.entity.BlogContent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Contentdao {

    BlogContent queryContentById(int id);
}
