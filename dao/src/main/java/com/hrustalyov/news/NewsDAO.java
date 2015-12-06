package com.hrustalyov.news;

import java.util.List;

public interface NewsDAO {

	News selectNews(Long id);

	List<News> selectAllNews();

	void insertNews(News news);

	void updateNews(News news);

	void deleteNews(Long id);
}
