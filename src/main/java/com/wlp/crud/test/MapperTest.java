package com.wlp.crud.test;

import com.wlp.crud.bean.Department;
import com.wlp.crud.bean.Employee;
import com.wlp.crud.dao.DepartmentMapper;
import com.wlp.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author wlp
 * @create 2021-04-16 20:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;
    @Test
    public void testCRUD(){
        /*//1.创建SpringIOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.从容器中获取mapper
        DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);*/
//        System.out.println(departmentMapper);
//        departmentMapper.insertSelective(new Department(null,"开发部"));
//        departmentMapper.insertSelective(new Department(null,"测试部"));



//        employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@wlp.com",1));
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
            mapper.insertSelective(new Employee(null,uid,"M",uid + "@wlp.com",1));
        }
        System.out.println("批量完成");
//        使用可以批量操作的sqlSession





    }
}
