package daredevil.landlordbankrest.repositories;

import daredevil.landlordbankrest.exceptions.CantMakeTransactionException;
import daredevil.landlordbankrest.models.BankAccount;
import daredevil.landlordbankrest.models.Transactions;
import daredevil.landlordbankrest.repositories.base.TransactionsRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transaction;

@Repository
public class TransactionsRepositoryImpl implements TransactionsRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public TransactionsRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void makeTransaction(BankAccount sender, BankAccount recipient, float amount) throws CantMakeTransactionException {
        try (Session session=sessionFactory.openSession()){
            session.beginTransaction();
            BankAccount sender1=session.get(BankAccount.class, sender.getId());
            if(sender1.getBalance()<amount)
                throw new CantMakeTransactionException();
            else {
                sender1.setBalance(sender1.getBalance()-amount);
                BankAccount recipient1=session.get(BankAccount.class, recipient.getId());
                recipient1.setBalance(recipient.getBalance()+amount);
                Transactions transaction=new Transactions(amount, sender1, recipient1);
                session.save(transaction);
                session.getTransaction().commit();
            }
        } catch (CantMakeTransactionException e){
            throw new CantMakeTransactionException();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
