package by.guru13.spring.dao;

import java.util.List;

import by.guru13.spring.entities.Tablet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Класс реализует  необходимые операции, связанные
 * с классом Tablet для работы с базой данных
 *<p>
 *
 * @author Alexey Guryanchyck
 */
@Repository
public class TabletDAOImpl implements TabletDAO {

    private static final Logger logger = LoggerFactory.getLogger(TabletDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    /**
     * Добавляет Tablet  в базу данных
     *
     * @param tablet новый планшет
     */
    @Override
    public void addTablet(Tablet tablet) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(tablet);
        logger.info("Tablet saved successfully, Tablet Details=" + tablet);
    }

    /**
     * Обновляет Tablet в базе данных, если такой уже есть
     *
     * @param tablet планшет для обновления
     */
    @Override
    public void updateTablet(Tablet tablet) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(tablet);
        logger.info("Tablet updated successfully, Tablet Details=" + tablet);
    }

    /**
     * Возвращает все имеющиеся планшеты в базе данных
     *
     * @return все планшеты
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Tablet> listTablets() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Tablet> tabletsList = session.createQuery("from Tablet").list();
        for (Tablet tablet : tabletsList) {
            logger.info("Tablet List::" + tablet);
        }
        return tabletsList;
    }

    /**
     * Возвращает планшет по его id
     *
     * @param id идентификатор планшета
     * @return планшет
     */
    @SuppressWarnings("unchecked")
    @Override
    public Tablet getTabletById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Tablet tablet = (Tablet) session.load(Tablet.class, new Integer(id));
        logger.info("Tablet loaded successfully, Tablet details=" + tablet);
        return tablet;
    }

    /**
     * Удаляет планшет из базы данных по его id
     *
     * @param id идентификатор для удаления планшета
     */
    @Override
    public void removeTablet(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Tablet tablet = (Tablet) session.load(Tablet.class, new Integer(id));
        if (null != tablet) {
            session.delete(tablet);
        }
        logger.info("Tablet deleted successfully, Tablet details=" + tablet);
    }
}

