package daredevil.landlordbankrest;

import daredevil.landlordbankrest.models.BankAccount;
import daredevil.landlordbankrest.models.Transactions;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.hibernate.cfg.Configuration;

@SpringBootApplication
public class LandlordBankrestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LandlordBankrestApplication.class, args);
    }

    @Bean
    public SessionFactory sessionFactory(){
        return new Configuration()
                .configure()
                .addAnnotatedClass(BankAccount.class)
                .addAnnotatedClass(Transactions.class)
                .buildSessionFactory();
    }
}
