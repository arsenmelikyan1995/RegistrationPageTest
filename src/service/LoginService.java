package service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.User;

public class LoginService {

  private static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

  // static Pattern object, since pattern is fixed
  private Pattern pattern;
  private Matcher matcher;

  public LoginService() {
    pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
  }

  public boolean authenticate(String email, String password) {
    User user = getUserByEmail(email);
    if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password)) {
      return true;
    } else {
      return false;
    }
  }

  public User getUserByEmail(String email) {
    Session session = HibernateUtil.openSession();
    Transaction tx = null;
    User user = null;
    try {
      tx = session.getTransaction();
      tx.begin();
      Query query = session.createQuery("from User where email ='" + email + "'");
      user = (User) query.uniqueResult();
      tx.commit();
    } catch (Exception e) {
      if (tx != null) {
        tx.rollback();
      }
      e.printStackTrace();
    } finally {
      session.close();
    }
    return user;
  }

  public List<User> getListOfUsers() {
    List<User> list = new ArrayList<User>();
    Session session = HibernateUtil.openSession();
    Transaction tx = null;
    try {
      tx = session.getTransaction();
      tx.begin();
      list = session.createQuery("from User").list();
      tx.commit();
    } catch (Exception e) {
      if (tx != null) {
        tx.rollback();
      }
      e.printStackTrace();
    } finally {
      session.close();
    }
    return list;
  }

  public boolean validateEmail(String email) {
    matcher = pattern.matcher(email);
    return matcher.matches();
  }

}