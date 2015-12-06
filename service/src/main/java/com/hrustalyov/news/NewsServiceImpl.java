package com.hrustalyov.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "newsService")
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDAO newsDAO;

	@Override
	public News readNews(Long id) {
		News news = newsDAO.selectNews(id);
		return news;
	}

	@Override
	public List<News> readAllNews() {
		List<News> newsList = newsDAO.selectAllNews();
		return newsList;
	}

	@Override
	public void saveOrUpdateNews(News news) {
		if (news.getId() == null) {
			newsDAO.insertNews(news);
		} else {
			newsDAO.updateNews(news);
		}
	}

	@Override
	public void removeNews(Long id) {
		newsDAO.deleteNews(id);
	}
}
