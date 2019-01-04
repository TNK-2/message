package com.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

}
