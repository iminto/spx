package spx.baicai.dao;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import spx.baicai.model.User;

@Repository
@SqlResource("user")
public interface UserDao extends BaseMapper<User> {

    int getCountWithName(@Param("name") String name);
    User getFirstUser();
}
