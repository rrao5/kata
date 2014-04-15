package kata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;
import gov.dhs.uscis.kata.domain.Applicant;
import gov.dhs.uscis.kata.repository.ApplicantRepository;
import gov.dhs.uscis.kata.services.ApplicantService;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("gov.dhs.uscis.kata.services")
@EnableTransactionManagement

@EnableAutoConfiguration

@EnableJpaRepositories("gov.dhs.uscis.kata.repository")
public class Application  extends SpringBootServletInitializer {
	
	@Autowired
	static ApplicantService applicantService;
	@Autowired
	static ApplicantRepository applicantRepository;

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(H2).
        		build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource);
        lef.setJpaVendorAdapter(jpaVendorAdapter);
        lef.setPackagesToScan("gov.dhs.uscis.kata.domain");
        return lef;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(false);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.H2);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }


    public static void main(String[] args) {
 
    		SpringApplication.run(Application.class, args);
     }

/*	private static void run() {
		//AbstractApplicationContext context = new AnnotationConfigApplicationContext("gov.dhs.uscis.kata.repository");
        //applicantRepository = context.getBean(ApplicantRepository.class);
//        AbstractApplicationContext context1 = new AnnotationConfigApplicationContext("gov.dhs.uscis.kata.services");
        //applicantService = context.getBean(ApplicantService.class);
        // save a couple of Applicants
        Applicant a1 = new Applicant();
        a1.setFirstName("Jack");
        a1.setLastName("Bauer");

        Applicant a2 = new Applicant();
        a2.setFirstName("Kim");
        a2.setLastName("Bauer");

        Applicant a3 = new Applicant();
        a3.setFirstName("David");
        a3.setLastName("Palmer");
        
        Applicant a4 = new Applicant();
        a4.setFirstName("Michelle");
        a4.setLastName("Dessler");

        Applicant a5 = new Applicant();
        a4.setFirstName("Mickey");
        a4.setLastName("Mouse");

        applicantService.createApplicant(a1);
        applicantService.createApplicant(a2);
        applicantService.createApplicant(a3);
        applicantService.createApplicant(a4);
        applicantService.createApplicant(a5);

        // fetch all Applicants
        Iterable<Applicant> Applicants = applicantRepository.findAll();
        System.out.println("Applicants found with findAll():");
        System.out.println("-------------------------------");
        for (Applicant Applicant : Applicants) {
            System.out.println(Applicant);
        }
        System.out.println();

        // fetch an individual Applicant by ID
        Applicant Applicant = applicantRepository.findOne(1L);
        System.out.println("Applicant found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(Applicant);
        System.out.println();

        // fetch Applicants by last name
        List<Applicant> bauers = applicantRepository.findByLastName("Bauer");
        System.out.println("Applicant found with findByLastName('Bauer'):");
        System.out.println("--------------------------------------------");
        for (Applicant bauer : bauers) {
            System.out.println(bauer);
        }

        //context.close();
        //context1.close();
	}*/
}
