package sunat.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class ContactDAO extends AbstractDAO<Contact> {

    public ContactDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    public Contact findById(final long id){
        return get(id);
    }
    public Contact create(Contact contact){
        return persist(contact);
    }
    public List<Contact> getAll(){
        return this.currentSession().createCriteria(Contact.class).list();
    }
    public void delete (Contact contact){
        this.currentSession().delete(contact);
    }
    public Contact update (Contact contact){
        return this.persist(contact);
    }
}

