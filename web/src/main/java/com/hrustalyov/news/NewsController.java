package com.hrustalyov.news;

import com.hrustalyov.utils.json.factory.JsonBuilderFactory;
import com.hrustalyov.utils.loader.CustomClassLoader;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = {"/admin/news"})
public class NewsController {
	private final static Logger LOGGER = Logger.getLogger(NewsController.class);

	@Autowired
	private NewsService newsService;
	//@Autowired
	//private JsonBuilderFactory builderFactory;
	@Autowired
	private CustomClassLoader loader;
	@Autowired
	private ServletContext servletContext;

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

		try (FileWriter writer = new FileWriter(servletContext.getRealPath("/WEB-INF/json/news.json"))) {

			for (News news : newsList) {
				long id = news.getId();
				String title = news.getTitle();
				String brief = news.getBrief();
				String description = news.getDescription();

				/*String jsonNews = builderFactory.createJsonBuilder()
						.add("news", builderFactory.createJsonBuilder()
								.add("metadata", builderFactory.createJsonBuilder()
										.add("date", new Date().toString()))
								.add("id", id)
								.add("title", title)
								.add("brief", brief)
								.add("description", description))
						.build();*/

				String jsonNews = loader.getLoadedBuilderFactory().createJsonBuilder()
						.add("news", loader.getLoadedBuilderFactory().createJsonBuilder()
								.add("metadata", loader.getLoadedBuilderFactory().createJsonBuilder()
										.add("date", new Date().toString()))
								.add("id", id)
								.add("title", title)
								.add("brief", brief)
								.add("description", description))
						.build();

				writer.write(jsonNews);
				writer.write('\n');
			}
		}

		return "news.json";
	}
}
