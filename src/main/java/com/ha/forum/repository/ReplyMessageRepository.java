package com.ha.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ha.forum.model.Forum;
import com.ha.forum.model.ReplyMessage;

@Repository
public interface ReplyMessageRepository extends JpaRepository<ReplyMessage, Long> {

}
