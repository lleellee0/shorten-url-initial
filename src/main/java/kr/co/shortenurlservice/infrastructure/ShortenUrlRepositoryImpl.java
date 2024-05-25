package kr.co.shortenurlservice.infrastructure;

import kr.co.shortenurlservice.domain.ShortenUrl;
import kr.co.shortenurlservice.domain.ShortenUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShortenUrlRepositoryImpl implements ShortenUrlRepository {

    private final JpaShortenUrlRepository jpaShortenUrlRepository;

    @Autowired
    public ShortenUrlRepositoryImpl(JpaShortenUrlRepository jpaShortenUrlRepository) {
        this.jpaShortenUrlRepository = jpaShortenUrlRepository;
    }

    @Override
    public void saveShortenUrl(ShortenUrl shortenUrl) {
        jpaShortenUrlRepository.save(shortenUrl);
    }

    @Override
    public ShortenUrl findShortenUrlByShortenUrlKey(String shortenUrlKey) {
        return jpaShortenUrlRepository.findByShortenUrlKey(shortenUrlKey);
    }

}
