package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VocabRepository extends JpaRepository<Entry, Long> {

    @Query(value = "select * from entry where entry.is_active=true and (entry.failed!=0 or entry.succeeded!=0)", nativeQuery = true)
    List<Entry> findAllInUse();

    @Query(value = "select * from entry where entry.is_active=true and (entry.failed=0 and entry.succeeded=0)", nativeQuery = true)
    List<Entry> findAllNew();

}
