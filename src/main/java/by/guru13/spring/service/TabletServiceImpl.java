package by.guru13.spring.service;

import java.util.List;

import by.guru13.spring.dao.TabletDAO;

import by.guru13.spring.entities.Tablet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Интерфейс содержит необходимые операции, связанные
 * с классом Tablet для работы с базой данных
 *<p>
 *
 * @author Alexey Guryanchyck
 */
@Service
public class TabletServiceImpl implements TabletService {

    private TabletDAO tabletDAO;

    public void setTabletDAO(TabletDAO tabletDAO) {
        this.tabletDAO = tabletDAO;
    }

    /**
     * Добавляет Tablet  в базу данных
     *
     * @param tablet новый планшет
     */
    @Override
    @Transactional
    public void addTablet(Tablet tablet) {
        this.tabletDAO.addTablet(tablet);
    }

    /**
     * Обновляет Tablet в базе данных, если такой уже есть
     *
     * @param tablet планшет для обновления
     */
    @Override
    @Transactional
    public void updateTablet(Tablet tablet) {
        this.tabletDAO.updateTablet(tablet);
    }

    /**
     * Возвращает все имеющиеся планшеты в базе данных
     *
     * @return все планшеты
     */
    @Override
    @Transactional
    public List<Tablet> listTablets() {
        return this.tabletDAO.listTablets();
    }

    /**
     * Возвращает планшет по его id
     *
     * @param id идентификатор планшета
     * @return планшет
     */
    @Override
    @Transactional
    public Tablet getTabletById(int id) {
        return this.tabletDAO.getTabletById(id);
    }

    /**
     * Удаляет планшет из базы данных по его id
     *
     * @param id идентификатор для удаления планшета
     */
    @Override
    @Transactional
    public void removeTablet(int id) {
        this.tabletDAO.removeTablet(id);
    }
}

