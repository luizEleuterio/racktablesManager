package br.jus.trtsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO {
	protected EntityManagerFactory emf;
    protected EntityManager em;
    
    public GenericDAO(String persistenceUnit){
    	emf = Persistence.createEntityManagerFactory(persistenceUnit);
    	em = emf.createEntityManager();
    }
    
    public void close(){
    	em.close();
        emf.close();
    } 
    
    public Object incluir(Object obj){
    	
    	try{
	    	em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
    	}catch(Exception e){
    		e.printStackTrace();
    		em.getTransaction().rollback();
    	}
    	return obj;
	}
 
    public Object alterar(Object obj){
    	try{
	    	em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
    	}catch(Exception e){
    		e.printStackTrace();
    		em.getTransaction().rollback();
    	}
    	return obj;
    }
 
    public void excluir(Object obj){
    	try{
	    	em.getTransaction().begin();
	        em.remove(obj);
	        em.getTransaction().commit();
    	}catch(Exception e){
    		e.printStackTrace();
    		em.getTransaction().rollback();
    	}
    
    }
    
    public Object encontrarPorId(Integer id, Class clazz){
        return em.find(clazz, id);
    }
 
    public List listAll(Class clazz){
    	StringBuilder q = new StringBuilder();
    	q.append("select o from ");
    	q.append(clazz.getName());
    	q.append(" o ");
    	return em.createQuery(q.toString(), clazz).getResultList();
    }

}
