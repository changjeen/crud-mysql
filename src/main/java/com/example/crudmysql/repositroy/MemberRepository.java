package com.example.crudmysql.repositroy;

import com.example.crudmysql.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
