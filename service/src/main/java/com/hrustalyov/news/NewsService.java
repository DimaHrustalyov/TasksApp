package com.hrustalyov.news;

import java.util.List;

public interface NewsService {

	News readNews(Long id);

	List<News> readAllNews();

	void saveOrUpdateNews(News news);

	void removeNews(Long id);
}
