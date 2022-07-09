package by.naumenka.dao;

import by.naumenka.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest {

    ApplicationContext applicationContext;
    UserDao userDao;
    User user;

    @Before
    public void setup(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        userDao = applicationContext.getBean("userDao", UserDao.class);

        user = Mockito.mock(User.class);
    }

    @Test
    public void createUserTest(){
        Assert.assertNull(userDao.createUser(user));
    }
}