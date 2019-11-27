package com.jtm.mapper;

import com.jtm.dto.JBSiglePlayer;
import com.jtm.dto.JBSiglePlayerExample;
import com.jtm.dto.JBSiglePlayerKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JBSiglePlayerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbsigleplayer
     *
     * @mbggenerated Wed Nov 27 21:06:44 CST 2019
     */
    int countByExample(JBSiglePlayerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbsigleplayer
     *
     * @mbggenerated Wed Nov 27 21:06:44 CST 2019
     */
    int deleteByExample(JBSiglePlayerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbsigleplayer
     *
     * @mbggenerated Wed Nov 27 21:06:44 CST 2019
     */
    int deleteByPrimaryKey(JBSiglePlayerKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbsigleplayer
     *
     * @mbggenerated Wed Nov 27 21:06:44 CST 2019
     */
    int insert(JBSiglePlayer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbsigleplayer
     *
     * @mbggenerated Wed Nov 27 21:06:44 CST 2019
     */
    int insertSelective(JBSiglePlayer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbsigleplayer
     *
     * @mbggenerated Wed Nov 27 21:06:44 CST 2019
     */
    List<JBSiglePlayer> selectByExample(JBSiglePlayerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbsigleplayer
     *
     * @mbggenerated Wed Nov 27 21:06:44 CST 2019
     */
    JBSiglePlayer selectByPrimaryKey(JBSiglePlayerKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbsigleplayer
     *
     * @mbggenerated Wed Nov 27 21:06:44 CST 2019
     */
    int updateByExampleSelective(@Param("record") JBSiglePlayer record, @Param("example") JBSiglePlayerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbsigleplayer
     *
     * @mbggenerated Wed Nov 27 21:06:44 CST 2019
     */
    int updateByExample(@Param("record") JBSiglePlayer record, @Param("example") JBSiglePlayerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbsigleplayer
     *
     * @mbggenerated Wed Nov 27 21:06:44 CST 2019
     */
    int updateByPrimaryKeySelective(JBSiglePlayer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jbsigleplayer
     *
     * @mbggenerated Wed Nov 27 21:06:44 CST 2019
     */
    int updateByPrimaryKey(JBSiglePlayer record);
}