package com.hrustalyov.news;

import com.hrustalyov.utils.builder.JsonBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = {"/admin/news"})
public class NewsController {
	private final static Logger LOGGER = Logger.getLogger(News.class);

	@Autowired
	private NewsService newsService;

	@RequestMapping(value = {"/list"}, method = RequestMethod.GET)
	public String list(ModelMap modelMap) {
		NewsForm newsForm = new NewsForm();
		List<News> newsList = newsService.readAllNews();
		newsForm.setNewsList(newsList);
		modelMap.addAttribute("newsForm", newsForm);
		return "news.list";
	}

	@RequestMapping(value = {"/edit"}, method = RequestMethod.GET)
	public String edit(Long id, ModelMap modelMap) {
		News news = newsService.readNews(id);
		modelMap.addAttribute("news", news);
		return "news.edit";
	}

	@RequestMapping(value = {"/save"}, method = RequestMethod.POST)
	public String save(@ModelAttribute("news") News news) {
		newsService.saveOrUpdateNews(news);
		return "redirect:/admin/news/list";
	}

	@RequestMapping(value = {"/add"}, method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		News news = new News();


		modelMap.addAttribute("news", news);
		return "news.edit";
	}

	@RequestMapping(value = {"/delete"}, method = RequestMethod.GET)
	public String delete(Long id) {
		newsService.removeNews(id);
		return "redirect:/admin/news/list";
	}

	@RequestMapping(value = {"/json"}, method = RequestMethod.GET)
	public String createJson() throws IOException {

		List<News> newsList = newsService.readAllNews();

		try (FileWriter writer = new FileWriter("news.json")) {

			for (News news : newsList) {
				String id = news.getId().toString();
				String title = news.getTitle();
				String brief = news.getBrief();
				String description = news.getDescription();

				String jsonNews = new JsonBuilder()
						.add("id", id)
						.add("title", title)
						.add("brief", brief)
						.add("description", description)
						.build();

				writer.write(jsonNews);
				writer.write('\n');
			}
		}

		return "news.json";
	}
}
