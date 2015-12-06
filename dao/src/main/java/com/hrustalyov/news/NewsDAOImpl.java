package com.hrustalyov.news;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsDAOImpl implements NewsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public News selectNews(Long id) {
		Session session = getCurrentSession();
		Transaction trans = session.beginTransaction();
		News news = (News) session.get(News.class, id);
		trans.commit();
		return news;
	}

	@Override
	public List<News> selectAllNews() {
		Session session = getCurrentSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from News");
		List<News> newsList = (List<News>) query.list();
		trans.commit();
		return newsList;
	}

	@Override
	public void insertNews(News news) {
		Session session = getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.saveOrUpdate(news);
		trans.commit();
	}

	@Override
	public void updateNews(News news) {
		Session session = getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.saveOrUpdate(news);
		trans.commit();
	}

	@Override
	public void deleteNews(Long id) {
		Session session = getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.delete(session.get(News.class, id));
		trans.commit();
	}
}
