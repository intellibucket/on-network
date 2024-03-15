package az.rock.flyjob.js.dataaccess.repository.abstracts.batis;

import az.rock.flyjob.js.dataaccess.model.batis.model.InterestCompose;
import az.rock.flyjob.js.dataaccess.model.batis.model.InterestComposeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InterestBatisRepository {
    long countByExample(InterestComposeExample example);

    int deleteByExample(InterestComposeExample example);

    int deleteByPrimaryKey(Object uuid);

    int insert(InterestCompose record);

    int insertSelective(InterestCompose record);

    List<InterestCompose> selectByExample(InterestComposeExample example);

    InterestCompose selectByPrimaryKey(Object uuid);

    int updateByExampleSelective(@Param("record") InterestCompose record, @Param("example") InterestComposeExample example);

    int updateByExample(@Param("record") InterestCompose record, @Param("example") InterestComposeExample example);

    int updateByPrimaryKeySelective(InterestCompose record);

    int updateByPrimaryKey(InterestCompose record);
}