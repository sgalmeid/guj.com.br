package br.com.caelum.guj.controller;

import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import net.jforum.entities.UserSession;
import br.com.caelum.guj.dao.GUJUserDAO;
import br.com.caelum.guj.model.NewsletterParticipant;
import br.com.caelum.guj.newsletter.NewsletterSubscriber;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Resource
public class NewsletterController {

	private final GUJUserDAO dao;
	private final Result result;
	private final NewsletterSubscriber manager;
	private final HttpServletRequest request;

	public NewsletterController(GUJUserDAO dao, HttpServletRequest request, Result result, NewsletterSubscriber manager) {
		this.dao = dao;
		this.request = request;
		this.result = result;
		this.manager = manager;
	}

	@Post
	@Path(value = "/newsletter/")
	public void register(Integer gujUserId) throws URISyntaxException {
		NewsletterParticipant participant = this.dao.findParticipantByGujUserId(gujUserId);

		if (participant == null) {
			String email = this.dao.emailFromUser(gujUserId);
			NewsletterParticipant p = registerParticipant(gujUserId, email);
			manager.subscribe(p);
		}
		result.use(Results.logic()).redirectTo(HomeController.class).index();
	}

	@Post
	@Path(value = "/newsletterWithConfirmation/")
	public void register(Integer gujUserId, String email) throws URISyntaxException {
		NewsletterParticipant participant = this.dao.findParticipantByGujUserId(gujUserId);

		if (participant == null) {
			NewsletterParticipant p = registerParticipant(gujUserId, email);
			manager.subscribeWithConfirmation(p);
		}
		result.use(Results.logic()).redirectTo(HomeController.class).index();
	}

	private NewsletterParticipant registerParticipant(Integer gujUserId, String email) {
		NewsletterParticipant p = new NewsletterParticipant(gujUserId, email);

		this.dao.registerNewsletterParticipant(p);
		UserSession userSession = (UserSession) request.getAttribute("userSession");
		userSession.setNewsletterParticipant(true);
		return p;
	}

}
