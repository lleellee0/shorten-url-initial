package kr.co.shortenurlservice.domain;

import jakarta.persistence.*;
import java.util.Random;

@Entity
public class ShortenUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false)
    private String originalUrl;

    @Column(nullable = false, unique = true)
    private String shortenUrlKey;

    @Column(nullable = false)
    private Long redirectCount;

    protected ShortenUrl() {
        // JPA를 위한 기본 생성자
    }

    public ShortenUrl(String originalUrl, String shortenUrlKey) {
        this.originalUrl = originalUrl;
        this.shortenUrlKey = shortenUrlKey;
        this.redirectCount = 0L;
    }

    public Long getId() {
        return id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortenUrlKey() {
        return shortenUrlKey;
    }

    public void setShortenUrlKey(String shortenUrlKey) {
        this.shortenUrlKey = shortenUrlKey;
    }

    public Long getRedirectCount() {
        return redirectCount;
    }

    public void setRedirectCount(Long redirectCount) {
        this.redirectCount = redirectCount;
    }

    public void increaseRedirectCount() {
        this.redirectCount = this.redirectCount + 1;
    }

    public static String generateShortenUrlKey() {
        String base56Characters = "23456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz";
        Random random = new Random();
        StringBuilder shortenUrlKey = new StringBuilder();

        for (int count = 0; count < 8; count++) {
            int base56CharactersIndex = random.nextInt(base56Characters.length());
            char base56Character = base56Characters.charAt(base56CharactersIndex);
            shortenUrlKey.append(base56Character);
        }

        return shortenUrlKey.toString();
    }
}
