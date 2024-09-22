package com.infnet.database.repository;

import com.infnet.database.model.ConversaoLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversaoLogRepository extends JpaRepository<ConversaoLog, Long> {
}
