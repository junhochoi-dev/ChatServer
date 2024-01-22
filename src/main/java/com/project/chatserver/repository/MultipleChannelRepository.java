package com.project.chatserver.repository;

import com.project.chatserver.domain.linktable.MultipleChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultipleChannelRepository extends JpaRepository<MultipleChannel, Long> {

}
