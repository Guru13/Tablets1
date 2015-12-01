package by.guru13.spring.dao;

import by.guru13.spring.entities.Tablet;

import java.util.List;

/**
 * Интерфейс содержит необходимые операции, связанные
 * с классом Tablet для работы с базой данных
 *<p>
 *
 * @author Alexey Guryanchyck
 */
public interface TabletDAO {

    /**
     * Добавляет Tablet  в базу данных
     *
     * @param tablet новый планшет
     */
    void addTablet(Tablet tablet);

    /**
     * Обновляет Tablet в базе данных, если такой уже есть
     *
     * @param tablet планшет для обновления
     */
    void updateTablet(Tablet tablet);

    /**
     * Возвращает все имеющиеся планшеты в базе данных
     *
     * @return все планшеты
     */
    List<Tablet> listTablets();


    /**
     * Возвращает планшет по его id
     *
     * @param id идентификатор планшета
     * @return планшет
     */
    Tablet getTabletById(int id);

    /**
     * Удаляет планшет из базы данных по его id
     *
     * @param id идентификатор для удаления планшета
     */
    void removeTablet(int id);


}
