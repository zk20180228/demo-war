package cn.ctcc.base;

import cn.ctcc.util.PageUtil;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

/**
 * @Auther: zhangkui
 * @Date: 2018/7/16 16:22
 * @Description:基础业务层接口实现类
 * 要想使用该类，必须的规则如下：
 * T:表示实体的类名(真是类型)如：User
 * protected UserMapper userMapper 那个模块使用,必须自己在自己的类中注入Mapper对象，对象的命名必须是实体的简单名+Mapper,并且开头字母小写
 *
 */

public class BaseServiceImpl<T> implements BaseService<T> {

        protected BaseMapper<T> baseMapper;


        @PostConstruct//执行顺序：Constructor >> @Autowired >> @PostConstruct
        private void initBaseMapper() throws Exception {

            ParameterizedType p= (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<T> clazz = (Class<T>) p.getActualTypeArguments()[0];
            String actualField = clazz.getSimpleName().substring(0, 1).toLowerCase() + clazz.getSimpleName().substring(1) + "Mapper";

            Field targetField = this.getClass().getDeclaredField(actualField);
            targetField.setAccessible(true);
            Field proxyField = this.getClass().getSuperclass().getDeclaredField("baseMapper");
            proxyField.set(this,targetField.get(this));
        }



        @Transactional
        @Override
        public int insert(T t) throws Exception{

            return baseMapper.insert(t);
        }

        @Transactional
        @Override
        public void update(T t) throws Exception{

            baseMapper.update(t);
        }

         @Transactional
        @Override
        public int delete(T t) throws Exception{

            return baseMapper.delete(t);
        }

        @Transactional
        @Override
        public int deleteList(String[] ids) throws Exception{

            return baseMapper.deleteList(ids);
        }

        @Override
        public T select(T t) throws Exception{

            return baseMapper.select(t);
        }

        @Override
        public PageUtil<T> selectListByPage(PageUtil<T> page) throws Exception{

            page.setList(baseMapper.selectListByPage(page));
            page.setTatalRecord(baseMapper.selectTotalCount(page));

            return page;
        }


}
