package lt.vu.mybatis.model;

public class Developer {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DEVELOPER.ID
     *
     * @mbg.generated Mon Mar 28 21:05:48 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DEVELOPER.NAME
     *
     * @mbg.generated Mon Mar 28 21:05:48 EEST 2022
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DEVELOPER.ID
     *
     * @return the value of PUBLIC.DEVELOPER.ID
     *
     * @mbg.generated Mon Mar 28 21:05:48 EEST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DEVELOPER.ID
     *
     * @param id the value for PUBLIC.DEVELOPER.ID
     *
     * @mbg.generated Mon Mar 28 21:05:48 EEST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DEVELOPER.NAME
     *
     * @return the value of PUBLIC.DEVELOPER.NAME
     *
     * @mbg.generated Mon Mar 28 21:05:48 EEST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DEVELOPER.NAME
     *
     * @param name the value for PUBLIC.DEVELOPER.NAME
     *
     * @mbg.generated Mon Mar 28 21:05:48 EEST 2022
     */
    public void setName(String name) {
        this.name = name;
    }
}