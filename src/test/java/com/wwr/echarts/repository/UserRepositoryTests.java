package com.wwr.echarts.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

	@Autowired
	@Qualifier("entityManagerPrimary")
	private EntityManager em;

//	@Resource
//	private UserTest1Repository userTest1Repository;
//	@Resource
//	private UserTest2Repository userTest2Repository;
//
//	@Test
//	public void testSave() throws Exception {
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
//		String formattedDate = dateFormat.format(date);
//
//		userTest1Repository.save(new User("aa", "aa123456","aa@126.com", "aa",  formattedDate));
//		userTest1Repository.save(new User("bb", "bb123456","bb@126.com", "bb",  formattedDate));
//		userTest2Repository.save(new User("cc", "cc123456","cc@126.com", "cc",  formattedDate));
//	}
//
//
//	@Test
//	public void testDelete() throws Exception {
//		userTest1Repository.deleteAll();
//		userTest2Repository.deleteAll();
//	}
//
//	@Test
//	public void testBaseQuery() {
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
//		String formattedDate = dateFormat.format(date);
//		User user=new User("ff", "ff123456","ff@126.com", "ff",  formattedDate);
//		userTest1Repository.findAll();
//		userTest2Repository.findById(3l);
//		userTest2Repository.save(user);
//		user.setId(2l);
//		userTest1Repository.delete(user);
//		userTest1Repository.count();
//		userTest2Repository.findById(3l);
//	}

	@Test
	public void test() throws Exception {
		Query query = em.createNativeQuery("select * from user");
		List list = query.getResultList();
		try{
			//获取到二维数据时
			Object[] cells = (Object[])list.get(0);
			String [][] source = new String[cells.length][list.size()];
			for (int i=0;i<list.size();i++){
				cells = (Object[])list.get(i);
				for (int j=0;j<cells.length;j++){
					source[j][i] = cells[j].toString();
					System.out.println(cells[j].toString());
				}
			}
		}catch (ClassCastException e){
			//获取到一维数组时
			String[][] source = new String[1][list.size()];
			for (int i = 0; i < list.size(); i++) {
				Object cell = list.get(i);
				source[0][i] = cell.toString();
				System.out.println(cell.toString());
			}

		} catch(Exception ex){
			System.out.println("------------------");
			System.out.println(ex.toString());
		}

	}


}