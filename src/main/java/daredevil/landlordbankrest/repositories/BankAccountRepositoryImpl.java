package daredevil.landlordbankrest.repositories;

import daredevil.landlordbankrest.exceptions.CantCreateBankAccountException;
import daredevil.landlordbankrest.models.BankAccount;
import daredevil.landlordbankrest.models.Models.BankAccountModel;
import daredevil.landlordbankrest.repositories.base.BankAccountRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

    SessionFactory sessionFactory;

    @Autowired
    public BankAccountRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public BankAccount getById(int id) throws CantCreateBankAccountException {
        BankAccount bankAccount;
        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
            bankAccount=session.get(BankAccount.class, id);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new CantCreateBankAccountException();
        }

        return bankAccount;
    }

    @Override
    public void addBankAccount(BankAccount bankAccount) {
        try (Session session=sessionFactory.openSession()){
            session.beginTransaction();
            session.save(bankAccount);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void updateBankAccount(int id, BankAccount bankAccount) {
        try(Session session=sessionFactory.openSession()){
            session.beginTransaction();
            BankAccount bankAccountToChange=session.get(BankAccount.class, id);

            bankAccountToChange.setBalance(bankAccount.getBalance());
            bankAccountToChange.setIban(bankAccount.getIban());

            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteBankAccount(int id) {
        try (Session session=sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(getById(id));
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public BankAccount getBankAccountByIban(String iban) {
        BankAccount bankAccount;
        try (Session session=sessionFactory.openSession()){
            session.beginTransaction();
            bankAccount=session.createQuery("from BankAccount where iban = :ibanStr", BankAccount.class).setParameter("ibanStr", iban).getSingleResult();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
        return bankAccount;
    }

}
