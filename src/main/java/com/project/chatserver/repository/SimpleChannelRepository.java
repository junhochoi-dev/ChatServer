package com.project.chatserver.repository;

import com.project.chatserver.domain.linktable.SimpleChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleChannelRepository extends JpaRepository<SimpleChannel, Long> {

}
