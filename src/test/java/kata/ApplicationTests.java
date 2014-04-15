package kata;

import gov.dhs.uscis.kata.repository.ApplicantRepository;
import gov.dhs.uscis.kata.services.ApplicantService;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class,loader=AnnotationConfigContextLoader.class)
public class ApplicationTests {
	@Autowired
	private ApplicantService applicantService;
	@Autowired
	private ApplicantRepository applicantRepository;

	private static ConfigurableApplicationContext context;

	@BeforeClass
	public static void start() throws Exception {
		Future<ConfigurableApplicationContext> future = Executors
				.newSingleThreadExecutor().submit(
						new Callable<ConfigurableApplicationContext>() {
							@Override
							public ConfigurableApplicationContext call()
									throws Exception {
								return SpringApplication.run(Application.class);
							}
						});
		context = future.get(60, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void stop() {
		if (context != null) {
			context.close();
		}
	}

	@Test
	public void contextLoads() {
		Assert.assertNotNull(context);
	}

	@Test
	public void testService() {
		Assert.assertNotNull(applicantService);

	}

	@Test
	public void testRepository() {
		Assert.assertNotNull(applicantRepository);

	}
}
