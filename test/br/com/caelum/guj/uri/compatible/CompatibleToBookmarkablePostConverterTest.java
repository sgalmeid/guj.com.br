package br.com.caelum.guj.uri.compatible;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import net.jforum.entities.Topic;

import org.junit.Test;

import br.com.caelum.guj.repositories.TopicRepository;
import br.com.caelum.guj.view.Slugger;

public class CompatibleToBookmarkablePostConverterTest {

	@Test
	public void shouldIdentifyCompatibleURIs() {
		CompatibleToBookmarkablePostConverter converter = new CompatibleToBookmarkablePostConverter(
				"/guj.com.br/posts/list/1.java", this.aRepository(), new Slugger());

		assertTrue(converter.isConvertable());

		converter = new CompatibleToBookmarkablePostConverter(
				"/recentTopics/list.java", this.aRepository(), new Slugger());

		assertFalse(converter.isConvertable());
	}

	@Test
	public void shouldIdentifyPaginatedURIs() {
		TopicRepository repository = this.aRepository();
		Topic topic = new Topic();
		topic.setTitle("erich created jforum");
		when(repository.getById(20)).thenReturn(topic);

		CompatibleToBookmarkablePostConverter converter = new CompatibleToBookmarkablePostConverter(
				"/posts/list/45/20.java", repository, new Slugger());

		assertEquals("/java/20-erich-created-jforum/4", converter.convert());

	}

	@Test
	public void shouldGenerateTheBookmarkableUrl() {
		TopicRepository repository = this.aRepository();
		Topic topic = new Topic();
		topic.setTitle("erich created jforum");

		when(repository.getById(20)).thenReturn(topic);

		CompatibleToBookmarkablePostConverter converter = new CompatibleToBookmarkablePostConverter(
				"/posts/list/20.java", repository, new Slugger());
		String bookmarkableURI = converter.convert();

		assertEquals("/java/20-erich-created-jforum", bookmarkableURI);
	}

	private TopicRepository aRepository() {
		return mock(TopicRepository.class);
	}
}
