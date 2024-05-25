package kr.co.shortenurlservice.infrastructure;

import kr.co.shortenurlservice.domain.ShortenUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaShortenUrlRepository extends JpaRepository<ShortenUrl, Long> {
    ShortenUrl findByShortenUrlKey(String shortenUrlKey);
}