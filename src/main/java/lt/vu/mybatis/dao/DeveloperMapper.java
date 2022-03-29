package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Developer;

public interface DeveloperMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DEVELOPER
     *
     * @mbg.generated Mon Mar 28 21:05:48 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DEVELOPER
     *
     * @mbg.generated Mon Mar 28 21:05:48 EEST 2022
     */
    int insert(Developer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DEVELOPER
     *
     * @mbg.generated Mon Mar 28 21:05:48 EEST 2022
     */
    Developer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DEVELOPER
     *
     * @mbg.generated Mon Mar 28 21:05:48 EEST 2022
     */
    List<Developer> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DEVELOPER
     *
     * @mbg.generated Mon Mar 28 21:05:48 EEST 2022
     */
    int updateByPrimaryKey(Developer record);
}