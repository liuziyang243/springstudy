package com.springtest.chapter10;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/12/1 11:58
 * @version v1.00
 */
public interface SpitterRepository extends JpaRepository<Spitter, Long> {
    Spitter findByUsername(String username);

    @Query("select a from Spitter s where s.email like '%gmail.com'")
    List<Spitter> findAllGmailSpitters();
}
