package com.spl.javabot.repository;

import com.spl.javabot.entity.GroupSub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupSubRepository extends JpaRepository<GroupSub, Integer> {
    List<GroupSub> findAll();
}
