package hello.second.repository;

import hello.second.domain.Mvc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MvcRepository extends JpaRepository<Mvc, Long> {

    //사용자아이디로 조회하는 기능을 추가

}